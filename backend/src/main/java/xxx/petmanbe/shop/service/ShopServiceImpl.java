package xxx.petmanbe.shop.service;

import java.util.List;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import xxx.petmanbe.shop.dto.others.JsonResponse;
import xxx.petmanbe.shop.dto.others.Position;
import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopListDto;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shopPet.dto.response.GetShopPetDto;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;
import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.entity.AttachShop;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.repository.AttachShopRepository;
import xxx.petmanbe.tag.repository.TagRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{

	private final ShopRepository shopRepository;

	private final UserRepository userRepository;

	private final ShopPetRepository shopPetRepository;

	private final TagRepository tagRepository;

	private final AttachShopRepository attachShopRepository;

	@Value("${kakao.map.key}")
	String key;

	// shop 정보를 가져오기
	@Transactional
	@Override
	public GetShopDto getShop(long shopId) {
		Shop shop = shopRepository.findById(shopId).orElseThrow(IllegalArgumentException::new);


		List<GetShopPetDto> getShopPetList = shopPetRepository.findByShop_ShopId(shopId).stream()
			.map(GetShopPetDto::new).collect(Collectors.toList());

		// 태그 정보 가져오기
		List<TagListResponseDto> tagList = attachShopRepository.findByShop_ShopId(shopId).stream()
			.map(AttachShop::getTag)
			.map(TagListResponseDto::new)
			.collect(Collectors.toList());

		GetShopDto getShopDto = GetShopDto.builder()
			.shopId(shop.getShopId())
			.shopTitle(shop.getShopTitle())
			.gradeCount(shop.getGradeCount())
			.totalScore(shop.getTotalScore())
			.longitude(shop.getLongitude())
			.latitude(shop.getLatitude())
			.address(shop.getAddress())
			.phoneNo(shop.getPhoneNo())
			.descriptions(shop.getDescriptions())
			.openedTime(shop.getOpenedTime())
			.closedTime(shop.getClosedTime())
			.sns(shop.getSns())
			.homepage(shop.getHomepage())
			.shopPetList(getShopPetList)
			.tagList(tagList)
			.build();
		
		return getShopDto;
	}

	// shop 정보 추가하기
	@Transactional
	@Override
	public boolean postShopNew(PostNewShopDto postNewShopDto) throws IOException {

		//중복 체크 들어가야 함
		User user = userRepository.findById(postNewShopDto.getUserId()).orElseThrow(IllegalArgumentException::new);

		String address = changeAddress(postNewShopDto.getAddress());
		// address에서 road 구해주고
		String road = getRoad(postNewShopDto.getAddress());
		// longitude, latitude 구해줌
		Position position = addressToPosition(road);

		// System.out.println(address);

		Shop shop = Shop.builder()
			.shopTitle(postNewShopDto.getShopTitle())
			.totalScore(0)
			.gradeCount(0)
			.longitude(position.getLongitude())
			.latitude(position.getLatitude())
			.address(postNewShopDto.getAddress())
			.phoneNo(postNewShopDto.getPhoneNo())
			.descriptions(postNewShopDto.getDescriptions())
			.openedTime(postNewShopDto.getOpenedTime())
			.closedTime(postNewShopDto.getClosedTime())
			.sns(postNewShopDto.getSns())
			.homepage(postNewShopDto.getHomepage())
			.user(user)
			.build();


		// 태그 부착정보 생성
		for (TagListResponseDto response : postNewShopDto.getTagList()){
			// 만약 해당하는 이름의 태그가 없다면
			if (tagRepository.findByStatusFalseAndTagName(response.getTagName()).isEmpty()){
				// 태그 생성
				AddTagRequestDto tagRequest = AddTagRequestDto.builder()
					.tagName(response.getTagName())
					.build();
				tagRepository.save(tagRequest.toEntity());
			}

			// 태그 정보 가져오기
			Optional<Tag> tag = tagRepository.findByStatusFalseAndTagName(response.getTagName());

			// 태그 부착
			AttachShop attachShop = AttachShop.builder()
				.shop(shop)
				.tag(tag.get())
				.build();

			// 태그 부착 데이터 생성
			attachShopRepository.save(attachShop);
		}

		// 가게 데이터 생성
		shopRepository.save(shop);

		return true;
	}

	private String changeAddress(String address) {

		String[] divide = address.split(" ");

		for(int i=0 ; i<divide.length ; i++){

			if(divide[0]=="세종특별자치시") divide[0]="세종";
			else if(divide[0]=="제주특별자치도") divide[0]="제주";

			int len = divide[i].length();
			char s = divide[i].charAt(len-1);
			if(s=='시' || s=='구' || s=='군'){
				divide[i]=divide[i].substring(0,len-1);
			}
		}

		String add ="";
		for(int i=0 ; i<divide.length ; i++){
			add=add.concat(divide[i]+" ");
		}

		return add;
	}

	// shop 정보 수정하기
	@Transactional
	@Override
	public boolean putShop(PutShopDto request) {

		Optional<Shop> shop = shopRepository.findById(request.getShopId());


		// 해당 가게 정보가 있으면 삭제정보 변경, 없으면 예외던짐
		if (shop.isPresent()) {
			shop.get().updateShop(request);

			// 태그 리스트 받아와서 수정하기
			// 기존 태그 목록 확인
			for (AttachShop curTag : attachShopRepository.findByShop_ShopId(request.getShopId())) {

				// 수정된 태그들의 id 리스트
				List<Long> tagIdList = request.getTagList().stream()
					.map(TagListResponseDto::getTagId).collect(Collectors.toList());

				// 만약 해당 id가 없으면
				if (!tagIdList.contains(curTag.getTag().getTagId())){
					// 태그 리스트에서 제거
					attachShopRepository.deleteByShop_ShopIdAndTag_TagId(request.getShopId(), curTag.getTag().getTagId());
				}
			}

			// 새로 추가된 태그 확인
			for (TagListResponseDto updatedTag : request.getTagList()){

				// 현재 등록되어 있는 태그 id 목록
				List<Long> tagList = attachShopRepository.findByShop_ShopId(request.getShopId()).stream()
					.map(AttachShop::getTag)
					.map(Tag::getTagId)
					.collect(Collectors.toList());

				// 업데이트 하려는 태그 id가 목록에 없으면 추가
			/*
				테스트 단계에서는 등록하려는 태그가 생성이 필요한 경우에 에러 발생할 수 있음
				그렇지만 비즈니스 로직 상 태그의 생성은 수정하기 버튼을 누르기(해당 메소드가 실행되는 시점) 전에,
				정확히 가게 정보 수정 창에서 태그 칸에 해당 태그의 이름을 입력하려고 onClick() 이벤트가 발생하는 순간에 일어나므로
				이 상태로 메소드를 유지함
			 */
				if (!tagList.contains(updatedTag.getTagId())){

					// 만약 태그가 없으면 만들기
					if (tagRepository.findByStatusFalseAndTagName(updatedTag.getTagName()).isEmpty()){
						Tag tag = Tag.builder()
							.tagName(updatedTag.getTagName())
							.build();
						tagRepository.save(tag);
					}

					// 부착정보 생성
					Optional<Tag> tag = tagRepository.findByStatusFalseAndTagName(updatedTag.getTagName());
					AttachShop attachShop = AttachShop.builder()
						.tag(tag.get())
						.shop(shop.get())
						.build();

					attachShopRepository.save(attachShop);
				}
			}

			return true;
		}
		else
			return false;
	}

	// shop 정보 수정하기
	@Transactional
	public boolean putShopStatus(Long shopId){

		Optional<Shop> shop = shopRepository.findById(shopId);

		// 해당 가게 정보가 있으면 삭제정보 변경, 없으면 예외던짐
		if (shop.isPresent()) {
			shop.get().changeDeleteStatus();
			return true;
		}
		else
			return false;
	}

	// 전체 가게 보기
	@Override
	public List<GetShopListDto> getShopList() {
		return shopRepository.findByStatusFalse().stream()
			.map(GetShopListDto::new)
			.collect(Collectors.toList());
	}

	// 관리자 기능: 가게 이름으로 검색
	@Override
	public List<GetShopListDto> getShopListByTitle(String shopTitle) {
		return shopRepository.findByStatusFalseAndShopTitleContaining(shopTitle).stream()
			.map(GetShopListDto::new)
			.collect(Collectors.toList());
	}

	// 관리자 기능: 가게 주소로 검색
	@Override
	public List<GetShopListDto> getShopListByAddress(String address) {
		return shopRepository.findByStatusFalseAndAddressContaining(address).stream()
			.map(GetShopListDto::new)
			.collect(Collectors.toList());
	}

	// 해당 태그가 달린 가게 리스트
	@Override
	public List<GetShopListDto> getShopListByTag(String tagName) {
		return attachShopRepository.findByTag_TagName(tagName).stream()
			.map(AttachShop::getShop)
			.map(GetShopListDto::new)
			.collect(Collectors.toList());
	}

	// 지역별로 받기
	 @Override
	 public String getRoad(String address) {

		String[] divide = address.split(" ");
		String road = "";
		int start = -1;

		for(int i=0 ; i< divide.length; i++){
			int len = divide[i].length();
			if(divide[i].charAt(len-1)=='로' || divide[i].charAt(len-1)=='길') {
				start=i;
				break;
			}
		}

		road = divide[start]+divide[start+1];

	 	return road;
	 }

	// 주소(도로명 주소만)를 위도, 경도로 바꾸기
	public Position addressToPosition(String address) throws IOException {

		WebClient webClient = WebClient.builder()
				.baseUrl("https://dapi.kakao.com/v2/local/search/address.json?query="+address)
				.defaultHeader("Authorization",key)
				.build();

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		JsonResponse s = webClient.get()
				.uri(uriBuilder -> uriBuilder.path("").build())
				.retrieve()
				.bodyToMono(JsonResponse.class).block();

		double longitude = s.getDocuments().get(0).x;
		double latitude = s.getDocuments().get(0).y;

		


		return new Position(longitude,latitude);

	}

}
