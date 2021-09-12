package com.boardStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boardStudy.board.model.persistence.BoardRepository;
import com.boardStudy.board.model.persistence.MemberRepository;
import com.boardStudy.board.model.vo.Board;
import com.boardStudy.board.model.vo.Member;
import com.boardStudy.board.model.vo.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	// 테스트1) 데이터 삽입. 실행 후 다른 테스트 진행을 위해 주석처리. (application.yml에서 ddl설정 update로 바꿔주기=>새 테이블 생성 방지)
	/*
	@Test
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
		memberRepo.save(member2);
		
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
	 */		

	// 테스트2) 데이터 조회.
	/*
	@Test
	public void testGetBoard() {
		
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("[" + board.getSeq() + "번 게시 글 상세정보]");
		System.out.println("제목\t : " + board.getTitle());
		System.out.println("작성자\t : " + board.getMember().getName());
		System.out.println("내용\t : " + board.getContent());
		System.out.println("등록일\t : " + board.getCreateDate());
		System.out.println("조회수\t : " + board.getCnt());
	}
	*/
	
	// 테스트3) 목록 검색 테스트.
	@Test
	public void testGetBoardList() {
		Member member = memberRepo.findById("member").get();
		
		System.out.println("[" + member.getName() + "가 등록한 게시글]");
		for(Board board : member.getBoardList()) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	
}
