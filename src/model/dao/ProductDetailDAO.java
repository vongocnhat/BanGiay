package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ProductDetail;
import model.bean.ProductDetailSQ;
import model.bo.ProductDetailSQBO;

public class ProductDetailDAO {
	MyDatabase db = new MyDatabase();
	//chi tiet san pham
	public ArrayList<ProductDetail> getListProductDetail(int productId) {
		String sSql = "SELECT * FROM ProductDetail WHERE ProductId = "+productId;
		
		ResultSet rs = db.selectTable(sSql);
				
		ArrayList<ProductDetail> list = new ArrayList<ProductDetail>();
		try {
			while(rs.next()){
				ProductDetail productDetail = new ProductDetail();
				
				productDetail.setProductDetailId(rs.getInt("productDetailId"));
				productDetail.setProductId(rs.getInt("productId"));
				productDetail.setImage(rs.getString("image"));
				productDetail.setImage2(rs.getString("image2"));
				productDetail.setImage3(rs.getString("image3"));
				productDetail.setColor(rs.getString("color"));
				//get list product detail sq
				ProductDetailSQBO productDetailSQBO = new ProductDetailSQBO();
				ArrayList<ProductDetailSQ> listProductDetailSQ= productDetailSQBO.getListProductDetailSQ(rs.getInt("productDetailId"));
				productDetail.setListProductDetailSQ(listProductDetailSQ);
				list.add(productDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertProductDetail(ProductDetail productDetail){
		String sSql = String.format("INSERT INTO ProductDetail "
				+ "(ProductId ,Image ,Image2 ,Image3 ,Color)"
				+ " VALUES ('%s', '%s', '%s', '%s', '%s' ) ", 
				productDetail.getProductId(),
				productDetail.getImage(),
				productDetail.getImage2(),
				productDetail.getImage3(),
				productDetail.getColor() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	//	Sửa
	public void updateProductDetail(ProductDetail productDetail){
		String sSql = String.format(" UPDATE ProductDetail "
				+"   SET ProductId = '%s' "
				+"      ,Image = '%s' "
				+"      ,Image2 = '%s' "
				+"      ,Image3 = '%s' "
				+"      ,Color = '%s' "
				+" WHERE ProductDetailId  = '%s' " ,
				productDetail.getProductId(),
				productDetail.getImage(),
				productDetail.getImage2(),
				productDetail.getImage3(),
				productDetail.getColor(),
				productDetail.getProductDetailId() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteProductDetail(int productDetailId){
		String sSql = String.format("DELETE FROM ProductDetail WHERE ProductDetailId = '%s' ",productDetailId );
		
		db.updateTable(sSql);
		db.close();
	}
	//chi tiet san pham
	public ProductDetail getProductDetail(int productId) {
		String sSql = "SELECT * FROM ProductDetail WHERE ProductId = "+productId;
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
				
		ProductDetail productDetail = null;
		try {
			while(rs.next()){
				productDetail = new ProductDetail();
				
				productDetail.setProductDetailId(rs.getInt("productDetailId"));
				productDetail.setProductId(rs.getInt("productId"));
				productDetail.setImage(rs.getString("image"));
				productDetail.setImage2(rs.getString("image2"));
				productDetail.setImage3(rs.getString("image3"));
				productDetail.setColor(rs.getString("color"));
				//get list product detail sq
				ProductDetailSQBO productDetailSQBO = new ProductDetailSQBO();
				ArrayList<ProductDetailSQ> listProductDetailSQ= productDetailSQBO.getListProductDetailSQ(rs.getInt("productDetailId"));
				productDetail.setListProductDetailSQ(listProductDetailSQ);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productDetail;
	}
	//list chi tiet san pham-phuoc
	public ArrayList<ProductDetail> getProductDetail() {
		String sSql = "SELECT * FROM ProductDetail inner join Product on Product.ProductId=ProductDetail.ProductId";
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		ArrayList<ProductDetail> listproductDetail=new ArrayList<ProductDetail>();		
		ProductDetail productDetail = null;
		try {
			while(rs.next()){
				productDetail = new ProductDetail();
				productDetail.setProductDetailId(rs.getInt("productDetailId"));
				productDetail.setProductId(rs.getInt("productId"));
				productDetail.setImage(rs.getString("image"));
				productDetail.setImage2(rs.getString("image2"));
				productDetail.setImage3(rs.getString("image3"));
				productDetail.setColor(rs.getString("color"));
				productDetail.setProductName(rs.getString("ProductName"));
				listproductDetail.add(productDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listproductDetail;
	}
}
