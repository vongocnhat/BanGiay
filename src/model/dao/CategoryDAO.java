package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;

public class CategoryDAO {
	MyDatabase db = new MyDatabase();
	//Lấy toàn bộ
	public ArrayList<Category> getListCategory() {
		String sSql = "SELECT * FROM Category";
		
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Category> list = new ArrayList<Category>();
		try {
			while(rs.next()){
				Category category = new Category();
				category.setCategoryId(rs.getInt("CategoryId"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setCategoryParent(rs.getString("CategoryParent"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void insertCategory(Category category){
		String sSql = String.format("INSERT INTO Category "
				+ " (CategoryParent ,CategoryName)"
				+ " VALUES ('%s', '%s' ) ",
				category.getCategoryParent(),
				category.getCategoryName() );
		
		db.updateTable(sSql);
		db.close();
	}
	//Sửa
	public void updateCategory(Category category){
		String sSql = String.format("UPDATE Category"
				+ " SET CategoryParent = '%s', "
				+ "     CategoryName = '%s' "
				+ " WHERE CategoryId = '%s' ",
				category.getCategoryParent(),
				category.getCategoryName(),
				category.getCategoryId() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	//Xóa
	public void deleteCategory(int CategoryId){
		String sSql = String.format("DELETE FROM Category WHERE CategoryId = '%s' ",CategoryId );
		
		db.updateTable(sSql);
		db.close();
	}
	//get category
	public Category getCategory(int categoryId) {
		String sSql = "SELECT * FROM Category WHERE CategoryId='"+categoryId+"'";
		
		ResultSet rs = db.selectTable(sSql);
		Category category = null;
		try {
			while(rs.next()){
				category = new Category();
				category.setCategoryId(rs.getInt("CategoryId"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setCategoryParent(rs.getString("CategoryParent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
}
