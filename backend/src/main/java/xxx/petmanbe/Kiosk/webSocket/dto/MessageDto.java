package xxx.petmanbe.Kiosk.webSocket.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MessageDto {
	// private Menu menu;
	private long shopId;
	private String content;
	private String uuid;
}
