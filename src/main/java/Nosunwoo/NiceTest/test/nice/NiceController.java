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

    public static final UUID randomUUID = UUID.randomUUID();

    @Value("${server.env}")
    private String env;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.serverAddress}")
    private String serverAddress;

    @Value("${serverName}")
    private String serverName;


    @GetMapping("/test")
    public ResponseEntity<UUID> test(){
        return ResponseEntity.ok(randomUUID);
    }
    @GetMapping("/hc")
    public  ResponseEntity<?> healthCheck(){
        Map<String, String> responseData = new TreeMap<>();
        responseData.put("serverName", serverName);
        responseData.put("serverAddress", serverAddress);
        responseData.put("serverPort", serverPort);
        responseData.put("env", env);

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public  ResponseEntity<?> getEnv(){
        Map<String, String> responseData = new HashMap<>();

        return ResponseEntity.ok(env);
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
