package com.egen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.egen.util.Gender;

@Entity
@Table(name="USER")
public class UserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1754476872550469634L;

	@Id
	@Column(name ="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name ="MIDDLE_NAME")
	private String middleName;
	
	@Column(name ="LAST_NAME")
	private String lastName;
	
	@Column(name ="AGE")
	private int age;
	
	@Column(name ="GENDER")
	private Gender gender;
	
	@Column(name ="PHONE_NUMBER")
	private int phoneNumber;
	
	@Column(name ="ZIP")
	private long zip;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	
}
