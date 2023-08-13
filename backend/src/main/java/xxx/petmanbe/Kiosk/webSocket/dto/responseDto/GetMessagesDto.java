package xxx.petmanbe.Kiosk.webSocket.dto.responseDto;

import lombok.*;
import xxx.petmanbe.Kiosk.webSocket.Entity.ChatRoomMessage;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetMessagesDto {


	List<ChatRoomMessage> chatRoomMessageList;


}
