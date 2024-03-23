package Nosunwoo.NiceTest.test.chatting.service;

import Nosunwoo.NiceTest.test.chatting.entity.UsersEntity;
import Nosunwoo.NiceTest.test.chatting.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersEntity saveUsersService(String userName) {
        UsersEntity usersEntity = usersRepository.findByUserName(userName);
        if (usersEntity == null) {
            usersEntity = new UsersEntity();
            usersEntity.setUserName(userName);
            usersRepository.save(usersEntity);
        }
        return usersEntity;
    }
}
