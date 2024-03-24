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

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final UsersServiceImpl usersService;
    private final ChatRoomServiceImpl chatRoomService;
    private final ChatRoomJoinServiceImpl chatRoomJoinService;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate, UsersServiceImpl usersService,
                               ChatRoomServiceImpl chatRoomService, ChatRoomJoinServiceImpl chatRoomJoinService) {
        this.messagingTemplate = messagingTemplate;
        this.usersService = usersService;
        this.chatRoomService = chatRoomService;
        this.chatRoomJoinService = chatRoomJoinService;
    }

    @PostMapping("/chat/info")
    public void chattingInfo(ChattingDto chattingDto){
        usersService.saveUsersService(chattingDto.getUserName());
        chatRoomService.saveChatRoom(chattingDto.getRoomName());
        // 사용자 정보 저장
        UsersEntity usersEntity = usersService.saveUsersService(chattingDto.getUserName());
        // 채팅 방 정보 저장
        ChatRoomEntity chatRoomEntity = chatRoomService.saveChatRoom(chattingDto.getRoomName());

        // 채팅 방 참여 정보 저장
        chatRoomJoinService.saveChatRoomJoin(usersEntity, chatRoomEntity);
    }


    @MessageMapping("/chat")
    public String handleChatMessage(ChattingDto chattingDto) {
        // 채팅 메시지를 해당 방으로 전송
        String roomName = chattingDto.getRoomName();
        messagingTemplate.convertAndSend("/topic/messages/" + roomName, "서버에서 보낸 메시지: " + chattingDto.getMessage());

//        // 사용자 정보 저장
//        UsersEntity usersEntity = usersService.saveUsersService(chattingDto.getUserName());
//
//        // 채팅 방 정보 저장
//        ChatRoomEntity chatRoomEntity = chatRoomService.saveChatRoom(chattingDto.getRoomName());
//
//        // 채팅 방 참여 정보 저장
//        chatRoomJoinService.saveChatRoomJoin(usersEntity, chatRoomEntity);

        return chattingDto.getMessage()+"ㅋㅋ";
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
