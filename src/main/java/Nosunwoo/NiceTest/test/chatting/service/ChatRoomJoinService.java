package Nosunwoo.NiceTest.test.chatting.service;

import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;

public interface ChatRoomJoinService {
    public void saveChatRoomJoin(UsersEntity usersEntity, ChatRoomEntity chatRoomEntity);

}
