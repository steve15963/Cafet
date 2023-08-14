package xxx.petmanbe.Location.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import xxx.petmanbe.Location.entity.PetLocation;

@Getter
@Setter
public class PetLocationResponseDto {
	int status;
	double x;
	double y;

	public PetLocationResponseDto(PetLocation petLocation) {
		if (petLocation == null){
			status = 1;
			this.x = 0;
			this.y = 0;
		}
		else {
			status = 0;
			this.x = petLocation.getX();
			this.y = petLocation.getY();
		}
	}
}
