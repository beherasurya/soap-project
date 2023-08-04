package com.app.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.soap.model.Student;
import com.app.soap.repository.StudentRepository;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public GetStudentDetailsResponse getStudentDetails(GetStudentDetailsRequest request) {
		
	    GetStudentDetailsResponse response = new GetStudentDetailsResponse();
	    Student student = studentRepository.findById(request.getId()).get();
	    
	    response.setStudentDetails(student); 
		return response;
	}

}
