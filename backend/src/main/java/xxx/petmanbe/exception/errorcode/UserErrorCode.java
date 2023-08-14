package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 존재하지 않는 사용자입니다."),
	USER_ALREADY_SAVED(HttpStatus.CONFLICT, "CONFLICT: 이미 존재하는 사용자입니다"),
	USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED: 해당 사용자 권한 없음")
	;

	public final HttpStatus httpStatus;

	public final String message;
}
