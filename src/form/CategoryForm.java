package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Category;

public class CategoryForm extends ActionForm {
	private int categoryId;
	private String categoryParent;
	private String categoryName;
	private ArrayList<Category> listCategory;
	private String btnUpdate;
	
	public void addCategoryForm(String categoryParent, String categoryName){
		this.categoryParent = categoryParent;
		this.categoryName = categoryName;
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
	public ArrayList<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(ArrayList<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public String getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(String btnUpdate) {
		this.btnUpdate = btnUpdate;
	}
	
}
