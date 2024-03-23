package Nosunwoo.NiceTest.test.chatting.repository;

import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Integer> {
    ChatRoomEntity findByRoomName(String roomName);
}

