package com.entity;

/**
 * 数据库映射类
 * @author shaokui
 *
 */
public class User {
	
	private Integer idsInteger;//id
	
	private String nameString;//姓名
	
	private Integer ageInteger;//年龄
	
	private String genderString;//性别

	public User() {
		super();
	}

	public User(Integer idsInteger, String nameString, Integer ageInteger, String genderString) {
		super();
		this.idsInteger = idsInteger;
		this.nameString = nameString;
		this.ageInteger = ageInteger;
		this.genderString = genderString;
	}

	public Integer getIdsInteger() {
		return idsInteger;
	}

	public void setIdsInteger(Integer idsInteger) {
		this.idsInteger = idsInteger;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Integer getAgeInteger() {
		return ageInteger;
	}

	public void setAgeInteger(Integer ageInteger) {
		this.ageInteger = ageInteger;
	}

	public String getGenderString() {
		return genderString;
	}

	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}
	
	@Override
	public String toString() {
		return "[id="+idsInteger+"name="+nameString+
				"age="+ageInteger+"gender="+genderString+"]";
	}
	

}
