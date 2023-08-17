package xxx.petmanbe.Location.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.Location.dto.requestDto.AddPetLocationRequestDto;
import xxx.petmanbe.Location.entity.BeaconLocation;
import xxx.petmanbe.Location.entity.PetLocation;
import xxx.petmanbe.Location.entity.UseBeaconForPetLocation;
import xxx.petmanbe.Location.repository.BeaconLocationRepository;
import xxx.petmanbe.Location.repository.PetLocationRepository;
import xxx.petmanbe.Location.repository.useBeaconForPetLocationRepository;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.PetErrorCode;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;

@Service
@AllArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

	private final ShopRepository shopRepository;

	private final ShopPetRepository shopPetRepository;

	private final PetLocationRepository petLocationRepository;

	private final useBeaconForPetLocationRepository useBeaconForPetLocationRepository;

	private final BeaconLocationRepository beaconLocationRepository;

	/**
	 * 아직 실력이 부족하여 완벽한 구현이 불가능하여
	 * 비콘은 3개라는 가정하에 계산을 진행하는 위치 계산 메소드.
	 * @param addPetLocationRequestDto
	 * @return
	 */
	public PetLocation getTrilateration(AddPetLocationRequestDto addPetLocationRequestDto){
		// List<BeaconLocation> matchBeacon = findMatchBeacon(addPetLocationRequestDto);
		List<BeaconLocation> matchBeacon = beaconLocationRepository.findAll();

		if(matchBeacon == null)
			return null;
		double x1 = matchBeacon.get(0).getX();
		double y1 = matchBeacon.get(0).getY();

		double x2 = matchBeacon.get(1).getX();
		double y2 = matchBeacon.get(1).getY();

		double x3 = matchBeacon.get(2).getX();
		double y3 = matchBeacon.get(2).getY();

		double r1 = addPetLocationRequestDto.getBeaconList().get(0);
		double r2 = addPetLocationRequestDto.getBeaconList().get(1);
		double r3 = addPetLocationRequestDto.getBeaconList().get(2);


		log.info("" + r1);
		log.info("" + r2);
		log.info("" + r3);


		double S = (
			Math.pow(x3,2.) - Math.pow(x2,2.)
			+ Math.pow(y3,2.) - Math.pow(y2,2.)
			+ Math.pow(r2, 2.) - Math.pow(r3, 2.)
			) / 2.0;
		double T = (
			Math.pow(x1,2.0) - Math.pow(x2,2.0)
				+ Math.pow(y1,2.0) - Math.pow(y2,2.0)
				+ Math.pow(r2,2.0) - Math.pow(r1,2.0)
		) / 2.0;

		double y = (
			(
				T *
				(
					x2 - x3
				)
			)
			-
			(
				S *
				(
					x2 - x1
				)
			)
			) /
			(((y1 - y2) * (x2 - x3)) - ((y3-y2) * (x2 - x1)));

		double x = ((y * (y1 - y2)) - T) / (x2 - x1);

		if( x < 0) x *= -1;
		if( y < 0) y *= -1;

		ShopPet shopPet = shopPetRepository.findById(addPetLocationRequestDto.getPetId())
			.orElseThrow(() -> new RestApiException(PetErrorCode.PET_NOT_FOUND));

		PetLocation build = PetLocation.builder()
			.x(x * 100)
			.y(y * 100)
			.z(0)
			.temp(addPetLocationRequestDto.getTemp())
			.shopPet(shopPet)
			.build();

		log.info(build.toString());

		PetLocation save = petLocationRepository.save(build);

		for(BeaconLocation beacon : matchBeacon) {
			useBeaconForPetLocationRepository.save(
				UseBeaconForPetLocation.builder()
					.beaconLocation(beacon)
					.petLocation(save)
					.build()
			);
		}

		log.info("location {}", build );



		return build;
	}

	/**
	 * 요청 값의 비콘들을 찾아서 반환하는 메소드.
	 * @param addPetLocationRequestDto 요청값을 그대로 분석.
	 * @return
	 */
	private List<BeaconLocation> findMatchBeacon(AddPetLocationRequestDto addPetLocationRequestDto){
		Optional<Shop> byId = shopRepository.findById(addPetLocationRequestDto.shopId);
		if(byId.isEmpty()){
			//가게를 찾을 수 없습니다.
			log.info("가게를 찾을 수 없습니다.");
			return null;
		}
		Shop shop = byId.get();

		List<BeaconLocation> beaconLocation = shop.getBeaconLocation();
		List<Long> key = addPetLocationRequestDto.getKey();

		List<BeaconLocation> filterBeaconList = beaconLocation.stream().filter(b -> {
			long bId = b.getBeaconId();
			return key.contains(bId);
		}).collect(Collectors.toList());

		log.info("find beacon List : " + filterBeaconList.toString());

		return filterBeaconList;
	}
}
