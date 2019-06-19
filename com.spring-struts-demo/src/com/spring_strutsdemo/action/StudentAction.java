package com.spring_strutsdemo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spring_strutsdemo.bean.Student;
import com.spring_strutsdemo.services.StudentServices;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private StudentServices studentServices;
	
	public String addStudent(){		
		studentServices.insert(student);
		return "success";
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentServices getStudentServices() {
		return studentServices;
	}
	public void setStudentServices(StudentServices studentServices) {
		this.studentServices = studentServices;
	}

}
