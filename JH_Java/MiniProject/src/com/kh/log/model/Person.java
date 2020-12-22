package com.kh.log.model;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 3834952953664523379L;
	
	private String name;
	private int age;
	private char gender;
	private String ID;
	private String PassWord;
	
	public Person() {
	}

	public Person(String name, int age, char gender, String iD, String passWord) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		ID = iD;
		PassWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	@Override
	public String toString() {
		return "회원정보 [이름= " + this.name + ", 나이= " + this.age + ", 성별= " + this.gender + ", ID= " + this.ID + ", PassWord= " + this.PassWord
				+ "]";
	}
	
	
}
