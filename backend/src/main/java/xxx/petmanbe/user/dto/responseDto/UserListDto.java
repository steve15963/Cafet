package xxx.petmanbe.user.dto.responseDto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import xxx.petmanbe.user.entity.User;

@Getter
@NoArgsConstructor
public class UserListDto {
	private long userId;

	private String email;

	private String phoneNo;

	private String nickname;

	private String status;

	private int levelCode;

	private LocalDateTime createdTime;

	private LocalDateTime updatedTime;

	// entity to dto
	public UserListDto (User user){
		this.userId = user.getUserId();
		this.email = user.getEmail();
		this.phoneNo = user.getPhoneNo();
		this.nickname = user.getNickname();
		this.status = user.getStatus();
		this.levelCode = user.getLevel().getLevelCode();
		this.createdTime = user.getCreatedTime();
		this.updatedTime = user.getUpdatedTime();
	}
}

