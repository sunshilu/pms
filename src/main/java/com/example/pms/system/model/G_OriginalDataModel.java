package com.example.pms.system.model;

public class G_OriginalDataModel {
	private String member01;
	private String member02;
	private String member03;
	private String member04;
	private String member05;
	private String member06;
	private String member07;
	private String member08;
	private String member09;
	private String member10;
	private String grade;

	public String getMember01() {
		return member01;
	}

	public void setMember01(String member01) {
		this.member01 = member01;
	}

	public String getMember02() {
		return member02;
	}

	public void setMember02(String member02) {
		this.member02 = member02;
	}

	public String getMember03() {
		return member03;
	}

	public void setMember03(String member03) {
		this.member03 = member03;
	}

	public String getMember04() {
		return member04;
	}

	public void setMember04(String member04) {
		this.member04 = member04;
	}

	public String getMember05() {
		return member05;
	}

	public void setMember05(String member05) {
		this.member05 = member05;
	}

	public String getMember06() {
		return member06;
	}

	public void setMember06(String member06) {
		this.member06 = member06;
	}

	public String getMember07() {
		return member07;
	}

	public void setMember07(String member07) {
		this.member07 = member07;
	}

	public String getMember08() {
		return member08;
	}

	public void setMember08(String member08) {
		this.member08 = member08;
	}

	public String getMember09() {
		return member09;
	}

	public void setMember09(String member09) {
		this.member09 = member09;
	}

	public String getMember10() {
		return member10;
	}

	public void setMember10(String member10) {
		this.member10 = member10;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "G_OriginalDataModel [member01=" + member01 + ", member02=" + member02 + ", member03=" + member03
				+ ", member04=" + member04 + ", member05=" + member05 + ", member06=" + member06 + ", member07="
				+ member07 + ", member08=" + member08 + ", member09=" + member09 + ", member10=" + member10 + ", grade="
				+ grade + "]";
	}

	private G_OriginalDataModel(String member01, String member02, String member03, String member04, String member05,
			String member06, String member07, String member08, String member09, String member10, String grade) {
		super();
		this.member01 = member01;
		this.member02 = member02;
		this.member03 = member03;
		this.member04 = member04;
		this.member05 = member05;
		this.member06 = member06;
		this.member07 = member07;
		this.member08 = member08;
		this.member09 = member09;
		this.member10 = member10;
		this.grade = grade;
	}
}
