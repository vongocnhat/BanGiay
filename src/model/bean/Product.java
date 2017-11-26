package model.bean;

public class Product {
	private int productId;
	private int categoryId;
	private String productName;
	private long numberViewed;
	private long numberSeller;
	private String description;
	private long price;
	private String categoryName;
	private String categoryParent;
	private String image;
	
	

	public Product(int categoryId, String productName, String description, long price, String image) {
		super();
		this.categoryId = categoryId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public Product() {
		
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getNumberViewed() {
		return numberViewed;
	}

	public void setNumberViewed(long numberViewed) {
		this.numberViewed = numberViewed;
	}
	public void setIncreaseNumberViewed() {
		numberViewed++;
	}
	public long getNumberSeller() {
		return numberSeller;
	}

	public void setNumberSeller(long numberSeller) {
		this.numberSeller = numberSeller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(String categoryParent) {
		this.categoryParent = categoryParent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
