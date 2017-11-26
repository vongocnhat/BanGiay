package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Accessories;

public class AccessoriesDAO {
	MyDatabase db = new MyDatabase();
	//Lấy toàn bộ
	public ArrayList<Accessories> getListAccessories() {
		String sSql = "SELECT * FROM Accessories";
		
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Accessories> list = new ArrayList<Accessories>();
		try {
			while(rs.next()){
				Accessories accessories = new Accessories();
				accessories.setAccessoriesId(rs.getInt("AccessoriesId"));
				accessories.setAccessoriesName(rs.getString("AccessoriesName"));
				accessories.setPrice(rs.getLong("Price"));
				accessories.setSize(rs.getInt("Size"));
				accessories.setQuantity(rs.getInt("Quantity"));
				accessories.setImage(rs.getString("Image"));
				accessories.setColor(rs.getString("Color"));
				accessories.setDescription(rs.getString("Description"));
				
				list.add(accessories);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Lấy danh sách tìm theo tên
	public ArrayList<Accessories> getListAccessories(int accessoriesId) {
//		String sSql = "SELECT * FROM Accessories Where AccessoriesName like '%"+ name +"%' ";
		String sSql = "SELECT * FROM Accessories Where AccessoriesId='"+ accessoriesId +"'";
		
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Accessories> list = new ArrayList<Accessories>();
		try {
			while(rs.next()){
				Accessories accessories = new Accessories();
				accessories.setAccessoriesId(rs.getInt("AccessoriesId"));
				accessories.setAccessoriesName(rs.getString("AccessoriesName"));
				accessories.setPrice(rs.getLong("Price"));
				accessories.setSize(rs.getInt("Size"));
				accessories.setQuantity(rs.getInt("Quantity"));
				accessories.setImage(rs.getString("Image"));
				accessories.setColor(rs.getString("Color"));
				accessories.setDescription(rs.getString("Description"));
				
				list.add(accessories);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Thêm
	public void insertAccessories(Accessories accessories){
		String sSql = String.format("INSERT INTO Accessories "
				+ " (AccessoriesName ,Price ,Size ,Quantity ,Image ,Color ,Description)"
				+ " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s' ) ", 
				accessories.getAccessoriesName(), 
				accessories.getPrice(), 
				accessories.getSize(), 
				accessories.getQuantity(), 
				accessories.getImage(), 
				accessories.getColor(), 
				accessories.getDescription() );
		
		db.updateTable(sSql);
		db.close();
	}
	//Sửa
	public void updateAccessories(Accessories accessories){
		String sSql = String.format("UPDATE Accessories"
				+ " SET AccessoriesName = '%s' "
				+ " ,Price = '%s' "
				+ " ,Size = '%s' "
				+ " ,Quantity = '%s' "
				+ " ,Image = '%s' "
				+ " , Color = '%s' "
				+ " ,Description = '%s' "
				+ " WHERE AccessoriesId = '%s' ", 
				accessories.getAccessoriesName(), 
				accessories.getPrice(),
				accessories.getSize(), 
				accessories.getQuantity(), 
				accessories.getImage(), 
				accessories.getColor(), 
				accessories.getDescription(), 
				accessories.getAccessoriesId() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	//Xóa
	public void deleteAccessories(String accessoriesId){
		String sSql = String.format("DELETE FROM Accessories WHERE AccessoriesId = '%s' ",accessoriesId );
		
		db.updateTable(sSql);
		db.close();
	}
	//test
//	public static void main(String[ args) {
//		Accessories accessories = new Accessories(120, "Nguyen Kieu Hưng aannanaananana", 12000, 42, 5, "hehe.jpg", "đen", "Cao to den hooi hooi hôi");
//		ArrayList<Accessories> list = new AccessoriesDAO().getListAccessories("an");
//		
//		new AccessoriesDAO().updateAccessories(accessories);
//		
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i).toString());
//		new AccessoriesDAO().insertAccessories(accessories);
//	}
}
