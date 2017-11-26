package model.bean;

import java.sql.Date;

public class Favorites {
	private String userName;
	private int productId;
	private Date createdday;
	
	public Favorites() {
		super();
	}
	public Favorites(String userName, int productId, Date createdday) {
		super();
		this.userName = userName;
		this.productId = productId;
		this.createdday = createdday;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getCreatedday() {
		return createdday;
	}
	public void setCreatedday(Date createdday) {
		this.createdday = createdday;
	}
}
