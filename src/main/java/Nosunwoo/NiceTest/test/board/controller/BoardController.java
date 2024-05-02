package Nosunwoo.NiceTest.test.board.controller;

import Nosunwoo.NiceTest.test.board.dto.BoardDTO;
import Nosunwoo.NiceTest.test.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/mama")
    public String mama(){

        return "마마마";
    }


    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("images") List<MultipartFile> images // 여러 개의 이미지를 받기 위해 List로 변경
    ) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setContent(content);
        boardDTO.setCreatedBy(createdBy);
        boardDTO.setFiles(images);

        try {
            boardService.saveBoard(boardDTO);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("파일 업로드 실패 : " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long id) {
        BoardDTO boardDTO = boardService.getBoard(id);
        if (boardDTO != null) {
            return ResponseEntity.ok(boardDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        List<BoardDTO> boardDTOs = boardService.getAllBoards();
        return ResponseEntity.ok(boardDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok().build();
    }
}
