package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Rate;

public class RateDAO {
	MyDatabase db = new MyDatabase();
	public ArrayList<Rate> getListRate() {
		String sSql = "SELECT * FROM Rate";
		
		ResultSet rs = db.selectTable(sSql);
				
		ArrayList<Rate> list = new ArrayList<Rate>();
		try {
			while(rs.next()){
				Rate rate = new Rate();
				
				rate.setProductId(rs.getInt("productId"));
				rate.setUserName(rs.getString("userName"));
				rate.setStar(rs.getInt("star"));
				
				list.add(rate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertRate(Rate rate){
		String sSql = String.format("INSERT INTO Rate "
				+ "(ProductId ,UserName ,Star)"
				+ " VALUES ('%s', '%s', '%s') ", 
				rate.getProductId(),
				rate.getUserName(),
				rate.getStar() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteRate(Rate rate){
		String sSql = String.format("DELETE FROM Rate WHERE ProductId = '%s' AND UserName = '%s' ",rate.getProductId(),rate.getUserName() );
		
		db.updateTable(sSql);
		db.close();
	}
}
