package model.bo;

import java.util.ArrayList;

import model.bean.ProductDetail;
import model.dao.ProductDetailDAO;


public class ProductDetailBO {
	ProductDetailDAO productDetailDAO = new ProductDetailDAO();
	
	public ArrayList<ProductDetail> getListProductDetail(int productId) {
		return productDetailDAO.getListProductDetail(productId);
	}
	
	public void insertProductDetail(ProductDetail productDetail) {
		productDetailDAO.insertProductDetail(productDetail);
	}
	
	public void updateProductDetail(ProductDetail productDetail) {
		productDetailDAO.updateProductDetail(productDetail);
	}
	
	public void deleteProductDetail(int productDetailId) {
		productDetailDAO.deleteProductDetail(productDetailId);
	}

	public ProductDetail getProductDetail(int productId) {
		return productDetailDAO.getProductDetail(productId);
	}
	public ArrayList<ProductDetail> getListProductDetail() {
		return productDetailDAO.getProductDetail();
	}
}
