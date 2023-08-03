package xxx.petmanbe.user.service;

import java.util.List;
import java.util.Optional;

import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.RefreshJwtDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;
import xxx.petmanbe.user.entity.Token;
import xxx.petmanbe.user.entity.User;

public interface UserService {

	public long postnewUser(RegistDto registDto) throws Exception;

	public boolean checkUserLogin(LoginDto loginDto) throws Exception;

	 public Token postLoginUser(LoginDto loginDto) throws Exception;

	public boolean putUser(UserModifyDto userModifyDto) throws Exception;

	public UserInformationDto getUser(long userId) throws Exception;

//	public User SessionLogin(LoginDto loginDto) throws Exception;

	public List<UserListDto> getUserList();

	public String deleteUser(long userId);

	public String putUserLevel(LevelModifyDto levelModifyDto);


}
