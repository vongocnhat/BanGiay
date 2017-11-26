package model.bo;

import java.util.ArrayList;

import model.bean.OrderDetail;
import model.dao.OrderDetailDAO;


public class OrderDetailBO {
	OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	
	public ArrayList<OrderDetail> getlistOrderDetail() {
		return orderDetailDAO.getListOrderDetail();
	}
	
	public void insertOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.insertOrderDetail(orderDetail);
	}
	
	public void updateOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.updateOrderDetail(orderDetail);
	}
	
	public void deleteOrderDetail(String orderDetailId) {
		orderDetailDAO.deleteOrderDetail(orderDetailId);
	}
}
