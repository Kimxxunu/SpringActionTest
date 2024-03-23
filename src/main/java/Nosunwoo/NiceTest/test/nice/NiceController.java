package Nosunwoo.NiceTest.test.nice;

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
                .name("김선우")
                .number(12346)
                .location("남양주시 덕소리 건영아파트1")
                .fruit("포도")
                .animal("코끼리")
                .build();
    }
}
