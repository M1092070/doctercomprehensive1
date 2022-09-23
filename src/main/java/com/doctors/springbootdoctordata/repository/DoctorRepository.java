package com.doctors.springbootdoctordata.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.doctors.springbootdoctordata.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

	Doctor findByName(String name);
	
	

}
