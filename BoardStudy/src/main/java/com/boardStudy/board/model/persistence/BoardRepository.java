package com.boardStudy.board.model.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.boardStudy.board.model.vo.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	@Query("SELECT b FROM Board b")
	Page<Board> getBoardList(Pageable pageable);	// 페이징 처리와 정렬을 위해 Pageable타입을 매개변수로 받음.
													// 검색 결과와 관련한 다양한 정보를 웹 페이지에서 사용하기 위해 Page로 return타입 처리.
}
