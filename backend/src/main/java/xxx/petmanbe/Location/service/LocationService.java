package xxx.petmanbe.Location.service;

import xxx.petmanbe.Location.dto.requestDto.AddPetLocationRequestDto;
import xxx.petmanbe.Location.entity.PetLocation;

public interface LocationService {
	PetLocation getTrilateration(AddPetLocationRequestDto addPetLocationRequestDto);

}
