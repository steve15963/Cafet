package xxx.petmanbe.Location.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationWebSocketDto {

	int status;
	double x;
	double y;
	long shopId;
	long petId;


}
