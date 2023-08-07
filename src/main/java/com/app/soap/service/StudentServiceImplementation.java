package com.app.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.soap.model.Student;
import com.app.soap.repository.StudentRepository;
import com.in28minutes.students.CreateStudentDetailsRequest;
import com.in28minutes.students.CreateStudentDetailsResponse;
import com.in28minutes.students.DeleteStudentDetailsRequest;
import com.in28minutes.students.DeleteStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.StudentCreated;
import com.in28minutes.students.StudentDeleted;
import com.in28minutes.students.StudentDetails;
import com.in28minutes.students.StudentUpdated;
import com.in28minutes.students.UpdateStudentDetailsRequest;
import com.in28minutes.students.UpdateStudentDetailsResponse;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public GetStudentDetailsResponse getStudentDetails(GetStudentDetailsRequest request) {
		
	    GetStudentDetailsResponse response = new GetStudentDetailsResponse();
	    Student student = studentRepository.findById(request.getId()).get();

	    StudentDetails studentDetails = studentToStudentDetails(student);
	    response.setStudentDetails(studentDetails); 
		return response;
	}

	@Override
	public CreateStudentDetailsResponse createStudent(CreateStudentDetailsRequest request) {


		CreateStudentDetailsResponse response = new CreateStudentDetailsResponse();
		Student student = createStudentDetailsRequestToStudent(request);
		
		student = studentRepository.save(student);
		StudentCreated created = studentToStudentCreated(student);
		
		response.setStudentCreated(created);
		return response;
	}
	
	private StudentCreated studentToStudentCreated(Student student) {
		
		StudentCreated studentCreated = new StudentCreated();
		studentCreated.setId(student.getId());
		
		studentCreated.setName(student.getName());
		studentCreated.setPassportNumber(student.getPassportNumber());
		
		return studentCreated;
	}

	private StudentDetails studentToStudentDetails(Student student) {
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(student.getId());
		
		studentDetails.setName(student.getName());
		studentDetails.setPassportNumber(student.getPassportNumber());
		
		return studentDetails;
	}
	private Student createStudentDetailsRequestToStudent(CreateStudentDetailsRequest re) {
		Student student = new Student();
		student.setId(re.getId());
		
		student.setName(re.getName());
		student.setPassportNumber(re.getPassportNumber());
		
		return student;
	}

	@Override
	public DeleteStudentDetailsResponse deleteStudent(DeleteStudentDetailsRequest request) {
		Student student = studentRepository.findById(request.getId()).get();
		studentRepository.deleteById(request.getId());
		
		StudentDeleted studentDeleted = studentToStudentDeleted(student);
		DeleteStudentDetailsResponse response = new DeleteStudentDetailsResponse();
		
		response.setStudentDeleted(studentDeleted);
		return response;
		
	}

	private StudentDeleted studentToStudentDeleted(Student student) {
		StudentDeleted studentDeleted = new StudentDeleted();
		studentDeleted.setId(student.getId());
		
		studentDeleted.setName(student.getName());
		studentDeleted.setPassportNumber(student.getPassportNumber());
		
		studentDeleted.setStatus("Student Details Deleted");
		return studentDeleted;
	}
	@Override
	public UpdateStudentDetailsResponse updateStudent(UpdateStudentDetailsRequest request) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(request.getId()).get();
		student.setName(request.getName());
		
		student.setPassportNumber(request.getPassportNumber());		
		student = studentRepository.save(student);
		StudentUpdated updated = studentToStudentUpdated(student);
		
		UpdateStudentDetailsResponse response = new UpdateStudentDetailsResponse();
		response.setStudentUpdated(updated);
		return response;
	}
	private StudentUpdated studentToStudentUpdated(Student student) {
		
		StudentUpdated studentUpdated = new StudentUpdated();
		studentUpdated.setId(student.getId());
		
		studentUpdated.setName(student.getName());
		studentUpdated.setPassportNumber(student.getPassportNumber());
		
		studentUpdated.setStatus("Student Details Updated");
		return studentUpdated;
	}
	

}
