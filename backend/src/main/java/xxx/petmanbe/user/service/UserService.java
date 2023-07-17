package xxx.petmanbe.user.service;

import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.ModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.entity.Token;

public interface UserService {

	public String postnewUser(RegistDto registDto) throws Exception;

	public Token postLoginUser(LoginDto loginDto) throws Exception;

	public String putUser(ModifyDto modifyDto) throws Exception;



}
