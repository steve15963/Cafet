package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GradeErrorCode implements ErrorCode{
	GRADE_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 해당 유저가 가게에 남긴 별점이 없습니다"),
	;
	
	private final HttpStatus httpStatus;
	private final String message;
}
