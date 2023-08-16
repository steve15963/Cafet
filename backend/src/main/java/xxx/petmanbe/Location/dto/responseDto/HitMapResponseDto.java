package xxx.petmanbe.Location.dto.responseDto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import xxx.petmanbe.Location.dto.VO.Point;

@Getter
@Setter
@ToString
public class HitMapResponseDto {
	long max;
	List<Point> data;

	public HitMapResponseDto() {
		max = 0;
		data = new ArrayList<>();
	}
}