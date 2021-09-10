package com.boardStudy;

import org.springframework.beans.factory.annotation.Autowired;

import com.boardStudy.board.model.persistence.BoardRepository;
import com.boardStudy.board.model.persistence.MemberRepository;
import com.boardStudy.board.model.vo.Board;
import com.boardStudy.board.model.vo.Member;
import com.boardStudy.board.model.vo.Role;

public class BoardRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	public void testInsert() {
		
		Member member1 = new Member();
		member1.setId("member");
		member1.setPassword("member123");
		member1.setName("사용자");
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled(true);
		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("admin");
		member2.setPassword("member123");
		member2.setName("관리자");
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled(true);
		memberRepo.save(member1);
		
		for(int i = 1; i <= 13; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle(member1.getName() + "가 등록한 게시글" + i);
			board.setContent(member1.getName() + "가 등록한 게시글 " + i + "입니다.");
			boardRepo.save(board);
		}
		
		for(int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle(member2.getName() + "가 등록한 게시글" + i);
			board.setContent(member2.getName() + "가 등록한 게시글 " + i + "입니다.");
			boardRepo.save(board);
		}		
	}

}
