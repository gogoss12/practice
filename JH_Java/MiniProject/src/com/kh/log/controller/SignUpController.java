package com.kh.log.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kh.log.model.Person;

public class SignUpController implements Serializable{
	
	private static final long serialVersionUID = -3320029760672457637L;
	
	List<Person> person = new ArrayList<Person>();

	public void Person(String name, int age, char gender, String iD, String passWord) {

		// log에 받아온 정보들을 저장
		person.add(new Person(name, age, gender, iD, passWord));

		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("회원 정보.dat"))) {
			//"회원 정보" 파일에 저장된 정보들 입력
				
				oos.writeObject(person);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Person> getLog() {
		return person;
	}

}
