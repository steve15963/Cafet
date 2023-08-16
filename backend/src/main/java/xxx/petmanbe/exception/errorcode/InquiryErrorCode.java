package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InquiryErrorCode implements ErrorCode {
	INQUIRY_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 해당하는 문의글이 없습니다.")
	;

	private final HttpStatus httpStatus;
	private final String message;
}
