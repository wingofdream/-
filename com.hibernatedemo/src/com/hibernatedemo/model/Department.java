package com.hibernatedemo.model;

/**
 * 系部信息
 * @author 兮梦
 *
 */
public class Department {

	private String DepartmentID;
	private String DepartmentName;
	private College College;
	private String Remark;
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public College getCollege() {
		return College;
	}
	public void setCollege(College college) {
		College = college;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
}
