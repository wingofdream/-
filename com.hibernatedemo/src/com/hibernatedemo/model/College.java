package com.hibernatedemo.model;

import java.util.Set;

/**
 * 分院信息
 * @author 兮梦
 *
 */
public class College {

	private String CollegeID;
	private String CollegeName;
	private String Remark;
	private Set<Department> departments;
	
	
	public String getCollegeID() {
		return CollegeID;
	}
	public void setCollegeID(String collegeID) {
		CollegeID = collegeID;
	}
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Set<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
}
