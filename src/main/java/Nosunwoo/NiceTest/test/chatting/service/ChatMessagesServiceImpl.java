package Nosunwoo.NiceTest.test.chatting.service;


import Nosunwoo.NiceTest.test.chatting.dto.ChattingDto;
import Nosunwoo.NiceTest.test.chatting.entity.ChatMessageEntity;
import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import Nosunwoo.NiceTest.test.chatting.repository.ChatMessageRepository;
import Nosunwoo.NiceTest.test.chatting.repository.ChatRoomRepository;
import Nosunwoo.NiceTest.test.chatting.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ChatMessagesServiceImpl implements ChatMessagesService{


    private final ChatRoomRepository chatRoomRepository;
    private final UsersRepository usersRepository;
    private final ChatMessageRepository chatMessageRepository;


    @Autowired
    public ChatMessagesServiceImpl(ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository,UsersRepository usersRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
        this.usersRepository = usersRepository;
    }

    public List<ChattingDto> returnHistory(String roomName) {
        // 채팅방 이름으로 채팅방을 조회
        ChatRoomEntity chatRoomEntity = chatRoomRepository.findByRoomName(roomName);
        if (chatRoomEntity == null) {
            // 채팅방이 존재하지 않는 경우 처리
            // 예를 들어 예외를 던지거나 빈 리스트를 반환할 수 있습니다.
            return Collections.emptyList();
        }
        // 조회된 채팅방의 ID를 사용하여 채팅 내역을 조회
        List<ChatMessageEntity> messages = chatMessageRepository.findByRoomId(chatRoomEntity.getRoomId());
        // 채팅 내역을 ChattingDto로 변환하여 반환
        List<ChattingDto> history = messages.stream()
                .map(message -> {
                    ChattingDto dto = new ChattingDto();
                    dto.setUserName(message.getUserId().getUserName());
                    dto.setMessage(message.getMessage());
                    dto.setTime(message.getTime().toString());
                    return dto;
                })
                .collect(Collectors.toList());
        return history;
    }

    public void saveMessage(ChattingDto messageInfo){
        ChatMessageEntity chatMessage = new ChatMessageEntity();
        chatMessage.setMessage(messageInfo.getMessage());
        chatMessage.setUserId(usersRepository.findByUserName(messageInfo.getUserName()));
        chatMessage.setRoomId(chatRoomRepository.findByRoomName(messageInfo.getRoomName()));
        chatMessageRepository.save(chatMessage);
    }

}
