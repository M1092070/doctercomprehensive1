package com.doctors.springbootdoctordata.exception;

public class DoctorException extends Exception {
	
	@Override
	public String getMessage() {
		return "id is already present";
	}

}
