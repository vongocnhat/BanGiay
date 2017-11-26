package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.ProductDetailSQ;

public class ProductDetailSQDAO {
	MyDatabase db = new MyDatabase();
	//bị dư
//	public ArrayList<ProductDetailSQ> getListProduct() {
//		String sSql = "SELECT * FROM Product "
//				+ "INNER JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
//				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId";
//		
//		ResultSet rs = db.selectTable(sSql);
//
//		ArrayList<ProductDetailSQ> listProduct = new ArrayList<ProductDetailSQ>();
//		ProductDetailSQ product;
//		try {
//			while (rs.next()) {
//				product = new ProductDetailSQ();
//				product.setProductId(rs.getInt("ProductId"));
//				product.setCategoryId(rs.getInt("CategoryId"));
//				product.setProductName(rs.getString("ProductName"));
//				product.setNumberViewed(rs.getLong("NumberViewed"));
//				product.setNumberSeller(rs.getLong("NumberSeller"));
//				product.setDescription(rs.getString("Description"));
//				product.setPrice(rs.getLong("Price"));
//				product.setCategoryName(rs.getString("CategoryName"));
//				product.setProductDetailId(rs.getInt("ProductDetailId"));
//				product.setImage(rs.getString("Image"));
//				product.setImage2(rs.getString("Image2"));
//				product.setImage3(rs.getString("Image3"));
//				product.setColor(rs.getString("Color"));
//
//				listProduct.add(product);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listProduct;
//	}

	// lấy danh sách sản phẩm theo category id bị dư
	public ArrayList<ProductDetailSQ> getListProductByCategoryId(int categoryId) {
		String sSql = String.format("SELECT * FROM Product "
				+ "INNER JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId " + "WHERE Category.CategoryId='%s'",
				categoryId);
		
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

	// tìm kiếm sản phẩm theo ,...
	public ArrayList<ProductDetailSQ> getListSearchProduct(String stringSearch) {
		String sSearch = "%"+stringSearch+"%";
		String sSql = String.format("SELECT * FROM Product "
				+ "FULL JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId "
				+ "WHERE Product.ProductName like '%s'",sSearch);
		
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
	/// dungnv
	public ArrayList<ProductDetailSQ> getListSearchProductYeuThich(String userName) {
		String sSql = String.format("SELECT * FROM Product "
				+ "FULL JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
				+ "INNER JOIN Category ON Product.CategoryId=Category.CategoryId "
				+ "WHERE Product.ProductId in "
				+ "( SELECT ProductId FROM Favorites WHERE UserName = '%s' GROUP BY ProductId )" ,
				userName );
		
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
	// lấy chi tiết sản phẩm
	public ProductDetailSQ detailProduct(int idProduct) {
		ProductDetailSQ product = new ProductDetailSQ();
		String sSql = String
				.format("SELECT * FROM Product " + "INNER JOIN Category ON Category.CategoryId=Product.CategoryId "
						+ "FULL OUTER JOIN Promotion ON Product.ProductId=Promotion.ProductId "
						+ "FULL OUTER JOIN Accessories ON Promotion.AccessoriesId=Accessories.AccessoriesId "
						+ "FULL OUTER JOIN ProductDetail ON Product.ProductId=ProductDetail.ProductId "
						+ "FULL OUTER JOIN ProductDetailSQ ON ProductDetail.ProductDetailId=ProductDetailSQ.ProductDetailId "
						+ "WHERE Product.ProductId='%s'", idProduct);
		
		ResultSet rs = db.selectTable(sSql);
		try {
			while (rs.next()) {
				product.setProductId(rs.getInt("ProductId"));
				product.setCategoryId(rs.getInt("CategoryId"));
				product.setProductName(rs.getString("ProductName"));
				product.setNumberViewed(rs.getInt("NumberViewed"));
				product.setNumberSeller(rs.getInt("NumberSeller"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getLong("Price"));
				product.setCategoryName(rs.getString("CategoryName"));
				product.setCategoryParent(rs.getString("CategoryParent"));
				product.setProductDetailId(rs.getInt("ProductDetailId"));
				product.setImage(rs.getString("Image"));
				product.setImage2(rs.getString("Image2"));
				product.setImage3(rs.getString("Image3"));
				product.setColor(rs.getString("Color"));
				product.setSize(rs.getFloat("Size"));
				product.setQuantity(rs.getInt("Quantity"));
				//tạm thời xóa
//				product.setPromotionId(rs.getInt("PromotionId"));
//				product.setAccessoriesId(rs.getInt("AccessoriesId"));
//				product.setDiscount(rs.getInt("Discount"));
//				product.setMgfDate(rs.getDate("MFgDate"));
//				product.setExpDate(rs.getDate("ExpDate"));
//				product.setAccessoriesName(rs.getString("AccessoriesName"));
//				product.setPriceAcc(rs.getDouble("PriceAcc"));
//				product.setSizeAcc(rs.getInt("SizeAcc"));
//				product.setQuantityAcc(rs.getInt("QuantityAcc"));
//				product.setImageAcc(rs.getString("ImageAcc"));
//				product.setColorAcc(rs.getString("ColorAcc"));
//				product.setDescriptionAcc(rs.getString("DescriptionAcc"));
				product.setProductDetailSQId(rs.getInt("ProductDetailSQId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	//thêm vào
	public ArrayList<ProductDetailSQ> getListProductDetailSQ(int productDetailId) {
		String sSql = "SELECT * FROM ProductDetailSQ WHERE ProductDetailId = '"+productDetailId+"'";

		
		ResultSet rs = db.selectTable(sSql);

		ArrayList<ProductDetailSQ> listProductDetailSQ = new ArrayList<ProductDetailSQ>();
		ProductDetailSQ productDetailSQ;
		try {
			while (rs.next()) {
				productDetailSQ = new ProductDetailSQ();
				productDetailSQ.setProductDetailSQId(rs.getInt("ProductDetailSQId"));
				productDetailSQ.setProductDetailId(rs.getInt("ProductDetailId"));
				productDetailSQ.setSize(rs.getFloat("Size"));
				productDetailSQ.setQuantity(rs.getInt("Quantity"));
				listProductDetailSQ.add(productDetailSQ);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProductDetailSQ;
	}
	//giam so luong san pham
	public void reducedQuantity(int productDetailSQId, int quantity) {
		String sql = "UPDATE ProductDetailSQ SET Quantity = Quantity - "+quantity+" WHERE ProductDetailSQId = "+productDetailSQId;
		db.updateTable(sql);
	}
}
