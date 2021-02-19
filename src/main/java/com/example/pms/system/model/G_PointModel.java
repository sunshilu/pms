package com.example.pms.system.model;

public class G_PointModel {
	public int id;
	public String code;
	public String userCode;
	public String memberCode;
	public String termCode;
	public String date;
	public String field1;
	public String field2;
	public String field3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	@Override
	public String toString() {
		return "G_PointModel [id=" + id + ", code=" + code + ", userCode=" + userCode + ", memberCode=" + memberCode
				+ ", termCode=" + termCode + ", date=" + date + ", field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}

	public G_PointModel(int id, String code, String userCode, String memberCode, String termCode, String date,
			String field1, String field2, String field3) {
		super();
		this.id = id;
		this.code = code;
		this.userCode = userCode;
		this.memberCode = memberCode;
		this.termCode = termCode;
		this.date = date;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
}
