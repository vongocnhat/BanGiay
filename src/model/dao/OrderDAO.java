package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.Order;

public class OrderDAO {
	MyDatabase db = new MyDatabase();
	public ArrayList<Order> getListOrder() {
		String sSql = "SELECT * FROM `Order`";
		
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			while(rs.next()){
				Order order = new Order();
				
				order.setOrderId(rs.getInt("orderId"));
				order.setUserName(rs.getString("userName"));
				order.setFullName(rs.getString("fullName"));
				order.setEmail(rs.getString("email"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMethod(rs.getString("method"));
				order.setTotalQuantity(rs.getInt("totalQuantity"));
				order.setTotalPrice(rs.getLong("totalPrice"));
				order.setStatus(rs.getBoolean("status"));
				order.setConfirm(rs.getBoolean("confirm"));
				order.setCreatedday(rs.getString("createdday"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertOrder(Order order){
		String sSql = String.format("INSERT INTO `Order` (`UserName`, `FullName`, `Email`, `Phone`, `Address`, `Gender`, `Birthday`, `Method`, `TotalQuantity`, `TotalPrice`, `Status`, `Confirm`,`Createdday`)"
				+ " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s','%s', %s, %s, %s, %s,'%s') ", 
				order.getUserName(),
				order.getFullName(),
				order.getEmail(),
				order.getPhone(),
				order.getAddress(),
				order.getGender(),
				order.getBirthday(),
				order.getMethod(),
				order.getTotalQuantity(),
				order.getTotalPrice(),
				order.getStatus(),
				order.getConfirm(),
				StringProcess.getDateNow());
		db.updateTable(sSql);
		db.close();
	}
	//	Sửa
	public void updateOrder(Order order){
		String sSql = String.format("UPDATE `Order` "
				+"   SET UserName = '%s' "
				+"      ,FullName = '%s' "
				+"      ,Email = '%s' "
				+"      ,Phone = '%s' "
				+"      ,Address = '%s' "
				+"      ,Method = '%s' "
				+"      ,TotalQuantity = %s "
				+"      ,TotalPrice = %s "
				+"      ,Status = %s "
				+"      ,Confirm = %s "
				+"      ,Createdday = '%s' "
				+" WHERE OrderId = '%s' " ,
				order.getUserName(),
				order.getFullName(),
				order.getEmail(),
				order.getPhone(),
				order.getAddress(),
				order.getMethod(),
				order.getTotalQuantity(),
				order.getTotalPrice(),
				order.getStatus(),
				order.getConfirm(),
				order.getCreatedday(),
				order.getOrderId() );
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteOrder(int OrderId){
		String sSql = String.format("DELETE FROM `ORDER` WHERE OrderId = '%s' ",OrderId );
		
		db.updateTable(sSql);
		db.close();
	}
	//get getOrderId
	public int getOrderId() {
		String sql = "SELECT MAX(OrderId) FROM `ORDER`";
		ResultSet rs = null;
		rs = db.selectTable(sql);
		try {
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// khong bao gio xay ra
		return 0;
	}
	public Order getOrder(int orderId) {
		String sSql = "SELECT * FROM `ORDER` WHERE OrderId="+orderId;
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		
		Order order = null;
		try {
			while(rs.next()){
				order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserName(rs.getString("userName"));
				order.setFullName(rs.getString("fullName"));
				order.setEmail(rs.getString("email"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				order.setMethod(rs.getString("method"));
				order.setTotalQuantity(rs.getInt("totalQuantity"));
				order.setTotalPrice(rs.getLong("totalPrice"));
				order.setStatus(rs.getBoolean("status"));
				order.setConfirm(rs.getBoolean("confirm"));
				order.setCreatedday(rs.getString("createdday"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
				
	}
}
