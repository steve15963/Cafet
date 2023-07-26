package xxx.petmanbe.user.dto.requestDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.user.entity.Level;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelModifyDto {

	private Long userId;

	private int level;

}
