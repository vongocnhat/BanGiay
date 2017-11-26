package model.bean;

public class Rate {
	private int productId;
	private String userName;
	private int star;
	
	public Rate() {
		super();
	}
	public Rate(int productId, String userName, int star) {
		super();
		this.productId = productId;
		this.userName = userName;
		this.star = star;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
}
