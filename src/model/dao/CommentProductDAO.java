package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.CommentProduct;


public class CommentProductDAO {
	//LÃ¡ÂºÂ¥y toÄ‚Â n bÃ¡Â»â„¢
	public ArrayList<CommentProduct> getListCommentProduct() {
		String sSql = "SELECT * FROM CommentProduct";
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<CommentProduct> list = new ArrayList<CommentProduct>();
		try {
			while(rs.next()){
				CommentProduct commentProduct = new CommentProduct();
				
				commentProduct.setCommentId(rs.getInt("commentId"));
				commentProduct.setCommentIdParent(rs.getInt("commentIdParent"));
				commentProduct.setLevelCmt(rs.getInt("levelCmt"));
				commentProduct.setProductId(rs.getInt("productId"));
				commentProduct.setUserName(rs.getString("userName"));
				commentProduct.setContentConmment(rs.getString("ContentComment"));
				commentProduct.setCreatedDay(rs.getTimestamp("createdDay"));
				
				list.add(commentProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/// get coment theo productID
	public ArrayList<CommentProduct> getListCommentProduct(int productId) {
		String sSql1 = String.format("SELECT * FROM CommentProduct WHERE ProductId = '%s' AND levelCmt = '%s' ", productId, 1);
		MyDatabase db1 = new MyDatabase();
		ResultSet rs1 = db1.selectTable(sSql1);
		
		ArrayList<CommentProduct> list = new ArrayList<CommentProduct>();
		try {
			while(rs1.next()){
				CommentProduct commentProduct1 = new CommentProduct();
				
				commentProduct1.setCommentId(rs1.getInt("commentId"));
				commentProduct1.setCommentIdParent(rs1.getInt("commentIdParent"));
				commentProduct1.setLevelCmt(rs1.getInt("levelCmt"));
				commentProduct1.setProductId(rs1.getInt("productId"));
				commentProduct1.setUserName(rs1.getString("userName"));
				commentProduct1.setContentConmment(rs1.getString("ContentComment"));
				commentProduct1.setCreatedDay(rs1.getTimestamp("createdDay"));
				
				
				list.add(commentProduct1);
				// Lop 2
				String sSql2 = String.format("SELECT * FROM CommentProduct WHERE ProductId = '%s' AND commentIdParent = '%s' AND levelCmt = '%s' ", productId, commentProduct1.getCommentId(), 2);
				MyDatabase db2 = new MyDatabase();
				ResultSet rs2 = db2.selectTable(sSql2);
				
				try {
					while(rs2.next()){
						CommentProduct commentProduct2 = new CommentProduct();
						
						commentProduct2.setCommentId(rs2.getInt("commentId"));
						commentProduct2.setCommentIdParent(rs2.getInt("commentIdParent"));
						commentProduct2.setLevelCmt(rs2.getInt("levelCmt"));
						commentProduct2.setProductId(rs2.getInt("productId"));
						commentProduct2.setUserName(rs2.getString("userName"));
						commentProduct2.setContentConmment(rs2.getString("ContentComment"));
						commentProduct2.setCreatedDay(rs2.getTimestamp("createdDay"));
						
						list.add(commentProduct2);
						
						//Lop 3
						String sSql3 = String.format("SELECT * FROM CommentProduct WHERE ProductId = '%s' AND commentIdParent = '%s' AND levelCmt = '%s' ", productId, commentProduct2.getCommentId(), 3);
						MyDatabase db3 = new MyDatabase();
						ResultSet rs3 = db3.selectTable(sSql3);
						
						try {
							while(rs3.next()){
								CommentProduct commentProduct3 = new CommentProduct();
								
								commentProduct3.setCommentId(rs3.getInt("commentId"));
								commentProduct3.setCommentIdParent(rs3.getInt("commentIdParent"));
								commentProduct3.setLevelCmt(rs3.getInt("levelCmt"));
								commentProduct3.setProductId(rs3.getInt("productId"));
								commentProduct3.setUserName(rs3.getString("userName"));
								commentProduct3.setContentConmment(rs3.getString("ContentComment"));
								commentProduct3.setCreatedDay(rs3.getTimestamp("createdDay"));
								
								list.add(commentProduct3);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thÃªm
	public void insertCommentProduct(CommentProduct commentProduct){
		String sSql = String.format("INSERT INTO CommentProduct "
				+ "(CommentIdParent ,LevelCmt ,ProductId ,UserName ,ContentComment, Createdday ) "
				+ " VALUES ('%s', '%s', '%s', '%s', '%s', '%s') ", 
				commentProduct.getCommentIdParent(), 
				commentProduct.getLevelCmt(), 
				commentProduct.getProductId(), 
				commentProduct.getUserName(), 
				commentProduct.getContentConmment(),
				StringProcess.getDateNow());
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
	//	Sá»­a
	public void updateCommentProduct(CommentProduct commentProduct){
		String sSql = String.format("UPDATE CommentProduct "
						+"    SET CommentIdParent = '%s' "
						+"       ,LevelCmt = '%s' "
						+"       ,ProductId = '%s' "
						+"       ,UserName = '%s' "
						+"       ,ContentComment = '%s' "
						+"       ,Createdday = '%s' "
						+"  WHERE CommentId = '%s' ", 
						commentProduct.getCommentIdParent(), 
						commentProduct.getLevelCmt(), 
						commentProduct.getProductId(),
						commentProduct.getUserName(),
						commentProduct.getContentConmment(),
						commentProduct.getCreatedDay() );
		
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
	//sua
//	Sá»­a
	public void updateCommentProduct(int commentProductId, String contentConmment){
		//contentConmment = contentConmment.replaceAll("'", "''");
		String sSql = "UPDATE CommentProduct SET ContentComment = ? WHERE CommentId = ?" ;
		
		MyDatabase db = new MyDatabase();
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sSql);
			pstmt.setString(1, contentConmment);
			pstmt.setInt(2, commentProductId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//db.updateTable(sSql);
		db.close();
	}
	// sua sua sua==================
	public void deleteCommentProduct(int CommentId){
		String sSql = String.format("DELETE FROM CommentProduct "
				+ "WHERE CommentIdParent in (SELECT CommentId FROM CommentProduct WHERE CommentIdParent= '%s' )"
				+ "OR CommentId = '%s' OR CommentIdParent='%s' ",CommentId ,CommentId, CommentId );
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
	//test
}
