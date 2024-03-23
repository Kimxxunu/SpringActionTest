package Nosunwoo.NiceTest.test.chatting.service;

import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import Nosunwoo.NiceTest.test.chatting.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public ChatRoomEntity saveChatRoom(String roomName) {
        ChatRoomEntity chatRoomEntity = chatRoomRepository.findByRoomName(roomName);
        if (chatRoomEntity == null) {
            chatRoomEntity = new ChatRoomEntity();
            chatRoomEntity.setRoomName(roomName);
            chatRoomRepository.save(chatRoomEntity);
        }
        return chatRoomEntity;
    }
}
