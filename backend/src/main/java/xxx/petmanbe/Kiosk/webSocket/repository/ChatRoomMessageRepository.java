package xxx.petmanbe.Kiosk.webSocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xxx.petmanbe.Kiosk.webSocket.Entity.ChatRoomMessage;

import java.util.List;

public interface ChatRoomMessageRepository extends JpaRepository<ChatRoomMessage,Long> {

	List<ChatRoomMessage> findAllByChatRoom_ChatRoomId(long shopId);

}
