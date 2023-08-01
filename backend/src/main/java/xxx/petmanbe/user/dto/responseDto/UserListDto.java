package xxx.petmanbe.user.dto.responseDto;

import java.time.LocalDateTime;

import xxx.petmanbe.user.entity.Level;

public interface UserListDto {
	long getUserId();

	String getEmail();

	String getPhoneNo();

	String getNickname();

	String getStatus();

	int getLevel_LevelCode();

	LocalDateTime getCreatedTime();

	LocalDateTime getUpdatedTime();

}

