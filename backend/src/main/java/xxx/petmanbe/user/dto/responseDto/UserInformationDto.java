package xxx.petmanbe.user.dto.responseDto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInformationDto {

	private String email;

	private String phoneNo;

	private String nickname;

	private String status;

	private int levelCode;

	private List<String> role;

	private LocalDateTime createdTime;

	private LocalDateTime updatedTime;

	private UserFilesListDto userFile;

}
