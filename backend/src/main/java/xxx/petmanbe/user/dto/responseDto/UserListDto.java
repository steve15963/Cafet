package xxx.petmanbe.user.dto.responseDto;

import java.time.LocalDateTime;


public interface UserListDto {
	long getUserId();

	String getEmail();

	String getPhoneNo();

	String getNickname();

	String getStatus();

	int getLevel();

	LocalDateTime getCreatedTime();

	LocalDateTime getUpdatedTime();

}

