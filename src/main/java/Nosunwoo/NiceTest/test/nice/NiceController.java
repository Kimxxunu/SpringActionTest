package Nosunwoo.NiceTest.test.nice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class NiceController {

    public static final UUID randomUUID= UUID.randomUUID();

    // application.yml에 설정된 값들을 주입받습니다.
    @Value("${server.env}")
    private String env; // 서버 환경

    @Value("${server.port}")
    private String serverPort; // 서버 포트

//    @Value("${server.serverAddress}")
//    private String serverAddress; // 서버 주소

    @Value("${serverName}")
    private String serverName; // 서버 이름

    // 서버의 상태를 확인하는 엔드포인트
    @GetMapping("/hc")
    public  ResponseEntity<?> healthCheck(){
        // 서버의 상태 정보를 Map에 담아 반환합니다.
        Map<String, String> responseData = new TreeMap<>();
        responseData.put("serverName", serverName);
        //responseData.put("serverAddress", serverAddress);
        responseData.put("serverPort", serverPort);
        responseData.put("env", env);
        return ResponseEntity.ok(responseData);
    }

    // 서버 환경을 반환하는 엔드포인트
    @GetMapping("/env")
    public  ResponseEntity<?> getEnv(){
        // 서버의 환경 정보를 단일 값으로 반환합니다.
        return ResponseEntity.ok(env);
    }

    public ResponseEntity<UUID> test(){
        return ResponseEntity.ok(randomUUID);
    }

    @GetMapping("/nice")
    public NiceDTO getNiceDTO() {
        // NiceDTO 객체를 동적으로 생성하여 반환
        return NiceDTO.builder()
                .name("김선우2")
                .number(12346)
                .location("남양주시 덕소리 건영아파트1")
                .fruit("포도")
                .animal("코끼리")
                .build();
    }
}
