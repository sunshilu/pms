package com.example.pms.system.model;

public class G_PointRecordModel extends BaseModel {
	private String pointMarkTime;
	private String timeQuantum;
	private String departmentCode;
	private String field1;
	private String field2;

	public String getPointMarkTime() {
		return pointMarkTime;
	}

	public void setPointMarkTime(String pointMarkTime) {
		this.pointMarkTime = pointMarkTime;
	}

	public String getTimeQuantum() {
		return timeQuantum;
	}

	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
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

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "G_PointRecordModel [pointMarkTime=" + pointMarkTime + ", timeQuantum=" + timeQuantum
				+ ", departmentCode=" + departmentCode + ", field1=" + field1 + ", field2=" + field2 + "]";
	}

}
