package xxx.petmanbe.user.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.userfile.entity.UserFile;

@Getter
@NoArgsConstructor
public class UserFilesListDto {

	private String userUrl;


	public UserFilesListDto(UserFile userfile) {
		this.userUrl= userfile.getUserUrl();
	}


}
