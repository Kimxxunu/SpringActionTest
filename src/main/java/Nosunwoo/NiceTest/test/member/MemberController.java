package Nosunwoo.NiceTest.test.member;

import Nosunwoo.NiceTest.test.NiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService; // Assuming you have a service for handling business logic

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberDTO memberDTO) {
        // Convert DTO to Entity and save to database using service
        MemberEntity memberEntity = convertDTOToEntity(memberDTO);
        memberService.saveMember(memberEntity);

        return ResponseEntity.ok("Member joined successfully");
    }

    private MemberEntity convertDTOToEntity(MemberDTO memberDTO) {
        return MemberEntity.builder()
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .password(memberDTO.getPassword())
                .nickname(memberDTO.getNickname())
                .addreass(memberDTO.getAddress())
                .build();
    }
}