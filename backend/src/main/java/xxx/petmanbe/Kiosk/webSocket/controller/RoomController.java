package xxx.petmanbe.Kiosk.webSocket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xxx.petmanbe.Kiosk.webSocket.Entity.ChatRoom;
import xxx.petmanbe.Kiosk.webSocket.dto.responseDto.GetMessagesDto;
import xxx.petmanbe.Kiosk.webSocket.repository.ChatRoomRepository;
import xxx.petmanbe.Kiosk.webSocket.service.WebSocketService;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
@CrossOrigin("*")
public class RoomController {

	private final ChatRoomRepository chatRoomRepository;

	private final WebSocketService webSocketService;

	@GetMapping("")
	@Transactional
	public long ChatRoomList(){

		long roomNum = webSocketService.getRoomList();


		return roomNum;
	}

	// @GetMapping("/{roomId}")
	// public {
	//
	// }

	// 방 만들기(이건 회원가입할 때 만들어도 될듯...)
	@PostMapping("/{shopId}")
	public Long MakeRoom(@PathVariable long shopId){

		ChatRoom newRoom =  ChatRoom.create(shopId);

		return newRoom.getChatRoomId();
	}

	// 방에 있는 메시지 불러오기
	@GetMapping("/{shopId}")
	public GetMessagesDto GetMessage(@PathVariable long shopId){

		GetMessagesDto getMessagesDto = webSocketService.getMessages(shopId);

		return getMessagesDto;
	}


}
