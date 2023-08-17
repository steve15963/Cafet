package xxx.petmanbe.Kiosk.webSocket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.Kiosk.webSocket.Entity.ChatRoom;
import xxx.petmanbe.Kiosk.webSocket.Entity.ChatRoomMessage;
import xxx.petmanbe.Kiosk.webSocket.dto.MessageDto;
import xxx.petmanbe.Kiosk.webSocket.dto.requestDto.MessageGetDto;
import xxx.petmanbe.Kiosk.webSocket.dto.responseDto.GetMessagesDto;
import xxx.petmanbe.Kiosk.webSocket.repository.ChatRoomMessageRepository;
import xxx.petmanbe.Kiosk.webSocket.repository.ChatRoomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService{

	private final ChatRoomMessageRepository chatRoomMessageRepository;

	private final ChatRoomRepository chatRoomRepository;

	public GetMessagesDto getMessages(long roomId){

		List<ChatRoomMessage> chatRoomMessageList = chatRoomMessageRepository.findAllByChatRoom_ChatRoomId(roomId);

		return GetMessagesDto.builder()
			.chatRoomMessageList(chatRoomMessageList)
			.build();
	}

	// @Async
	public boolean saveMessage(long shopId, String message){

		System.out.println("test1"+shopId);

		 ChatRoom chatRoom = chatRoomRepository.findById(shopId).orElseThrow(()-> new IllegalArgumentException());

		 List<ChatRoomMessage> chatRoomMessageList = new ArrayList<>();
		 chatRoomMessageList = chatRoomMessageRepository.findAllByChatRoom_ChatRoomId(shopId);

		 ChatRoomMessage chatRoomMessage = ChatRoomMessage.builder()
		 			.chatRoom(chatRoom)
		 		.message(message)
		 				.build();

		System.out.println(chatRoomMessage);


		chatRoomMessageList.add(chatRoomMessage);

		 chatRoomMessageRepository.save(chatRoomMessage);

		return true;
	}

	public long getRoomList(){

		return chatRoomRepository.count();
	}
	
	public String changeToMsg(long tableId, String[][] list) {
		
		String msg = tableId +" 테이블"+"\n";

		for(int i=0 ; i<list.length ; i++){
			String[] info = list[i];
			if(i==list.length-1) msg+= info[0]+" "+info[3]+" "+info[2]+" 개";
			else msg+= info[0]+" "+info[3]+" "+info[2]+" 개"+'\n';
		}

		return msg.toString();
	}

	@Override
	public boolean changeStatus(MessageGetDto messageGetDto) {

		ChatRoomMessage chatRoomMessage  =  chatRoomMessageRepository.findByMessageContaining(messageGetDto.getMessage()).orElseThrow(()->new IllegalArgumentException());

		chatRoomMessage.setStatus(true);

		chatRoomMessageRepository.save(chatRoomMessage);

		return true;
	}

}
