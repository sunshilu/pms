package com.example.pms.system.model;

public class G_PointModel extends BaseModel {
	public String userCode;
	public String memberCode;
	public String termCode;
	public String date;
	public String grade;
	public String field1;
	public String field2;
	public String field3;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	@Override
	public String toString() {
		return "userCode=" + userCode + ", memberCode=" + memberCode
				+ ", termCode=" + termCode + ", date=" + date + ", field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}
}
