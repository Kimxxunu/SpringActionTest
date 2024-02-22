package Nosunwoo.NiceTest.test.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    // You can add custom query methods if needed
}
