package com.tns.fm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SenRepo extends JpaRepository<Sensitive_comp,Integer>{
	
}
