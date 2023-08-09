package xxx.petmanbe.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.exception.errorcode.ErrorCode;

@Getter
@RequiredArgsConstructor
public class RestApiException extends RuntimeException{

	private final ErrorCode errorCode;
}
