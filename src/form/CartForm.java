package form;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Cart;
import model.bean.Order;
import model.bean.OrderDetail;
import model.bean.Person;

public class CartForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// chi tiet san pham
	private String productName;
	private String image;
	private String color;
	private long price;
	private int productDetailId;
	private int productDetailSQId;
	private float size;
	private int quantity;
	//cart order detail
	private ArrayList<Cart> listCart;
	private String type;
	private int STT;
	private String submit;
	//thong tin mua hang
	private String method;
	private int orderId;
	//list order
	private Order order;
	private ArrayList<OrderDetail> listOrderDetail;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getProductDetailSQId() {
		return productDetailSQId;
	}

	public void setProductDetailSQId(int productDetailSQId) {
		this.productDetailSQId = productDetailSQId;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void constructListCart() {
		listCart = new ArrayList<Cart>();
	}
	
	public void addCart(Cart cart) {
		listCart.add(cart);
	}
	
	public void updateQuantityCart(int quantity, int index) {
		listCart.get(index).setQuantity(quantity);
	}
	
	public void deleteCart(int index) {
		listCart.remove(index);
	}
	
	public ArrayList<Cart> getListCart() {
		return listCart;
	}

	public void setListCart(ArrayList<Cart> listCart) {
		this.listCart = listCart;
	}

	public int getSTT() {
		return STT;
	}

	public void setSTT(int sTT) {
		STT = sTT;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getTotalQuantity() {
		int totalQuantity = 0;
		for (Cart cart : listCart) {
			totalQuantity += cart.getQuantity();
		}
		return totalQuantity;
	}

//	public void setTotalQuantity(int totalQuantity) {
//		this.totalQuantity = totalQuantity;
//	}

	public long getTotalPrice() {
		long totalPrice = 0;
		for (Cart cart : listCart) {
			totalPrice += cart.getTotalPrice();
		}
		return totalPrice;
	}

//	public void setTotalPrice(String totalPrice) {
//		this.totalPrice = totalPrice;
//	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public ArrayList<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(ArrayList<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
