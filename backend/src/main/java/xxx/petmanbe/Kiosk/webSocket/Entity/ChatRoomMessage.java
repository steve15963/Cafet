package xxx.petmanbe.Kiosk.webSocket.Entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import xxx.petmanbe.common.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "ChatRoomMessage")
@DynamicUpdate
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatRoomMessage extends BaseTimeEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public long chatRoomMessageId;

	@Column
	public String message;

	@Column(name = "status", nullable = false, columnDefinition = "boolean default false")
	public boolean status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chat_room_id")
	public ChatRoom chatRoom;



}
