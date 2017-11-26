package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Promotion;
import model.bo.AccessoriesBO;

public class PromotionDAO {
	MyDatabase db = new MyDatabase();
	public ArrayList<Promotion> getListPromotion(int productId) {
		String sSql = "SELECT * FROM Promotion WHERE ProductId = '"+productId+"'";
		
		ResultSet rs = db.selectTable(sSql);
				
		ArrayList<Promotion> list = new ArrayList<Promotion>();
		try {
			while(rs.next()){
				Promotion promotion = new Promotion();
				
				promotion.setPromotionId(rs.getInt("promotionId"));
				promotion.setProductId(rs.getInt("productId"));
				promotion.setAccessoriesId(rs.getInt("accessoriesId"));
				promotion.setDiscount(rs.getInt("discount"));
				promotion.setMfgDate(rs.getDate("mfgDate"));
				promotion.setExpDate(rs.getDate("expDate"));
				AccessoriesBO accessoriesBO = new AccessoriesBO();
				promotion.setListAccessories(accessoriesBO.getListAccessories(rs.getInt("accessoriesId")));
				list.add(promotion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertPromotion(Promotion promotion){
		String sSql = String.format("INSERT INTO Promotion "
				+ "(ProductId ,AccessoriesId ,Discount ,MfgDate ,ExpDate)"
				+ " VALUES ('%s', '%s', '%s', '%s', '%s' ) ", 
				promotion.getProductId(),
				promotion.getAccessoriesId(),
				promotion.getDiscount(),
				promotion.getMfgDate(),
				promotion.getExpDate() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	//	Sửa
	public void updatePromotion(Promotion promotion){
		String sSql = String.format(" UPDATE BanGiay.Promotion "
				+"   SET ProductId = '%s' "
				+"      ,AccessoriesId = '%s' "
				+"      ,Discount = '%s' "
				+"      ,MfgDate = '%s' "
				+"      ,ExpDate = '%s' "
				+" WHERE PromotionId = '%s' " ,
				promotion.getProductId(),
				promotion.getAccessoriesId(),
				promotion.getDiscount(),
				promotion.getMfgDate(),
				promotion.getExpDate(),
				promotion.getPromotionId() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deletePromotion(String promotionId){
		String sSql = String.format("DELETE FROM Promotion WHERE PromotionId = '%s' ",promotionId );
		
		db.updateTable(sSql);
		db.close();
	}
	public ArrayList<Promotion> getListPromotion() {
		String sSql = "SELECT * FROM Promotion";
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
				
		ArrayList<Promotion> list = new ArrayList<Promotion>();
		try {
			while(rs.next()){
				Promotion promotion = new Promotion();
				
				promotion.setPromotionId(rs.getInt("promotionId"));
				promotion.setProductId(rs.getInt("productId"));
				promotion.setAccessoriesId(rs.getInt("accessoriesId"));
				promotion.setDiscount(rs.getInt("discount"));
				promotion.setMfgDate(rs.getDate("mfgDate"));
				promotion.setExpDate(rs.getDate("expDate"));
				AccessoriesBO accessoriesBO = new AccessoriesBO();
				promotion.setListAccessories(accessoriesBO.getListAccessories(rs.getInt("accessoriesId")));
				list.add(promotion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
