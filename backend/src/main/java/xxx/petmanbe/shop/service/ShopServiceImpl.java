package xxx.petmanbe.shop.service;

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
import xxx.petmanbe.shop.dto.requestDto.PostNewShopDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
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
	public boolean postShopNew(PostNewShopDto postNewShopDto) {

		//중복 체크 들어가야 함

		User user = userRepository.findById(postNewShopDto.getUserId()).orElseThrow(()->new IllegalArgumentException());

		if(user.getLevel().getLevelCode() >100){

			Shop shop = Shop.builder()
				.shopTitle(postNewShopDto.getShopTitle())
				.totalScore(0)
				.gradeCount(0)
				.longitude(postNewShopDto.getLongitude())
				.latitude(postNewShopDto.getLatitude())
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

	// 지역별로 받기
	// @Override
	// public List<Shop> getShopRegionList(String sidoName, String gugunName, String dongName) {
	//
	// 	String dongCode = dongCodeRepository.findDongCodeBySidoNameAndGugunNameAndDongName(sidoName, gugunName, dongName);
	//
	// 	List<Shop> shop = shopRepository.findByDongCode(dongCode).orElseThrow(()->new IllegalArgumentException());
	//
	// 	return shop;
	// }


	public String addressToPosition(String address) throws IOException {

		HttpClient client = HttpClientBuilder.create().build();

		HttpGet getRequest = new HttpGet("https://dapi.kakao.com/v2/local/search/address.json?query="+address);
		getRequest.addHeader("Authorization","KakaoAk "+key);

		HttpResponse response = client.execute(getRequest);

		ResponseHandler<String> handler = new BasicResponseHandler();
		String body = handler.handleResponse(response);

		System.out.println(body);

		return body;

	}

}
