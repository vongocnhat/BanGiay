package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Category;
import model.bean.Product;

public class ListProductForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private ArrayList<Category> listCategory;
	private ArrayList<Product> listProduct;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public ArrayList<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(ArrayList<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public ArrayList<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(ArrayList<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
