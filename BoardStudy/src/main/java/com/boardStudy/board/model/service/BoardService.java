package com.boardStudy.board.model.service;

import org.springframework.data.domain.Page;

import com.boardStudy.board.model.vo.Board;

public interface BoardService {
	
	void insertBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);
	
	Board getBoard(Board board);
	
	Page<Board> getBoardList(Board board);

}
