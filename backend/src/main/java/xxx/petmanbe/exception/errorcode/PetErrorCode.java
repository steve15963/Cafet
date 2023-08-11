package xxx.petmanbe.exception.errorcode;

import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PetErrorCode implements ErrorCode {
	PET_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 없는 동물입니다"),
	PET_ALREADY_SAVED(HttpStatus.CONFLICT, "CONFLICT: 이미 등록된 동물입니다")
	;

	private final HttpStatus httpStatus;
	private final String message;
}
