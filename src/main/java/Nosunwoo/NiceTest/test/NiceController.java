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
                .name("김민재")
                .number(1004)
                .location("남양주시 덕소리")
                .fruit("banana")
                .animal("대머리독수리")
                .build();
    }
}
