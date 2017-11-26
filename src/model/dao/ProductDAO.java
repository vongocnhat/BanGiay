package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.Product;
import model.bean.ProductDetailSQ;

public class ProductDAO {
	MyDatabase db = new MyDatabase();
	//o trang chu
	public ArrayList<Product> getListProduct() {
		String sSql = "SELECT * FROM Product p INNER JOIN Category c ON p.CategoryId = c.CategoryId";
		return listProduct(sSql);
	}
	// 
	public ArrayList<Product> getListProductTop4() {
		String sSql = "SELECT * FROM Product p INNER JOIN Category c ON p.CategoryId = c.CategoryId LIMIT 4";
		return listProduct(sSql);
	}
	
	//thêm
	public void insertProduct(Product product){
		String sSql = String.format("INSERT INTO Product "
				+ "(CategoryId ,ProductName ,Description ,Price)"
				+ " VALUES (%s, '%s', '%s', %s ) ", 
				product.getCategoryId(),
				product.getProductName(),
				product.getDescription(),
				product.getPrice() );
		db.updateTable(sSql);
	}
	//	Sửa
	public void updateProduct(Product product){
		String sSql = String.format(" UPDATE Product "
				+"   SET CategoryId = '%s' "
				+"      ,ProductName = '%s' "
				+"      ,Description = '%s' "
				+"      ,Price = '%s' "
				+" WHERE ProductId  = '%s' " ,
				product.getCategoryId(),
				product.getProductName(),
				product.getDescription(),
				product.getPrice(),
				product.getProductId() );
		db.updateTable(sSql);
	}
	//tang view
	public void increaseNumberViewed(int productId){
		String sSql = String.format("UPDATE Product "
				+"   SET NumberViewed = NumberViewed + 1 "
				+" WHERE ProductId  = '%s' " ,
				productId );
		db.updateTable(sSql);
	}
	// Xóa
	public void deleteProduct(int productId){
		String sSql = String.format("DELETE FROM Product WHERE ProductId = '%s' ",productId );
		
		db.updateTable(sSql);
	}
	//chay o chi tiet san pham
	public Product getProduct(int productId) {
		String sql = "SELECT * FROM Product WHERE ProductId = '"+productId+"'";
		ResultSet rs = db.selectTable(sql);
		Product product = null;
		try {
			while(rs.next()){
				product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setProductName(rs.getString("productName"));
				product.setNumberViewed(rs.getLong("numberViewed"));
				product.setNumberSeller(rs.getLong("numberSeller"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getLong("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	// lấy danh sách sản phẩm theo category id thêm vào chay o tran chu
	public ArrayList<Product> getListProductByCategoryId(int categoryId) {
		String sSql = String.format("SELECT * FROM Product "
				+ "INNER JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId " + "WHERE Category.CategoryId='%s'",
				categoryId);
		return listProduct(sSql);
	}
	//phuoc
	//xap sep danh sach san pham theo gia
	public ArrayList<ProductDetailSQ> getListOrderProductPrice(String order) {
		String sSql = String.format("SELECT * FROM Product "
				+ "INNER JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId Order by Price %s",order);
		
		ResultSet rs = db.selectTable(sSql);

		ArrayList<ProductDetailSQ> listProduct = new ArrayList<ProductDetailSQ>();
		ProductDetailSQ product;
		try {
			while (rs.next()) {
				product = new ProductDetailSQ();
				product.setProductId(rs.getInt("ProductId"));
				product.setCategoryId(rs.getInt("CategoryId"));
				product.setProductName(rs.getString("ProductName"));
				product.setNumberViewed(rs.getInt("NumberViewed"));
				product.setNumberSeller(rs.getInt("NumberSeller"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getLong("Price"));
				product.setCategoryName(rs.getString("CategoryName"));
				product.setProductDetailId(rs.getInt("ProductDetailId"));
				product.setImage(rs.getString("Image"));
				product.setImage2(rs.getString("Image2"));
				product.setImage3(rs.getString("Image3"));
				product.setColor(rs.getString("Color"));

				listProduct.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}
	//xap sep danh sach san pham theo ten
	public ArrayList<ProductDetailSQ> getListOrderProductName(String order) {
		String sSql = String.format("SELECT * FROM Product "
				+ "INNER JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId Order by ProductName %s",order);
		
		ResultSet rs = db.selectTable(sSql);

		ArrayList<ProductDetailSQ> listProduct = new ArrayList<ProductDetailSQ>();
		ProductDetailSQ product;
		try {
			while (rs.next()) {
				product = new ProductDetailSQ();
				product.setProductId(rs.getInt("ProductId"));
				product.setCategoryId(rs.getInt("CategoryId"));
				product.setProductName(rs.getString("ProductName"));
				product.setNumberViewed(rs.getInt("NumberViewed"));
				product.setNumberSeller(rs.getInt("NumberSeller"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getLong("Price"));
				product.setCategoryName(rs.getString("CategoryName"));
				product.setProductDetailId(rs.getInt("ProductDetailId"));
				product.setImage(rs.getString("Image"));
				product.setImage2(rs.getString("Image2"));
				product.setImage3(rs.getString("Image3"));
				product.setColor(rs.getString("Color"));

				listProduct.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}
	//phuoc
	// tìm kiếm sản phẩm theo ,...
	// dungnv 14-8
	public ArrayList<Product> getListProductNumberViewed() {
		String sSql = "SELECT * FROM Product p INNER JOIN Category c ON p.CategoryId = c.CategoryId ORDER BY numberViewed DESC LIMIT 4";
		return listProduct(sSql);
	}
	// dungnv 14-8
	public ArrayList<Product> getListProductNumberSeller() {
		String sSql = "SELECT * FROM Product p INNER JOIN Category c ON p.CategoryId = c.CategoryId ORDER BY numberSeller DESC LIMIT 4";
		return listProduct(sSql);
	}
	
	public ArrayList<Product> getListSearchProduct(String productName ){
		String sSql = "SELECT * FROM Product WHERE ProductName LIKE '%"+productName+"%'";
		return listProduct(sSql);
	}
	public ArrayList<Product> getListSearchProductYeuThich(String userName) {
		String sSql = "SELECT * FROM Product WHERE Product.ProductId in "
				+ "( SELECT ProductId FROM Favorites WHERE UserName = '"+userName+"' GROUP BY ProductId )";
		return listProduct(sSql);
	}
	public ArrayList<Product> sortListProduct(String column, String sortType) {
		String sSql = "SELECT * FROM Product ORDER BY "+column+" "+sortType;
		return listProduct(sSql);
	}
	public ArrayList<Product> listProduct(String sSql) {
		ResultSet rs = db.selectTable(sSql);
		ResultSet rs2;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			while(rs.next()){
				Product product = new Product();
				
				product.setProductId(rs.getInt("productId"));
				product.setCategoryId(rs.getInt("CategoryId"));
				product.setProductName(rs.getString("productName"));
				product.setNumberViewed(rs.getLong("numberViewed"));
				product.setNumberSeller(rs.getLong("numberSeller"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getLong("price"));
				String sql = "SELECT * FROM ProductDetail WHERE ProductId ='"+rs.getInt("productId")+"' LIMIT 1";
				rs2 = db.selectTable(sql);
				if(rs2.next())
					product.setImage(rs2.getString("Image"));
				else
					product.setImage("Sản Phẩm Này Chưa Có");
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
