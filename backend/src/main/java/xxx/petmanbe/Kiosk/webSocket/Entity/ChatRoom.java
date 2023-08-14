package xxx.petmanbe.Kiosk.webSocket.Entity;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ChatRoom")
@DynamicUpdate
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "chat_room_id")
	private long chatRoomId;

	//ChatRoom Message를 가져와야 함
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chatRoom")
	private List<ChatRoomMessage> chatRoomMessageList;


	public static ChatRoom create(long shopId){
		ChatRoom room = new ChatRoom();
		room.setChatRoomId(shopId);

		return room;
	}



}
