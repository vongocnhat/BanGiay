package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Favorites;

public class FavoritesDAO {
	// Lấy tất cả
	public ArrayList<Favorites> getListFavorites() {
		String sSql = "SELECT * FROM Favorites";
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Favorites> list = new ArrayList<Favorites>();
		try {
			while(rs.next()){
				Favorites favorites = new Favorites();
				
				favorites.setUserName(rs.getString("userName"));
				favorites.setProductId(rs.getInt("productId"));
				favorites.setCreatedday(rs.getDate("createdday"));
				
				list.add(favorites);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// Lấy list của từng khách hàng///=====================
	public ArrayList<Favorites> getListFavorites(String userName) {
		String sSql = String.format("SELECT * FROM Favorites WHERE UserName = '%s' ", userName);
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Favorites> list = new ArrayList<Favorites>();
		try {
			while(rs.next()){
				Favorites favorites = new Favorites();
				
				favorites.setUserName(rs.getString("userName"));
				favorites.setProductId(rs.getInt("productId"));
				favorites.setCreatedday(rs.getDate("createdday"));
				
				list.add(favorites);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// Lấy list theo mặt hàng====================
	public ArrayList<Favorites> getListFavorites(int productId, String userName) {
		String sSql = String.format("SELECT * FROM Favorites WHERE ProductId = '%s' AND UserName = '%s' ", productId, userName);
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Favorites> list = new ArrayList<Favorites>();
		try {
			while(rs.next()){
				Favorites favorites = new Favorites();
				
				favorites.setUserName(rs.getString("userName"));
				favorites.setProductId(rs.getInt("productId"));
				favorites.setCreatedday(rs.getDate("createdday"));
				
				list.add(favorites);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertFavorites(Favorites favorites){
		String sSql = String.format("INSERT INTO Favorites "
				+ "(UserName ,ProductId) "
				+ " VALUES ('%s', '%s') ",
				favorites.getUserName(),
				favorites.getProductId() );
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteFavorites(Favorites favorites){
		String sSql = String.format("DELETE FROM Favorites WHERE UserName = '%s' AND ProductId = '%s'",
					favorites.getUserName(),
					favorites.getProductId() );
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
}
