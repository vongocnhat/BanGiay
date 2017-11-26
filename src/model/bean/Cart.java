package model.bean;

public class Cart {
	//can lay orderdetail
	private int productDetailSQId;
	private long price;
	private int quantity;
	//
	private String productName;
	private String image;
	private String color;
	private int productDetailId;
	
	private float size;
	

	

	public Cart(String productName, String image, String color, long price, int productDetailId, int productDetailSQId,
			float size, int quantity) {
		super();
		this.productName = productName;
		this.image = image;
		this.color = color;
		this.price = price;
		this.productDetailId = productDetailId;
		this.productDetailSQId = productDetailSQId;
		this.size = size;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getTotalPrice() {
		return price * quantity;
	}

	public int getProductDetailSQId() {
		return productDetailSQId;
	}

	public void setProductDetailSQId(int productDetailSQId) {
		this.productDetailSQId = productDetailSQId;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}
}
