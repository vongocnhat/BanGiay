package model.bo;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import model.bean.ProductDetailSQ;
import model.dao.ProductDetailSQDAO;

public class ProductDetailSQBO {
	ProductDetailSQDAO productDAO=new ProductDetailSQDAO();
//	public ArrayList<ProductDetailSQ> getListProduct()
//	{
//		return productDAO.getListProduct();
//	}
	public ArrayList<ProductDetailSQ> getListProductByCategoryId(int categoryId)
	{
		return productDAO.getListProductByCategoryId(categoryId);
	}
	public ArrayList<ProductDetailSQ> getListSearchProduct(String stringSearch)
	{
		return productDAO.getListSearchProduct(stringSearch);
	}
	public ProductDetailSQ detailProduct(int productId)
	{
		return productDAO.detailProduct(productId);
	}
	public ArrayList<ProductDetailSQ> getListProductDetailSQ(int productDetailId){
		return productDAO.getListProductDetailSQ(productDetailId);
	}
	///
	public ArrayList<ProductDetailSQ> getListSearchProductYeuThich(String userName)
	{
		return productDAO.getListSearchProductYeuThich(userName);
	}
	public void reducedQuantity(int productDetailSQId, int quantity) {
		productDAO.reducedQuantity(productDetailSQId, quantity);
	}
	
}
