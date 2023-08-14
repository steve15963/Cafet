package xxx.petmanbe.Kiosk.webSocket.Entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import xxx.petmanbe.common.entity.BaseTimeEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ChatRoomMessage")
@DynamicUpdate
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomMessage extends BaseTimeEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public long chatRoomMessageId;

	@Column
	public String message;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chat_room_id")
	public ChatRoom chatRoom;



}