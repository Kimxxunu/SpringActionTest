package Nosunwoo.NiceTest.test.chatting.controller;

import Nosunwoo.NiceTest.test.chatting.dto.ChattingDto;
import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;
import Nosunwoo.NiceTest.test.chatting.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final UsersService usersService;
    private final ChatRoomService chatRoomService;
    private final ChatRoomJoinService chatRoomJoinService;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate, UsersService usersService,
                               ChatRoomService chatRoomService, ChatRoomJoinService chatRoomJoinService) {
        this.messagingTemplate = messagingTemplate;
        this.usersService = usersService;
        this.chatRoomService = chatRoomService;
        this.chatRoomJoinService = chatRoomJoinService;
    }

    @PostMapping("/chat/info")
    public void chattingInfo(ChattingDto chattingDto){
        // 이미 존재하는 사용자 및 채팅 방인지 확인하고, 존재하지 않을 때만 저장
        UsersEntity usersEntity = usersService.saveUsersService(chattingDto.getUserName());
        ChatRoomEntity chatRoomEntity = chatRoomService.saveChatRoom(chattingDto.getRoomName());

        // 채팅 방 참여 정보 저장
        chatRoomJoinService.saveChatRoomJoin(usersEntity, chatRoomEntity);
    }

    @MessageMapping("/chat")
    public String handleChatMessage(ChattingDto chattingDto) {
        // 채팅 메시지를 해당 방으로 전송
        String roomName = chattingDto.getRoomName();
        messagingTemplate.convertAndSend("/topic/messages/" + roomName, "서버에서 보낸 메시지: " + chattingDto.getMessage());

        // 예시로 메시지에 대한 응답을 반환합니다.
        return chattingDto.getMessage() + "에 대한 응답입니다.";
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
