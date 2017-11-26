package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Accessories;
import model.bean.Category;
import model.bean.CommentProduct;
import model.bean.Product;
import model.bean.ProductDetail;
import model.bean.ProductDetailSQ;
import model.bean.Promotion;

public class DanhSachProductForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private int categoryId;
	private String submit;
	private String stringSearch;
	private ArrayList<Category> listCategory;
	private Product product;
	private Category category;
//	sản phẩm liên quan
	private ArrayList<Product> listProduct;
	private ArrayList<ProductDetail> listProductDetail;
	private ArrayList<ProductDetailSQ> listProductDetailSQ;
	private ArrayList<Promotion> listPromotion;
	private ArrayList<Accessories> listAccessories;
	private ArrayList<CommentProduct> listCommentProduct;
	//phuoc
	private String orderProduct;
	
	//dungnv
	private String userName;
	//dungnv 14-08
	private ArrayList<Product> listProductNumberViewed;
	private ArrayList<Product> listProductNumberSeller;
	//sort
	private String column;
	private String sortType;
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public ArrayList<Product> getListProductNumberViewed() {
		return listProductNumberViewed;
	}

	public void setListProductNumberViewed(ArrayList<Product> listProductNumberViewed) {
		this.listProductNumberViewed = listProductNumberViewed;
	}

	public ArrayList<Product> getListProductNumberSeller() {
		return listProductNumberSeller;
	}

	public void setListProductNumberSeller(ArrayList<Product> listProductNumberSeller) {
		this.listProductNumberSeller = listProductNumberSeller;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getStringSearch() {
		return stringSearch;
	}

	public void setStringSearch(String stringSearch) {
		this.stringSearch = stringSearch;
	}

	public ArrayList<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(ArrayList<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ArrayList<ProductDetail> getListProductDetail() {
		return listProductDetail;
	}

	public void setListProductDetail(ArrayList<ProductDetail> listProductDetail) {
		this.listProductDetail = listProductDetail;
	}

	public ArrayList<ProductDetailSQ> getListProductDetailSQ() {
		return listProductDetailSQ;
	}

	public void setListProductDetailSQ(ArrayList<ProductDetailSQ> listProductDetailSQ) {
		this.listProductDetailSQ = listProductDetailSQ;
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

	public ArrayList<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(ArrayList<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public ArrayList<Promotion> getListPromotion() {
		return listPromotion;
	}

	public void setListPromotion(ArrayList<Promotion> listPromotion) {
		this.listPromotion = listPromotion;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ArrayList<Accessories> getListAccessories() {
		return listAccessories;
	}

	public void setListAccessories(ArrayList<Accessories> listAccessories) {
		this.listAccessories = listAccessories;
	}

	public ArrayList<CommentProduct> getListCommentProduct() {
		return listCommentProduct;
	}

	public void setListCommentProduct(ArrayList<CommentProduct> listCommentProduct) {
		this.listCommentProduct = listCommentProduct;
	}

	public String getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}

}
