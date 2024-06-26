package com.tns.fm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member,String>{
	Member findByEmail(String email);
}
