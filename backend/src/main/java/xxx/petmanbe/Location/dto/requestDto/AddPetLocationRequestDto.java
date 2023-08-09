package xxx.petmanbe.Location.dto.requestDto;

import java.util.List;

import lombok.Setter;

@Setter
public class AddPetLocationRequestDto {
	public long shopId;
	public long petId;
	private List<Double> beaconList;
	private double temp;

	@Override
	public String toString() {
		return "AddPetLocationRequestDto{" +
			"shopId=" + shopId +
			", petId=" + petId +
			", BeaconList=" + beaconList +
			", temp=" + temp +
			'}';
	}
}

