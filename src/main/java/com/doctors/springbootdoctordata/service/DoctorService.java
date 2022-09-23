package com.doctors.springbootdoctordata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.doctors.springbootdoctordata.entity.Doctor;
import com.doctors.springbootdoctordata.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository repository;
	
	public boolean addDoctor (Doctor docs) {
		if(already(docs.getId()))
			return true ;
		repository.save(docs);
		return false;
	}
	
	private boolean already(int id) {
	
		return repository.existsById(id);
	}

	public List<Doctor> saveDoctors(List<Doctor> doctors){
		return repository.saveAll(doctors);
	}
	
	public List<Doctor> getDoctors(){
		return repository.findAll();
	}
	
	public Doctor getDoctorById(int id){
		return repository.findById(id).orElse(null);
	}
	
	public Doctor getDoctorByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteDoctor(int id) {
		repository.deleteById(id);
		return "Doctor removed from table" +id;
	}
	
	public Doctor updateDoctor(Doctor doctor) {
		Doctor existingDoctor=repository.findById(doctor.getId()).orElse(doctor);
		existingDoctor.setName(doctor.getName());
		existingDoctor.setSpecialist(doctor.getSpecialist());
		existingDoctor.setSalary(doctor.getSalary());
		return repository.save(existingDoctor);
		
	}
	
	public List<Doctor> findDoctorWithSorting(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.DESC, field));
	}

}
