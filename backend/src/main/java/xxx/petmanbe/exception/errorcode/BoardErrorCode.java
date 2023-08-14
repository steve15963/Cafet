package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardErrorCode implements ErrorCode{
	BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 존재하지 않는 게시글입니다."),
	BOARD_ALREADY_SAVED(HttpStatus.CONFLICT, "CONFLICT: 이미 존재하는 게시글입니다"),
	BOARD_ALREADY_LIKED(HttpStatus.METHOD_NOT_ALLOWED, "METHOD NOT ALLOWED: 이미 좋아요 한/하지 않은 게시글입니다"),
	;

	public final HttpStatus httpStatus;

	public final String message;
}
