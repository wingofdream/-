package com.hibernatedemo.model;

import java.util.List;

import com.xdm.strutsmvc.hibernate.HibernateDAO;

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateDAO dao = new HibernateDAO();
		College col = (College)dao.findByID(College.class, "30");
		col.setCollegeName("Ÿ‚√Œ4900");
		System.out.println(dao.update(col));
	}

}
