package model.bean;

import java.sql.Date;

public class Person extends Account {
	private String fullName;
	private String gender;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private Date createdday;
	
	public Person(String userName, String password, int type, boolean status, String fullName, String gender,
			Date birthday, String address, String phone, String email, Date createdday) {
		super(userName, password, type, status);
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;

	}

	
	
	public Person(String fullName, String gender, Date birthday, String address, String phone, String email) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}



	public Person() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedday() {
		return createdday;
	}

	public void setCreatedday(Date createdday) {
		this.createdday = createdday;
	}
}
