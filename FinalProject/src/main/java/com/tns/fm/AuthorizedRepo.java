package com.tns.fm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizedRepo extends JpaRepository<Authorized,Integer>{
	Authorized findByEmail(String email);
	Authorized findByComplaintType(String complaintType);
}
