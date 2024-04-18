package com.tns.fm;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NonRepo extends JpaRepository<Non_academic_comp,Integer>{
	List<Non_academic_comp> findByComplaintType(String complaintType);
	
	
}
