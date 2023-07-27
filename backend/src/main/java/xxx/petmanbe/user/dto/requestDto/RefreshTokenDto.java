package xxx.petmanbe.user.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDto {

    private String userId;

    private String refreshToken;


}
