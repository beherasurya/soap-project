package com.app.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.app.soap.service.StudentService;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;

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

}
