package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

	// 발생한 예외/에러 이름
	String name();

	// HTTP status 코드
	HttpStatus getHttpStatus();

	// 상세 에러 정보
	String getMessage();
}
