package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Category;
import model.bean.Product;

public class ProductForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private int categoryId;
	private String productName;
	private long numberViewed;
	private long numberSeller;
	private String description;
	private long price;
	private ArrayList<Product> listProduct;
	private ArrayList<Category> listCategory;
	private String btnUpdate;

	public void addProductForm(int categoryId, String productName, String description, long price) {
		this.categoryId = categoryId;
		this.productName = productName;
		this.description = description;
		this.price = price;
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

	public String getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(String btnUpdate) {
		this.btnUpdate = btnUpdate;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
}
