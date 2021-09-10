package com.boardStudy.board.model.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude="boardList")		// 순환참조문제 해결을 위해 boardList변수 제외
//@AllArgsConstructor 왜 안쓰는겨
@Entity
public class Member {
	
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	
	private String password;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;

	@OneToMany(mappedBy ="member", fetch=FetchType.EAGER)		// 1대N관계를 매핑. Member가 양방향 매핑에서 연관관계의 주인이 아님을 설정하기 위해 mappedBy속성 추가
	private List<Board> boardList = new ArrayList<Board>();		// Member가 조회될 때 관련된 Board목록도 같이 조회되도록 fetch를 즉시로딩(EAGER)으로 설정
}
