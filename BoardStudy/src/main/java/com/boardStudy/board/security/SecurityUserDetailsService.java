package com.boardStudy.board.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boardStudy.board.model.persistence.MemberRepository;
import com.boardStudy.board.model.vo.Member;

// UserDetails를 구현한, SecurityUser객체에 검색한 회원 정보를 설정하는 UserDetailsService클래스 
@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;

	// MemberRepository를 이용하여 조회한 회원 정보를, SecurityUser객체로 감싸서 return하는 메소드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Member> optional = memberRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		} else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}
	
	
	
}
