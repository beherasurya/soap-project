package com.app.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.app.soap.service.StudentService;
import com.in28minutes.students.CreateStudentDetailsRequest;
import com.in28minutes.students.CreateStudentDetailsResponse;
import com.in28minutes.students.DeleteStudentDetailsRequest;
import com.in28minutes.students.DeleteStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.UpdateStudentDetailsRequest;
import com.in28minutes.students.UpdateStudentDetailsResponse;

@Endpoint
public class StudentController {

	
	@Autowired
	StudentService studentService;


	  @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "GetStudentDetailsRequest")
	  @ResponsePayload
	  public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {

		GetStudentDetailsResponse response = studentService.getStudentDetails(request);
	    return response;
	  }
	  
	  @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "CreateStudentDetailsRequest")
	  @ResponsePayload
	  public CreateStudentDetailsResponse processCreateStudentRequest
	  (@RequestPayload CreateStudentDetailsRequest request) {
		  
		  CreateStudentDetailsResponse response = studentService.createStudent(request);
		  return response;
	  }
	  
	  @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "DeleteStudentDetailsRequest")
	  @ResponsePayload
	  public DeleteStudentDetailsResponse processDeleteStudentReuest
	  (@RequestPayload DeleteStudentDetailsRequest request) {
		  
		  DeleteStudentDetailsResponse response = studentService.deleteStudent(request);
		  return response;
	  }
	  
	  
	  @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "UpdateStudentDetailsRequest")
	  @ResponsePayload
	  public UpdateStudentDetailsResponse processUpdateStudentRequest
	  (@RequestPayload UpdateStudentDetailsRequest request) {
		  
		  UpdateStudentDetailsResponse response = studentService.updateStudent(request);
		  return response;
	  }

}
