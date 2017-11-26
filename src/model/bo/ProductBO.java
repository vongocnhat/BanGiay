package model.bo;

import java.util.ArrayList;

import model.bean.Product;
import model.bean.ProductDetailSQ;
import model.dao.ProductDAO;


public class ProductBO {
	private ProductDAO productDAO = new ProductDAO();
	
	public ArrayList<Product> getListProduct() {
		return productDAO.getListProduct();
	}
	
	public ArrayList<Product> getListProductTop4() {
		return productDAO.getListProductTop4();
	}
	
	public void insertProduct(Product product) {
		productDAO.insertProduct(product);
	}
	
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}
	
	public Product getProduct(int productId) {
		return productDAO.getProduct(productId);
	}
	//thêm vào
	public ArrayList<Product> getListProductByCategoryId(int categoryId) {
		return productDAO.getListProductByCategoryId(categoryId);
	}
	//phuoc
	public ArrayList<ProductDetailSQ> getListOrderProductPrice(String order)
	{
		return productDAO.getListOrderProductPrice(order);
	}
	public ArrayList<ProductDetailSQ> getListOrderProductName(String order)
	{
		return productDAO.getListOrderProductName(order);
	}
	// dungnv 14-08
	public ArrayList<Product> getListProductNumberViewed() {
		return productDAO.getListProductNumberViewed();
	}
	// dungnv 14-08
	public ArrayList<Product> getListProductNumberSeller() {
		return productDAO.getListProductNumberSeller();
	}
	public ArrayList<Product> getListSearchProduct(String productName) {
		return productDAO.getListSearchProduct(productName);
	}
	public ArrayList<Product> getListSearchProductYeuThich(String userName) {
		return productDAO.getListSearchProductYeuThich(userName);
	}
	public void increaseNumberViewed(int productId) {
		productDAO.increaseNumberViewed(productId);
	}
	//sort product
	public ArrayList<Product> sortListProduct(String column,String sortType) {
		return productDAO.sortListProduct(column, sortType);
	}
}
