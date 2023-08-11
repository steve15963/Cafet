package xxx.petmanbe.exception.errorcode;

import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileErrorCode implements ErrorCode {
	FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 파일 없음"),
	;

	private final HttpStatus httpStatus;
	private final String message;
}
