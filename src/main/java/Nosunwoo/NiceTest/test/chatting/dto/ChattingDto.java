package Nosunwoo.NiceTest.test.chatting.dto;

import lombok.Data;

@Data
public class ChattingDto {
    public String message; // 추가: 채팅 메시지
    public String userName;
    public String roomName;
    public String time;

}
