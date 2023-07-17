package xxx.petmanbe.user.dto.responseDto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.user.entity.Level;

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

	private Level level;

	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;

}
