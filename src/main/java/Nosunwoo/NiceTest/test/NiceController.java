package Nosunwoo.NiceTest.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NiceController {

    @GetMapping("/nice")
    public NiceDTO getNiceDTO() {
        // NiceDTO 객체를 동적으로 생성하여 반환
        return NiceDTO.builder()
                .name("손흥민")
                .number(1234)
                .location("남양주시 덕소리")
                .fruit("두리안")
                .animal("대머리독수리")
                .build();
    }
}
