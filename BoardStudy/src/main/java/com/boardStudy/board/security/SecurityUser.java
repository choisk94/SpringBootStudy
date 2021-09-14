package com.boardStudy.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.boardStudy.board.model.vo.Member;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;
	private Member member;

	public SecurityUser(Member member) {
		super(member.getId(), "{noop}" + member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	
	// 회원 객체를 멤버변수인 member에 추가로 할당하고 있는데 이는
	// 이후에 인증된 회원 정보를 HTML화면에서 사용하기 위해서이다.
}
