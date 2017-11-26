package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.OrderDetail;


public class OrderDetailDAO {
	MyDatabase db = new MyDatabase();
	public ArrayList<OrderDetail> getListOrderDetail() {
		String sSql = "SELECT * FROM OrderDetai";
		
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			while(rs.next()){
				OrderDetail orderDetail = new OrderDetail();
				
				orderDetail.setOrderDetaiId(rs.getInt("orderDetaiId"));
				orderDetail.setOrderId(rs.getInt("oderId"));
				orderDetail.setProductDetailSQId(rs.getInt("ProductDetailSQId"));
				orderDetail.setPrice(rs.getLong("price"));
				orderDetail.setQuantity(rs.getInt("quantity"));
				
				list.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertOrderDetail(OrderDetail orderDetail){
		String sSql = String.format("INSERT INTO OrderDetail "
				+ "(OrderId ,ProductDetailSQId ,Price ,Quantity)"
				+ " VALUES ('%s', '%s', '%s', '%s') ", 
				 orderDetail.getOrderId(),
				 orderDetail.getProductDetailSQId(),
				 orderDetail.getPrice(),
				 orderDetail.getQuantity() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	//	Sửa
	public void updateOrderDetail(OrderDetail orderDetail){
		String sSql = String.format(" UPDATE OrderDetail "
				+"   SET OrderId = '%s' "
				+"      ,ProductDetailSQId = '%s' "
				+"      ,Price = '%s' "
				+"      ,Quantity = '%s' "
				+" WHERE  ProductDetailId = '%s' " ,
				 orderDetail.getOrderId(),
				 orderDetail.getProductDetailSQId(),
				 orderDetail.getPrice(),
				 orderDetail.getQuantity(),
				 orderDetail.getOrderDetaiId() );
		
		
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteOrderDetail(String orderDetailId){
		String sSql = String.format("DELETE FROM OrderDetail WHERE OrderDetailId = '%s' ",orderDetailId );
		
		db.updateTable(sSql);
		db.close();
	}
}
