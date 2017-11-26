package model.bean;

public class Category {
	private int categoryId;
	private String categoryParent;
	private String categoryName;
	
	public Category(int categoryId, String categoryParent, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryParent = categoryParent;
		this.categoryName = categoryName;
	}
	
	public Category() {
		super();
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryParent() {
		return categoryParent;
	}
	public void setCategoryParent(String categoryParent) {
		this.categoryParent = categoryParent;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
