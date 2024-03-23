package Nosunwoo.NiceTest.test.chatting.repository;

import Nosunwoo.NiceTest.test.chatting.entity.ChatRoomJoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomJoinRepository extends JpaRepository<ChatRoomJoinEntity, Long> {
}
