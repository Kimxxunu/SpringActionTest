package Nosunwoo.NiceTest.test.board.repository;

import Nosunwoo.NiceTest.test.board.entity.BoardImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BoardImageRepository extends JpaRepository<BoardImageEntity, Long> {

    BoardImageEntity findByImageUrl(String imageUrl);
}
