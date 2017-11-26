package action.order;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.OrderForm;
import model.bean.Order;

import model.bo.OrderBO;

public class CapNhatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		OrderForm orderForm = (OrderForm) form;
		String btnUpdate = orderForm.getBtnUpdate();

		// xoa list sản phẩm
		if ("delete".equals(btnUpdate)) {
			OrderBO orderBO = new OrderBO();
			orderBO.deleteOrder(orderForm.getOrderId());
			return mapping.findForward("thanhCong");
		} else
		// edit view
		if ("updateView".equals(btnUpdate)) {
			OrderBO orderBO = new OrderBO();
			Order order = orderBO.getOrder(orderForm.getOrderId());
			String userName = order.getUserName();
			String fullName = order.getFullName();
			String email = order.getEmail();
			String phone = order.getPhone();
			String address = order.getAddress();
			String gender = order.getGender();
			String method = order.getMethod();
			Date birthday = order.getBirthday();
			int totalQuantity = order.getTotalQuantity();
			long totalPrice = order.getTotalPrice();
			boolean status = order.getStatus();
			boolean confirm = order.getConfirm();
			String createdday = order.getCreatedday();
			orderForm.addOrderForm(userName, fullName, email, phone, address, gender, method, birthday,totalQuantity, totalPrice, status, confirm, createdday);
			return mapping.findForward("thatBai");
		}else{
//			Order order = new OrderBO().getOrder(orderForm.getOrderId());
//			order.setStatus(orderForm.getStatus());
//			new OrderBO().updateOrder(order);
			String userName = orderForm.getUserName();
			String fullName = orderForm.getFullName();
			String email = orderForm.getEmail();
			String phone = orderForm.getPhone();
			String address = orderForm.getAddress();
			String gender = orderForm.getGender();
			String method = orderForm.getMethod();
			Date birthday = orderForm.getBirthday();
			int totalQuantity = orderForm.getTotalQuantity();
			long totalPrice = orderForm.getTotalPrice();
			boolean status = orderForm.getStatus();
			boolean confirm = orderForm.getConfirm();
			String createdday = orderForm.getCreatedday();
			Order order = new Order(userName, fullName, email, phone, address, gender, method, birthday, totalQuantity, totalPrice, status, confirm, createdday);
			order.setOrderId(orderForm.getOrderId());
			new OrderBO().updateOrder(order);
			// OrderBO orderBO = new OrderBO();
			// int orderId = orderForm.getOrderId();
			// String userName = orderForm.getUserName();
			// String fullName = orderForm.getFullName();
			// String email = orderForm.getEmail();
			// String phone = orderForm.getPhone();
			// String address = orderForm.getAddress();
			// String method=orderForm.getMethod();
			// double totalQuantity = orderForm.getTotalQuantity();
			// double totalPrice=orderForm.getTotalPrice();
			// boolean status = orderForm.getStatus();
			// Date createdday = orderForm.getCreatedday();
			// Order order = new Order(orderId, userName, fullName, email, phone,
			// address, method, totalQuantity, totalPrice, status, createdday);
			// if("add".equals(orderForm.getBtnUpdate()))
			// {
			// orderBO.insertOrder(order);
			//
			// }
			// else
			// {
			// orderBO.updateOrder(order);
			//
			// }
			return mapping.findForward("thanhCong");
		}
	}
}
