package xxx.petmanbe.user.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.userfile.entity.UserFile;

@Getter
@NoArgsConstructor
public class UserFilesListDto {

	private String userUrl;

	@Builder
	public UserFilesListDto(UserFile userfile) {
		this.userUrl= userfile.getUserUrl();
	}
}
