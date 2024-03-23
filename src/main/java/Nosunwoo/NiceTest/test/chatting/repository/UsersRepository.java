package Nosunwoo.NiceTest.test.chatting.repository;

import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
}
