package xxx.petmanbe.user.service;

import java.util.List;

import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.LoginRequestDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Token;

public interface UserService {

	public String postnewUser(RegistDto registDto) throws Exception;

	public LoginRequestDto postLoginUser(LoginDto loginDto) throws Exception;

	public String putUser(UserModifyDto userModifyDto) throws Exception;

	public UserInformationDto getUser(long userId) throws Exception;

	public List<UserListDto> getUserList();

	public String deleteUser(long userId);

	public String putUserLevel(LevelModifyDto levelModifyDto);

}
