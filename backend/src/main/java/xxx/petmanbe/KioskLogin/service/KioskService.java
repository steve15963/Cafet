package xxx.petmanbe.KioskLogin.service;

import xxx.petmanbe.KioskLogin.dto.responseDto.KioskLoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;

public interface KioskService {

    public KioskLoginReturnDto checkShop(LoginDto loginDto);
}
