package Nosunwoo.NiceTest.test.chatting.service;

import Nosunwoo.NiceTest.test.chatting.dto.ChattingDto;

import java.util.List;

public interface ChatMessagesService {

    public List<ChattingDto> returnHistory(String roomName);

    public void saveMessage(ChattingDto messageInfo);

}
