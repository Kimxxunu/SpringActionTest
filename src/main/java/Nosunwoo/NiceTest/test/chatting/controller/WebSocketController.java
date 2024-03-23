package Nosunwoo.NiceTest.test.chatting.controller;

import Nosunwoo.NiceTest.test.chatting.dto.ChattingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;



import org.springframework.messaging.simp.annotation.SendToUser;


@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat")
    public void handleChatMessage(ChattingDto chattingDto) {
        String roomName = chattingDto.getRoomName();
        // 메시지를 받아 처리하고 다시 클라이언트로 보냅니다.
        // 클라이언트로 메시지 전송1
        messagingTemplate.convertAndSend("/topic/messages/" + roomName, "서버에서 보낸 메시지: " + chattingDto.getMessage());
    }
}

//@Controller
//public class WebSocketController {
//
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public String handleChatMessage(String message) {
//        // 메시지를 받아 처리하고 다시 클라이언트로 보냅니다.
//        // 클라이언트로 메시지 전송1
//        messagingTemplate.convertAndSend("/topic/messages", "서버에서 보낸 메시지: " + message);
//        return message;
//    }
//}
