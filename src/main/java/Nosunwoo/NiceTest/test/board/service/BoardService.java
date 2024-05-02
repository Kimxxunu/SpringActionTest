package Nosunwoo.NiceTest.test.board.service;

import Nosunwoo.NiceTest.test.board.dto.BoardDTO;
import Nosunwoo.NiceTest.test.board.entity.BoardEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {
    void saveBoard(BoardDTO boardDTO) throws IOException;
    void deleteBoard(Long id);
    BoardDTO getBoard(Long id);
    List<BoardDTO> getAllBoards();
}
