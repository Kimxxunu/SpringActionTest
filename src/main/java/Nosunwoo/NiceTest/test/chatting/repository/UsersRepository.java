package Nosunwoo.NiceTest.test.chatting.repository;

import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByUserName(String userName);
    //
}
