package xxx.petmanbe.user.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModifyDto {

    public String email;

    public String phoneNo;

    public String nickname;

    public String fileUrl;

}
