package com.boardStudy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boardStudy.board.model.service.BoardService;
import com.boardStudy.board.model.vo.Board;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService bService;		// BoardService 컴포넌트를 의존성 주입함
	
	// getBoardList.html페이지에서 검색 결과를 사용할 수 있도록 Model에 검색한 글 목록을 저장함
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		Page<Board> boardList = bService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
		
	}

}
