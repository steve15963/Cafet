package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
	INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid parameter included: 테스트중"),
	RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not exists: 테스트중"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error: 테스트중"),
	;

	private final HttpStatus httpStatus;
	private final String message;
}
