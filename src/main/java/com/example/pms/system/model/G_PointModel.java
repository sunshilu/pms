package com.example.pms.system.model;

import java.util.Date;

public class G_PointModel extends BaseModel {
	public String userCode;
	public String memberCode;
	public String termCode;
	public Date date;
	public String grade;
	public String field1;
	public String field2;
	public String field3;
	private Date startDate;
	private Date endDate;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "G_PointModel [userCode=" + userCode + ", memberCode=" + memberCode + ", termCode=" + termCode
				+ ", date=" + date + ", grade=" + grade + ", field1=" + field1 + ", field2=" + field2 + ", field3="
				+ field3 + "]";
	}

}
