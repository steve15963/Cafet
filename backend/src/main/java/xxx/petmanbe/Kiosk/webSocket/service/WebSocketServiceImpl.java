package xxx.petmanbe.Kiosk.webSocket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.Kiosk.webSocket.Entity.ChatRoomMessage;
import xxx.petmanbe.Kiosk.webSocket.dto.MessageDto;
import xxx.petmanbe.Kiosk.webSocket.dto.responseDto.GetMessagesDto;
import xxx.petmanbe.Kiosk.webSocket.repository.ChatRoomMessageRepository;
import xxx.petmanbe.Kiosk.webSocket.repository.ChatRoomRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService{

	private final ChatRoomMessageRepository chatRoomMessageRepository;

	private final ChatRoomRepository chatRoomRepository;

	public GetMessagesDto getMessages(long roomId){

		List<ChatRoomMessage> chatRoomMessageList = chatRoomMessageRepository.findAllByChatRoom_ChatRoomId(roomId);

		GetMessagesDto getMessagesDto = GetMessagesDto.builder()
			.chatRoomMessageList(chatRoomMessageList)
			.build();


		return getMessagesDto;
	}

	// @Async
	public boolean saveMessage(MessageDto messageDto){

		// ChatRoom chatRoom = chatRoomRepository.findById(messageDto.getShopId()).orElseThrow(()-> new IllegalArgumentException());
		//
		// List<ChatRoomMessage> chatRoomMessageList = new ArrayList<>();
		// chatRoomMessageList = chatRoomMessageRepository.findAllByChatRoom_ChatRoomId(messageDto.getShopId());
		//
		// ChatRoomMessage chatRoomMessage = ChatRoomMessage.builder()
		// 			.chatRoom(chatRoom)
		// 		.message(messageDto.getContent())
		// 				.build();
		//
		// chatRoomMessageList.add(chatRoomMessage);
		//
		// chatRoomMessageRepository.save(chatRoomMessage);

		return true;
	}

	public long getRoomList(){

		long roomNum = chatRoomRepository.count();

			return roomNum;
	}

}
