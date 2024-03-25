package Nosunwoo.NiceTest.test.chatting.dto;

import lombok.Data;

@Data
public class ChattingDto {
    private String message; // 추가: 채팅 메시지
    private String userName;
    private String roomName;
    private String time;

}
