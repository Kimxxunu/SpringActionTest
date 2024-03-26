package Nosunwoo.NiceTest.test.chatting.controller;

import Nosunwoo.NiceTest.test.chatting.dto.ChattingDto;
import Nosunwoo.NiceTest.test.chatting.dto.ChattingHistoryDto;
import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;
import Nosunwoo.NiceTest.test.chatting.service.ChatMessagesService;
import Nosunwoo.NiceTest.test.chatting.service.ChatRoomJoinService;
import Nosunwoo.NiceTest.test.chatting.service.ChatRoomService;
import Nosunwoo.NiceTest.test.chatting.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final UsersService usersService;
    private final ChatRoomService chatRoomService;
    private final ChatRoomJoinService chatRoomJoinService;
    private final ChatMessagesService chatMessagesService;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate, UsersService usersService,
                               ChatRoomService chatRoomService, ChatRoomJoinService chatRoomJoinService, ChatMessagesService chatMessagesService) {
        this.messagingTemplate = messagingTemplate;
        this.usersService = usersService;
        this.chatRoomService = chatRoomService;
        this.chatRoomJoinService = chatRoomJoinService;
        this.chatMessagesService = chatMessagesService;
    }

    @PostMapping("/chat/info")
    public void chattingInfo(@RequestBody ChattingDto chattingDto){
        // 클라이언트로부터 받은 채팅 정보를 사용하여 사용자와 채팅방을 저장
        UsersEntity usersEntity = usersService.saveUsersService(chattingDto.getUserName());
        ChatRoomEntity chatRoomEntity = chatRoomService.saveChatRoom(chattingDto.getRoomName());

        // 채팅 방 참여 정보 저장
        chatRoomJoinService.saveChatRoomJoin(usersEntity, chatRoomEntity);
    }

    @GetMapping("/chat/info")
    public ChattingHistoryDto returnChatting(@RequestBody ChattingDto chattingDto){
        ChattingHistoryDto chattingHistoryDto = new ChattingHistoryDto(chatMessagesService.returnHistory(chattingDto.getRoomName()));
        return chattingHistoryDto;
    }


    @MessageMapping("/chat")
    public void handleChatMessage(ChattingDto chattingDto) {
        // 채팅 메시지를 해당 방으로 전송
        String roomName = chattingDto.getRoomName();
        chatMessagesService.saveMessage(chattingDto);
        // 채팅 메시지를 해당 방으로 전송
        messagingTemplate.convertAndSend("/topic/messages/" + roomName, "서버에서 보낸 메시지: " + chattingDto.getMessage());
    }

//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public void handleChatMessage(@Payload ChattingDto chattingDto) {
//        // 채팅 메시지를 해당 방으로 전송
//        String roomName = chattingDto.getRoomName();
//        chatMessagesService.saveMessage(chattingDto);
//        chattingDto.setMessage(chattingDto.getMessage());
//
//        messagingTemplate.convertAndSend("/topic/messages/" + roomName, "서버에서 보낸 메시지: " + chattingDto.getMessage());
//    }
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
