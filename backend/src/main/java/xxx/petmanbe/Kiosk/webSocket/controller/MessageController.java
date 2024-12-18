package xxx.petmanbe.Kiosk.webSocket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import xxx.petmanbe.Kiosk.webSocket.dto.MessageDto;
import xxx.petmanbe.Kiosk.webSocket.dto.requestDto.MessageGetDto;
import xxx.petmanbe.Kiosk.webSocket.dto.responseDto.OrderResponseDto;
import xxx.petmanbe.Kiosk.webSocket.service.WebSocketService;

@Controller
@RequiredArgsConstructor
public class MessageController {

	private final WebSocketService webSocketService;

	private final SimpMessageSendingOperations template;


	//주문내역
	@MessageMapping("/message")
	public OrderResponseDto sending(MessageDto message) throws InterruptedException {
		Thread.sleep(100);

		String messages = webSocketService.changeToMsg(message.getTableId(), message.getContent());

		System.out.println("메시지는"+messages);

		template.convertAndSend("/topic/message/"+ message.getShopId(), messages);

		boolean a = webSocketService.saveMessage(message.getShopId(), messages);

		return new OrderResponseDto(message.getShopId(),messages, message.getTableId());
	}

	@MessageMapping("/check")
	public void check(MessageGetDto messageGetDto) throws InterruptedException{
		Thread.sleep(100);

		// webSocketService.changeStatus(messageGetDto);

		// System.out.println(messageGetDto.getMsg());

	}

}
