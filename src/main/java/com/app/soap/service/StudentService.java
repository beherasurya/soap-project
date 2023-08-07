package com.app.soap.service;

import com.in28minutes.students.CreateStudentDetailsRequest;
import com.in28minutes.students.CreateStudentDetailsResponse;
import com.in28minutes.students.DeleteStudentDetailsRequest;
import com.in28minutes.students.DeleteStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.UpdateStudentDetailsRequest;
import com.in28minutes.students.UpdateStudentDetailsResponse;

public interface StudentService {

	 public GetStudentDetailsResponse getStudentDetails(GetStudentDetailsRequest request);
	 public CreateStudentDetailsResponse createStudent(CreateStudentDetailsRequest request);
	 
	 public DeleteStudentDetailsResponse deleteStudent(DeleteStudentDetailsRequest request);
	 public UpdateStudentDetailsResponse updateStudent(UpdateStudentDetailsRequest request);
}
