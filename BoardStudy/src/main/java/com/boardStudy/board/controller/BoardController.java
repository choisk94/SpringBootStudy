package com.boardStudy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boardStudy.board.model.service.BoardService;
import com.boardStudy.board.model.vo.Board;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService bService;		// BoardService 컴포넌트를 의존성 주입함
	
	// getBoardList.html페이지에서 검색 결과를 사용할 수 있도록 Model에 검색한 글 목록을 저장함
	/** @author seokyung choi
	 * 게시물 목록 조회
	 */
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		Page<Board> boardList = bService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}

	/** @author seokyung choi
	 * 게시물 상세 조회
	 */
	@RequestMapping("/getBoard")
	public String getBard(Model model, Board board) {
		model.addAttribute("board", bService.getBoard(board));
		return "board/getBoard";
	}
	
	/** @author seokyung choi
	 * 게시물 등록 화면
	 */
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "board/insertBoard";
	}
	
	/** @author seokyung choi
	 * 게시물 등록 기능
	 */
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		bService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	/** @author seokyung choi
	 * 게시물 수정
	 */
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		bService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	/** @author seokyung choi
	 * 게시물 삭제
	 */
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		bService.deleteBoard(board);
		return "forward:getBoardList";
	}

	
	
	
}
