package xxx.petmanbe.exception.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ShopErrorCode implements ErrorCode {
	SHOP_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND: 존재하지 않는 가게입니다."),
	SHOP_ALREADY_SAVED(HttpStatus.CONFLICT, "CONFLICT: 이미 존재하는 가게입니다."),
	SHOP_ALREADY_LIKED(HttpStatus.METHOD_NOT_ALLOWED, "CONFLICT: 이미 찜한/하지 않은 가게입니다.")
	;

	private final HttpStatus httpStatus;
	private final String message;
}
