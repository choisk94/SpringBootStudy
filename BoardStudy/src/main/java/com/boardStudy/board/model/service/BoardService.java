package com.boardStudy.board.model.service;

import org.springframework.data.domain.Page;

import com.boardStudy.board.model.vo.Board;

public interface BoardService {
	
	// 게시글 작성
	void insertBoard(Board board);
	
	// 게시글 수정
	void updateBoard(Board board);
	
	// 게시글 삭제
	void deleteBoard(Board board);
	
	// 게시글 조회
	Board getBoard(Board board);
	
	// 게시글 목록 조회
	Page<Board> getBoardList(Board board);

}
