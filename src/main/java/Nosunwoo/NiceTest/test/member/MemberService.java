package Nosunwoo.NiceTest.test.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository; // Assuming you have a repository for database operations

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
        // You can add additional business logic if needed
    }
}