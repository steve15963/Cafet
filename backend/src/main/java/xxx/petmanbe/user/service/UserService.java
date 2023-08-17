package xxx.petmanbe.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import xxx.petmanbe.user.dto.other.LoginReturnDto;
import xxx.petmanbe.user.dto.requestDto.LevelModifyDto;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.dto.requestDto.UpdateUserPasswordDto;
import xxx.petmanbe.user.dto.requestDto.UserModifyDto;
import xxx.petmanbe.user.dto.requestDto.RegistDto;
import xxx.petmanbe.user.dto.responseDto.UserInformationDto;
import xxx.petmanbe.user.dto.responseDto.UserListDto;

public interface UserService {

	long postnewUser(RegistDto registDto) throws Exception;

	boolean checkUserLogin(LoginDto loginDto) throws Exception;

	LoginReturnDto postLoginUser(LoginDto loginDto) throws Exception;

	boolean putUser(UserModifyDto userModifyDto) throws Exception;

	UserInformationDto getUser(long userId) throws Exception;

	List<UserListDto> getUserList();

	String deleteUser(long userId);

	String putUserLevel(LevelModifyDto levelModifyDto);

	List<UserListDto> getUserListByEmail(String email);

	List<UserListDto> getUserListByNickname(String nickname);

	boolean changeUserPassword(UpdateUserPasswordDto request);

	void postLogout(HttpServletRequest request);

	boolean checkUserLikeBoard(Long boardId, Long userId);

	boolean checkUserLikeShop(Long userId, Long shopId);
}
