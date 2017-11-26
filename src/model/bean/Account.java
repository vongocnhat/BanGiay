package model.bean;

public class Account {
	private String userName;
	private String password;
	private int type;
	private boolean status;
	
	public Account(String userName, String password, int type, boolean status) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.status = status;
	}
	
	public Account() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
