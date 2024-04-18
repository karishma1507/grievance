package com.tns.fm;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Service
@Transactional

public class CompService {
	@Autowired
	MemberRepo memrepo;
	
	@Autowired
	AcademicRepo acarepo;
	 
	
	@Autowired
	NonRepo nonrepo;
	
	@Autowired
	AuthorizedRepo authrepo;
	
	@Autowired
	SenRepo senrepo;
	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	private EmailService mail;
	
	//login for student
	public Member login(String email)
	{
		return memrepo.findByEmail(email);
	}
	
	//displaying student users
	public List<Member> display(){
		return memrepo.findAll();
	}
	
	
	
	
	public Academic filecomp(Academic comp) {
		return acarepo.save(comp);
	}
	
	//retrieving academic complaints
	public List<Academic> viewfile(){
		return acarepo.findAll();
	}
	
	//inserting academic complaint
	public Academic mailcomp(Academic cp) {
		Academic comp=acarepo.save(cp);
		Authorized auth=authrepo.findByComplaintType(comp.getComplaintType());
		if(auth!=null) {
			String to=auth.getEmail();
			String subject="new complaint filed";
			String body=comp.toString();
			mail.sendmail(to, subject, body);
		}
		else {
			System.out.println("no authorized person found");
		}
		return comp;
	}
	
	public List<Authorized> getAuthorizedByComplaintType(String complaintType) {
        return (List<Authorized>) authrepo.findByComplaintType(complaintType);
    }
	
	
	//inserting non academic complaint
	public String upload(Non_academic_comp comp) {
		Non_academic_comp cp=nonrepo.save(comp);
		Authorized auth=authrepo.findByComplaintType(cp.getComplaintType());
		if(auth!=null) {
			String to=auth.getEmail();
			String subject="new complaint failed";
			String body=cp.toString();
			mail.sendmail(to, subject, body);
		}
		else {
			System.out.println("no authorized person found");
		}
		return "inserted";
	}
	
	//login for management
	public Authorized logg(String email) {
		return authrepo.findByEmail(email);
	}
	
	//retrieving non academic complaints
	public List<Non_academic_comp> view(){
		return nonrepo.findAll();
	}
	
	//inserting sensitive complaint
	public Sensitive_comp insertt(Sensitive_comp comp) {
		return senrepo.save(comp);
	}
	
	public List<Academic> updatestatus(List<Academic> entities){
		List<Academic> upentity=acarepo.saveAll(entities);
		return upentity;
	}
	
	public List<Non_academic_comp> nupdatestatus(List<Non_academic_comp> entities){
		List<Non_academic_comp> upentity=nonrepo.saveAll(entities);
		return upentity;
	}
	
	
	

		
	
	
	//update academic status
//	public void updateComplaintStatus(Academic academics) {
//		Authorized authorized=getLoggedInAuth();
//		if(authorized!=null && authorized.getComplaintType().equals(academics.getComplaintType())) {
//			acarepo.save(academics);
//		}
//		
//	}
	
	//non update academic status
//	public void updateComplaintStatus(Non_academic_comp nonaca) {
//		Authorized authorized=getLoggedInAuth();
//		if(authorized!=null && authorized.getComplaintType().equals(nonaca.getComplaintType())) {
//			nonrepo.save(nonaca);
//		}
//	}

//	private Authorized getLoggedInAuth() {
//		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		 if (principal instanceof UserDetails) {
//	            String username = ((UserDetails)principal).getUsername();
//	            return authrepo.findByEmail(username);
//	        }
//		return null;
//	}
	
	//displaying complaint type 
	public List<Academic> disaca(String complaintType){
		return acarepo.findByComplaintType(complaintType);
	}
	
	//displaying non academic complaint type 
	public List<Non_academic_comp> disnon(String complaintType){
		return nonrepo.findByComplaintType(complaintType);
	}
	
	
	
	 
	 public Map<String, Integer> generateReport() {
	        Map<String, Integer> report = new HashMap<>();

	        // Generate report for academic complaints
	        List<Academic> academicComplaints = acarepo.findAll();
	        for (Academic complaint : academicComplaints) {
	            String complaintType = complaint.getComplaintType();
	            report.put(complaintType, report.getOrDefault(complaintType, 0) + 1);
	        }

	        // Generate report for non-academic complaints
	        List<Non_academic_comp> nonAcademicComplaints = nonrepo.findAll();
	        for (Non_academic_comp complaint : nonAcademicComplaints) {
	            String complaintType = complaint.getComplaintType();
	            report.put(complaintType, report.getOrDefault(complaintType, 0) + 1);
	        }

	        return report;
	    }
  
}
