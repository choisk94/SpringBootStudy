package com.boardStudy.board.model.persistence;

import org.springframework.data.repository.CrudRepository;

import com.boardStudy.board.model.vo.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	

}
