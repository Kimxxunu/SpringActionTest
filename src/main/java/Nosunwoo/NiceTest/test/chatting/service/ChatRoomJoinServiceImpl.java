package Nosunwoo.NiceTest.test.chatting.service;

import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomJoinEntity;
import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;
import Nosunwoo.NiceTest.test.chatting.repository.ChatRoomJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomJoinServiceImpl implements ChatRoomJoinService {

    private final ChatRoomJoinRepository chatRoomJoinRepository;

    @Autowired
    public ChatRoomJoinServiceImpl(ChatRoomJoinRepository chatRoomJoinRepository) {
        this.chatRoomJoinRepository = chatRoomJoinRepository;
    }

    @Override
    public void saveChatRoomJoin(UsersEntity usersEntity, ChatRoomEntity chatRoomEntity) {
        ChatRoomJoinEntity chatRoomJoinEntity = new ChatRoomJoinEntity();
        chatRoomJoinEntity.setUserId(usersEntity);
        chatRoomJoinEntity.setRoomId(chatRoomEntity);
        chatRoomJoinRepository.save(chatRoomJoinEntity);
    }
}
