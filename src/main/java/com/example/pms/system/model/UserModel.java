package com.example.pms.system.model;

public class UserModel extends BaseModel {
	private String password;
	private String roleCode;
	private String parentCode;

	private String parentName;
	private String departmentCode;
	private String markTime;
	private String markState;
	private String parentDepartmentName;
	private String startDate;
	private String endDate;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getMarkTime() {
		return markTime;
	}

	public void setMarkTime(String markTime) {
		this.markTime = markTime;
	}

	public String getMarkState() {
		return markState;
	}

	public void setMarkState(String markState) {
		this.markState = markState;
	}

	public String getParentDepartmentName() {
		return parentDepartmentName;
	}

	public void setParentDepartmentName(String parentDepartmentName) {
		this.parentDepartmentName = parentDepartmentName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "UserModel [code="+super.getCode()+",password=" + password + ", roleCode=" + roleCode + ", parentCode=" + parentCode
				+ ", parentName=" + parentName + ", departmentCode=" + departmentCode + ", markTime=" + markTime
				+ ", markState=" + markState + ", parentDepartmentName=" + parentDepartmentName + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	public UserModel(String password, String roleCode, String parentCode) {
		super();
		this.password = password;
		this.roleCode = roleCode;
		this.parentCode = parentCode;
	}

	public UserModel() {
		super();
	}
}
