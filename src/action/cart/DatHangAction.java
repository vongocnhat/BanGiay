package action.cart;

import java.sql.Date;
import java.util.ArrayList;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import common.baokim.BaoKimPayment;
import form.CartForm;
import form.PersonForm;
import model.bean.Cart;
import model.bean.Order;
import model.bean.OrderDetail;
import model.bean.Person;
import model.bo.OrderBO;
import model.bo.OrderDetailBO;
import model.bo.PersonBO;
import model.bo.ProductDetailSQBO;

public class DatHangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// PersonForm personForm = (PersonForm) form;
		// lay thong tin gio hang
		HttpSession session = request.getSession();
		PersonForm personForm = (PersonForm) form;
		CartForm cartForm = (CartForm) session.getAttribute("cartForm");
		// lay khach hang da dang nhap
		Person person = (Person) session.getAttribute("person");
		// lấy order id
		OrderBO orderBO = new OrderBO();
		int orderId = orderBO.getOrderId() + 1;
		// lay thong tin khach hang da dang nhap
		// kiem tra nguoi dung co dang dang nhap hay khong
		if (person != null)
		{
			// person cua session dang nhap
			String fullName = person.getFullName();
			String email = person.getEmail();
			String phone = person.getPhone();
			String address = person.getAddress();
			String gender = person.getGender();
			Date birthday = person.getBirthday();
			// lay thong tin cua khach hang da dang nhap de hien thi ra view
			personForm.setFullName(fullName);
			personForm.setEmail(email);
			personForm.setPhone(phone);
			personForm.setAddress(address);
			personForm.setGender(gender);
			personForm.setBirthday(birthday);
		}
		//thanh toán online thành công
		if ("submitOnline".equals(personForm.getMethod())) {
			// add online to database
			cartForm.getOrder().setStatus(true);;
			addToDatabase(cartForm);
			session.removeAttribute("cartForm");
			return mapping.findForward("thanhCong");
		}
		if ("submitDatHang".equals(personForm.getSubmit())) {
			//
			String userName;
			if(person == null)
				userName = "guest";
			else
				userName = person.getUserName();
			String fullName = personForm.getFullName();
			String email = personForm.getEmail();
			String phone = personForm.getPhone();
			String address = personForm.getAddress();
			String gender = personForm.getGender();
			Date birthday = personForm.getBirthday();
			String method = "Offline";
			boolean status = false;
			boolean confirm = false;
			String createdday = StringProcess.getDateNow();
			////////////////////////////
			int totalQuantity = cartForm.getTotalQuantity();
			long totalPrice = cartForm.getTotalPrice();
			// them person vao cart de chuyen trang khong bi mat
			// bỏ order vào session form
			Order order = new Order(userName, fullName, email, phone, address, gender, method, birthday, totalQuantity,
					totalPrice, status, confirm, createdday);
			cartForm.setOrder(order);
			// listcart là orderDetail bỏ orderdetai vào session form
			ArrayList<Cart> listCart = cartForm.getListCart();
			cartForm.setListCart(listCart);
			if ("baokim".equals(personForm.getMethod())) {
				BaoKimPayment baoKimPayment = new BaoKimPayment();
				String url_success = "http://localhost:8080/BanGiay/dat-hang.do?method=submitOnline";
				String url_cancel = "http://localhost:8080/BanGiay/trang-chu.do";
				String url_detail = "http://localhost:8080/BanGiay/gio-hang.do";
				String url = baoKimPayment.createRequestUrl(Integer.toString(orderId), "nhat33506@gmail.com", Long.toString(cartForm.getPrice()),
						"0", "0", "TT", url_success, url_cancel, url_detail);
				method = "Bảo Kim";
				cartForm.getOrder().setMethod(method);
				return redirectToBaoKim(url);
			} else if ("nganluong".equals(personForm.getMethod())) {
				method = "Ngân Lượng";
				cartForm.getOrder().setMethod(method);
			} else {
				// add offline
				addToDatabase(cartForm);
				session.removeAttribute("cartForm");
				return mapping.findForward("thanhCong");
			}
		}
//		cartForm.setTotalQuantity(personForm.getTotalQuantity());
//		cartForm.setTotalPrice(Long.toString(personForm.getTotalPrice()));
		cartForm.setOrderId(orderId);
		return mapping.findForward("thatBai");
	}

	private void addToDatabase(CartForm cartForm) {
		// add order
		OrderBO orderBO = new OrderBO();
		// set order to session
		orderBO.insertOrder(cartForm.getOrder());
		OrderDetailBO orderDetailBO = new OrderDetailBO();
		// get OrderId
		int orderId = orderBO.getOrderId();
		int productDetailSQId;
		long price;
		int quantity;
		ProductDetailSQBO productDetailSQBO = new ProductDetailSQBO();
		// add orderdetail
		for (Cart cart : cartForm.getListCart()) {
			productDetailSQId = cart.getProductDetailSQId();
			price = cart.getPrice();
			quantity = cart.getQuantity();
			// giam so luong hang
			productDetailSQBO.reducedQuantity(productDetailSQId, quantity);
			OrderDetail orderDetail = new OrderDetail(orderId, productDetailSQId, price, quantity);
			orderDetailBO.insertOrderDetail(orderDetail);
		}
	}

	private ActionForward redirectToBaoKim(String url) {
		ActionForward actionForward = new ActionForward();
		actionForward.setPath(url);
		actionForward.setRedirect(true);
		return actionForward;
	}
}
