package model.bo;

import java.util.ArrayList;

import model.bean.Order;
import model.dao.OrderDAO;


public class OrderBO {
	OrderDAO orderDAO = new OrderDAO();
	
	public ArrayList<Order> getlistOrder() {
		return orderDAO.getListOrder();
	}
	
	public void insertOrder(Order order) {
		orderDAO.insertOrder(order);
	}
	
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}
	
	public void deleteOrder(int orderId) {
		orderDAO.deleteOrder(orderId);
	}
	public int getOrderId() {
		return orderDAO.getOrderId();
	}
	public Order getOrder(int orderId){
		return orderDAO.getOrder(orderId);
	}
}
