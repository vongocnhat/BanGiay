package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import model.bean.FeedBack;


public class FeedBackDAO {
	MyDatabase db = new MyDatabase();
	//Láº¥y toĂ n bá»™
	public ArrayList<FeedBack> getListFeedBack() {
		String sSql = "SELECT * FROM FeedBack";
		
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<FeedBack> list = new ArrayList<FeedBack>();
		try {
			while(rs.next()){
				FeedBack feedBack = new FeedBack();
				
				feedBack.setFeedBackId(rs.getInt("feedBackId"));
				feedBack.setName(rs.getString("Name"));
				feedBack.setEmail(rs.getString("email"));
				feedBack.setContentFeedBack(rs.getString("contentFeedBack"));
				feedBack.setCreatedday(rs.getString("createdday"));
				
				list.add(feedBack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertFeedBack(FeedBack feedBack){
		String sSql = String.format("INSERT INTO FeedBack "
				+ " VALUES ('%s', '%s', '%s', getDate()) ", 
				feedBack.getContentFeedBack(),
				feedBack.getName(), 
				feedBack.getEmail()
				 );
		
		
		db.updateTable(sSql);
		db.close();
	}
	//	Sửa
	public void updateFeedBack(FeedBack feedBack){
		String sSql = String.format("UPDATE FeedBack"
				+ " SET Name = '%s' ,Email = '%s' ,ContentFeedBack = '%s'"
				+ " ,Createdday = '%s' WHERE FeedBackId = '%s' ", 
				feedBack.getName(),
				feedBack.getEmail(), 
				feedBack.getContentFeedBack(), 
				feedBack.getCreatedday(), 
				feedBack.getFeedBackId() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteFeedBack(String feedBackId){
		String sSql = String.format("DELETE FROM FeedBack WHERE FeedBackId = '%s' ",feedBackId );
		
		db.updateTable(sSql);
		db.close();
	}
	//test
	public static void main(String args) {
		NumberFormat df=new DecimalFormat("###,###");
		String formatString=df.format(15000);
//		FeedBack feee = new FeedBack();
//		feee.setName("rwerew");
//		feee.setEmail("werew");
//		feee.setContentFeedBack("rewrwr");
//		new FeedBackDAO().insertFeedBack(feee);
	}
}
