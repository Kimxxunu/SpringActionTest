package Nosunwoo.NiceTest.test.board.repository;

import Nosunwoo.NiceTest.test.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
