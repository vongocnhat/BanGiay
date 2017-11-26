package model.bean;

import java.sql.Date;

public class Order {
	private int orderId;
	private String userName;
	private String fullName;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private String method;
	private Date birthday;
	private int totalQuantity;
	private long totalPrice;
	private boolean status;
	private boolean confirm;
	private String createdday;

	public Order(String userName, String fullName, String email, String phone, String address, String gender,
			String method, Date birthday, int totalQuantity, long totalPrice, boolean status, boolean confirm, String createdday) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.method = method;
		this.birthday = birthday;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.confirm = confirm;
		this.createdday = createdday;
	}

	public Order() {
		super();
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCreatedday() {
		return createdday;
	}
	public void setCreatedday(String createdday) {
		this.createdday = createdday;
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

	public boolean getConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
}
