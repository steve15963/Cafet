package xxx.petmanbe.Location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xxx.petmanbe.Location.dto.VO.Point;
import xxx.petmanbe.Location.dto.responseDto.HitMapResponseDto;
import xxx.petmanbe.Location.entity.PetLocation;
import xxx.petmanbe.Location.repository.PetLocationRepository;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;

@Service
@AllArgsConstructor
public class HitMapServiceImpl implements HitMapService{

	private final PetLocationRepository petLocationRepository;

	private final ShopPetRepository shopPetRepository;
	@Override
	public HitMapResponseDto getHitMap(long animalId) {
		Optional<ShopPet> byId = shopPetRepository.findById(animalId);
		if(byId.isEmpty())
			return null;

		ShopPet shopPet = byId.get();

		List<PetLocation> locations = petLocationRepository.findTop1000PetLocationsByShopPetOrderByCreatedTime(shopPet);

		HitMapResponseDto hitMapResponseDto = new HitMapResponseDto();

		hitMapResponseDto.setMax(locations.size());

		List<Point> data = hitMapResponseDto.getData();

		for(PetLocation petLocation : locations){
			data.add(
				new Point(Math.round(petLocation.getX()),Math.round(petLocation.getY()),1L)
			);
		}
		return hitMapResponseDto;
	}
}