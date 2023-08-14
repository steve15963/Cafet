package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TagErrorCode implements ErrorCode {
	TAG_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 존재하지 않는 태그입니다."),
	TAG_ALREADY_SAVED(HttpStatus.CONFLICT, "CONFLICT: 이미 존재하는 태그입니다"),
	;

	private final HttpStatus httpStatus;
	private final String message;
}
