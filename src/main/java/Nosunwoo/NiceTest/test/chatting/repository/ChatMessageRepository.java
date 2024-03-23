package Nosunwoo.NiceTest.test.chatting.repository;

import Nosunwoo.NiceTest.test.chatting.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
}

