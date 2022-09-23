package com.doctors.springbootdoctordata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.springbootdoctordata.entity.Doctor;
import com.doctors.springbootdoctordata.exception.DoctorException;
import com.doctors.springbootdoctordata.service.DoctorService;

@RestController
@RequestMapping("/doc")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	@PostMapping("/addDoctor")
	public ResponseEntity  addDoctor(@RequestBody Doctor doctor) {
		if (service.addDoctor(doctor))
		return new ResponseEntity<>(new DoctorException().getMessage(),HttpStatus.CONFLICT);
		return ResponseEntity.ok(doctor);
		
	}
	@PostMapping("/addDoctors")
	public List <Doctor> addDoctors(@RequestBody List<Doctor> doctors){
		return service.saveDoctors(doctors);
	}
	@GetMapping("/doctors")
	public List<Doctor> findallDoctors(){
		return service.getDoctors();
	}
	
	@GetMapping("/{field}")
	public List<Doctor> getDoctorwithSort(@PathVariable String field){
		List<Doctor>allDoctors = service.findDoctorWithSorting (field);
		return allDoctors;
	}
	@GetMapping("/doctorById/{id}")
	public Doctor findDoctorById(@PathVariable int id) {
		return service.getDoctorById(id);
	}
	
	@GetMapping("/doctor/{name}")
	public Doctor findDoctorByName(@PathVariable String name) {
		return service.getDoctorByName(name);
	}
	
	@PutMapping("/update")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return service.updateDoctor(doctor);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable int id) {
		return service.deleteDoctor(id);
		
	}
	
	
	
	

}
