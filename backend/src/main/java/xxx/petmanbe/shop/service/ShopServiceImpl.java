package xxx.petmanbe.shop.service;

import java.util.List;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
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
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{

	private final ShopRepository shopRepository;

	private final UserRepository userRepository;

	private final ShopPetRepository shopPetRepository;

	@Value("${kakao.map.key}")
	String key;

	// shop 정보를 가져오기
	@Transactional
	@Override
	public GetShopDto getShop(long shopId) {
		Shop shop = shopRepository.findById(shopId).orElseThrow(()->new IllegalArgumentException());


		List<GetShopPetDto> getShopPetList = shopPetRepository.findByShop_ShopId(shopId).stream()
			.map(GetShopPetDto::new).collect(Collectors.toList());


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
			.build();
		
		return getShopDto;
	}

	// shop 정보 추가하기
	@Transactional
	@Override
	public boolean postShopNew(PostNewShopDto postNewShopDto) throws IOException {

		//중복 체크 들어가야 함

		User user = userRepository.findById(postNewShopDto.getUserId()).orElseThrow(()->new IllegalArgumentException());

		if(user.getLevel().getLevelCode() >100){

			// address에서 road 구해주고
			String road = getRoad(postNewShopDto.getAddress());
			// longitude, latitude 구해줌
			Position position = addressToPosition(road);

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

			shopRepository.save(shop);

			return true;

		}else{

			return false;
		}
	}

	// sho 정보 수정하기
	@Transactional
	@Override
	public boolean putShop(PutShopDto request) {

		Shop shop = shopRepository.findById(request.getShopId()).orElseThrow(()->new IllegalArgumentException());
		
		shop.updateShop(request.getShopTitle(), request.getTotalScore(), request.getGradeCount(), request.getLongitude(), request.getLatitude(),
			request.getAddress(), request.getPhoneNo(), request.getDescriptions(), request.getOpenedTime(), request.getClosedTime()
		,request.getSns(), request.getHomepage());

		shopRepository.save(shop);

		return true;
	}

	// shop 정보 수정하기
	@Transactional
	public Shop putShopStatus(Long shopId){

		Shop shop = shopRepository.findById(shopId).
			orElseThrow(() -> new IllegalArgumentException("not found"));

		shop.changeDeleteStatus();

		return shop;
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

	// 지역별로 받기
	 @Override
	 public String getRoad(String address) {

		String[] divide = address.split(" ");
		String road = "";

		for(int i=0 ; i< divide.length; i++){
			if(divide[i].charAt(-1)=='로' || divide[i].charAt(-1)=='길') road = divide[i];
		}

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
