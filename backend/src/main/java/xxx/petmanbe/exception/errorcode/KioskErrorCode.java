package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KioskErrorCode implements ErrorCode{

	;

	private final HttpStatus httpStatus;
	private final String message;
}
