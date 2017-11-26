package model.bean;

public class OrderDetail {
	private int orderDetailId;
	private int orderId;
	private int productDetailSQId;
	private long price;
	private int quantity;
	
	public OrderDetail() {
		super();
	}
	public OrderDetail(int orderId, int productDetailSQId,
			long price, int quantity) {
		super();
		this.orderId = orderId;
		this.productDetailSQId = productDetailSQId;
		this.price = price;
		this.quantity = quantity;
	}
	public int getOrderDetaiId() {
		return orderDetailId;
	}
	public void setOrderDetaiId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int oderId) {
		this.orderId = oderId;
	}
	public int getProductDetailSQId() {
		return productDetailSQId;
	}
	public void setProductDetailSQId(int productDetailSQId) {
		this.productDetailSQId = productDetailSQId;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
