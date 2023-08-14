package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VisitErrorCode implements ErrorCode {
	VISIT_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 해당 유저의 가게 방문 기록이 없습니다"),
	;

	private final HttpStatus httpStatus;
	private final String message;
}
