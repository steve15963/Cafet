package xxx.petmanbe.Kiosk.webSocket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import xxx.petmanbe.Kiosk.webSocket.dto.MessageDto;
import xxx.petmanbe.Kiosk.webSocket.service.WebSocketService;

@Controller
@RequiredArgsConstructor
public class MessageController {

	private final WebSocketService webSocketService;

	private final SimpMessageSendingOperations template;


	//주문내역
	@MessageMapping("/message") // 받고
	// @SendTo("/topic/message") // 보내고
	public MessageDto sending(MessageDto message) throws InterruptedException {
		Thread.sleep(100);

		System.out.println(message.getShopId());
		System.out.println(message.getContent());

		boolean a = webSocketService.saveMessage(message);

		template.convertAndSend("/topic/message/"+ message.getShopId(), message);



		return new MessageDto(message.getShopId(),message.getContent(), message.getUuid());
	}

	//완료 버튼을 눌렀을 때








	// order 받는 api
//	@OnMessage //메세지를 받는 annotation
// 	@MessageMapping("/message") // 받고
// 	@SendTo("topic/message") // 보내고
// 	public MessageDto getOrder(@RequestBody OrderRequestDto orderDto){
//
// 		 String message = webSocketService.
//
//
//
// 		return new MessageDto();
// 	}

}
