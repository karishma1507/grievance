package com.tns.fm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.http.MediaType;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CompController {
	@Autowired
	CompService service;
	
	
	//login for management
	@PostMapping("/loginman")
	public ResponseEntity<?> logman(@RequestBody Authorized user){
		Authorized auth=service.logg(user.getEmail());
		if(auth!=null && auth.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok(auth);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credentials");
		}
	}
	
	//inserting academic complaints
	@PostMapping("/academics")
	public ResponseEntity<Academic> addFile(@RequestBody Academic c){
		Academic es=service.filecomp(c);
		return new ResponseEntity<>(es,HttpStatus.CREATED);
	}
	
	@GetMapping("/view academics")
	public List<Academic> disfile(){
		return service.viewfile();
	}
	
	@PostMapping("/mail file")
	public ResponseEntity<Academic> mailadd(@RequestBody Academic cs){
		Academic ac=service.mailcomp(cs);
		return new ResponseEntity<>(ac,HttpStatus.CREATED);
	}
	//login for student
	@PostMapping("/loginstu")
	public ResponseEntity<?> logst(@RequestBody Member user){
		Member mem= service.login(user.getEmail());
		if(mem!=null && mem.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("login successfull");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
	
	//retrieving members
	@GetMapping("/members")
	public List<Member> listAll(){
		return service.display();
	}
	
	
	
	//inserting non academics
	@PostMapping("/non academics")
	public ResponseEntity<String> uploadData(@RequestParam("name") String name,@RequestParam("email") String email,
			@RequestParam("mobile") long mobile,@RequestParam("department") String department,@RequestParam("complaintType") String complaintType,
			@RequestParam("file") MultipartFile file,@RequestParam("location") String location,@RequestParam("complaint") String complaint,@RequestParam("date") String date) 
	{
		try {
			Non_academic_comp entity=new Non_academic_comp();
			
			entity.setName(name);
			entity.setEmail(email);
			entity.setDepartment(department);
			entity.setComplaintType(complaintType);
			entity.setLocation(location);
			entity.setComplaint(complaint);
			entity.setDate(date);
			if(!file.isEmpty()) {
				entity.setImage(file.getBytes());
			}
			service.upload(entity);
			 return ResponseEntity.ok("Image and data uploaded successfully.");
			
		}
		catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image and data.");
        }
	}
	
	//non academic complaints
	@GetMapping("/view non")
	public List<Non_academic_comp> viewAll(){
		return service.view();
	}

	//inserting sensitive complaint
	@PostMapping("/sensitive")
	public ResponseEntity<Sensitive_comp> insertall(@RequestBody Sensitive_comp sc){
		Sensitive_comp ens=service.insertt(sc);
		return new ResponseEntity<>(ens,HttpStatus.CREATED);
	}
	
	//updating academic status
	@PutMapping("/academic status")
	public ResponseEntity<List<Academic>> updateStatus(@RequestBody List<Academic> entities){
		List<Academic> upent=service.updatestatus(entities);
		return ResponseEntity.ok(upent);
	}
	
	//updating non academic status
	@PutMapping("/non status")
	public ResponseEntity<List<Non_academic_comp>> nonupdateStatus(@RequestBody List<Non_academic_comp> entities){
		List<Non_academic_comp> upent=service.nupdatestatus(entities);
		return ResponseEntity.ok(upent);
	}
	
	//displaying only the complaint type
	@GetMapping("/update status/{complaintType}")
    public ResponseEntity<List<Authorized>> getAuthorizedByComplaintType(@PathVariable String complaintType) {
        List<Authorized> authorizedList = service.getAuthorizedByComplaintType(complaintType);
        return new ResponseEntity<>(authorizedList, HttpStatus.OK);
    }
	
	
//	@PutMapping("/academicstatus")
//	public void updateAcademicsComplaintStatus(@RequestBody Academic academics) {
//		service.updateComplaintStatus(academics);
//	}
//	
//	
//	@PutMapping("/nonacademicstatus")
//	public void updateNonAcademicsComplaintStatus(@RequestBody Non_academic_comp nonaca) {
//		service.updateComplaintStatus(nonaca);
//	}
//	
	@GetMapping("/acasta/{complaintType}")
	public List<Academic> disacademic(@PathVariable String complaintType){
		return service.disaca(complaintType);
	}
	
	
	@GetMapping("/nonacast/{complaintType}")
	public List<Non_academic_comp> disnonacademic(@PathVariable String complaintType){
		return service.disnon(complaintType);
	}
	
	
	
	
	@GetMapping("/report")
    public ResponseEntity<Map<String, Integer>> generateComplaintReport() {
        Map<String, Integer> report = service.generateReport();
        return ResponseEntity.ok(report);
    }
}
