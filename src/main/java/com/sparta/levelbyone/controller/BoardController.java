package com.sparta.levelbyone.controller;

import com.sparta.levelbyone.dto.BoardModifiedDto;
import com.sparta.levelbyone.dto.BoardRequestDeleteDto;
import com.sparta.levelbyone.dto.BoardResponseDeleteDto;
import com.sparta.levelbyone.dto.BoardResponseDto;
import com.sparta.levelbyone.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "Board Controller")
@RestController // 얘가 JSON 형태로 바꿔준다??
@AllArgsConstructor
@RequestMapping("/api")
public class BoardController {

    BoardService boardService;

    @GetMapping("/boards")
    public List<BoardResponseDto> GetListBoard() {
        return boardService.GetListBoard();
    }

    @PostMapping("/board")
    public BoardResponseDto CreateBoard(@RequestBody BoardModifiedDto requestDto) { // 게시글 게시
        return boardService.CreateBoard(requestDto);
    }

    @GetMapping("/board/{id}") // 선택한 게시글 하나 조회하기 Read
    public BoardResponseDto SelectBoard(@PathVariable long id) {
        return boardService.SelectBoard(id);
    }

    @PutMapping("/board/{id}") // 선택한 게시글 수정
    public BoardResponseDto SelectModifiedBoard(@PathVariable long id, @RequestBody BoardModifiedDto requestDto) {
        return boardService.SelectModifiedBoard(id, requestDto);
    }

    @DeleteMapping("/board/{id}") // 선택한 게시글 삭제
    public BoardResponseDeleteDto SelectDeleteBoard(@PathVariable long id, @RequestBody BoardRequestDeleteDto requestDto) {
        return boardService.SelectDeleteBoard(id, requestDto);
    }
}