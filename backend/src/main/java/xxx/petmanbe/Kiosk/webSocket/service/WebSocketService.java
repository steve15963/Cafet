package xxx.petmanbe.Kiosk.webSocket.service;

import xxx.petmanbe.Kiosk.webSocket.dto.MessageDto;
import xxx.petmanbe.Kiosk.webSocket.dto.responseDto.GetMessagesDto;

public interface WebSocketService {

	public GetMessagesDto getMessages(long roomId);

	public boolean saveMessage(long shopId, String message);

	public long getRoomList();

	public String changeToMsg(long tableId, String[][] messages);

}
