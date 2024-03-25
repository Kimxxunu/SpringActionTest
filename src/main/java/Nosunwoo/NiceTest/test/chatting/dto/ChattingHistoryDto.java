package Nosunwoo.NiceTest.test.chatting.dto;

import lombok.Data;
import java.util.List;

@Data
public class ChattingHistoryDto {
    private List<ChattingDto> messageHistory;

    public ChattingHistoryDto(List<ChattingDto> messageHistory) {
        this.messageHistory = messageHistory;
    }
}
