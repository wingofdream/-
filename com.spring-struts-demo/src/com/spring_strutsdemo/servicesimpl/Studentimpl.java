package com.spring_strutsdemo.servicesimpl;

import com.spring_strutsdemo.bean.Student;
import com.spring_strutsdemo.services.StudentServices;

public class Studentimpl implements StudentServices{

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		System.out.println("-------------insertStudent---------------");
		System.out.println(student.getName());	
	}
	
}
