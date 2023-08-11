package xxx.petmanbe.Location.dto.requestDto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AddPetLocationRequestDto {
	public long shopId;
	public long petId;
	private List<Double> beaconList;
	private List<Long> key;
	private double temp;
}

