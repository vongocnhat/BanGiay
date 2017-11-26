package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Category;

public class AddProductForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String action;
	private String submit;
	ArrayList<Category> listCategory;
	
	private int categoryId;
	private String productName;
	private String description;
	private long price;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(ArrayList<Category> listCategory) {
		this.listCategory = listCategory;
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
}
