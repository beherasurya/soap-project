package com.app.soap.service;

import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;

public interface StudentService {

	 public GetStudentDetailsResponse getStudentDetails(GetStudentDetailsRequest request);
}
