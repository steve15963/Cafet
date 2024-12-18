package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
	INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "INVALID PARAMETER INCLUDED: 유효하지 않은 파라미터 값"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR: 서버 에러"),
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD REQUEST: 잘못된 요청")
	;

	private final HttpStatus httpStatus;
	private final String message;
}
