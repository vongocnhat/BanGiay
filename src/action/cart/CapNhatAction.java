package action.cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.CartForm;
import model.bean.Cart;

public class CapNhatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// response.setContentType("text/html;charset=UTF-8");
		// request.setCharacterEncoding("utf-8");
		CartForm cartForm = (CartForm) form;
		HttpSession session = request.getSession();
		String type = cartForm.getType();
		if (cartForm.getListCart() == null)
			cartForm.constructListCart();
		// add cart
		if ("add".equals(type)) {
			int productDetailId = cartForm.getProductDetailId();
			int productDetailSQId = cartForm.getProductDetailSQId();
			
			ArrayList<Cart> listCart = new ArrayList<Cart>();
			listCart = cartForm.getListCart();
			for (int i = 0; i < listCart.size(); i++) {
				//cung productDetailId cùng productDetailSQId
				if (listCart.get(i).getProductDetailSQId() == productDetailSQId && productDetailId == listCart.get(i).getProductDetailId()) {
					cartForm.updateQuantityCart(cartForm.getQuantity() + listCart.get(i).getQuantity(), i);
					//session
					session.setAttribute("cartForm", cartForm);
					return mapping.findForward("thanhCong");
				}
			}
			String productName = StringProcess.UTF_8(cartForm.getProductName());
			String image = cartForm.getImage();
			String color = StringProcess.UTF_8(cartForm.getColor());
			long price = cartForm.getPrice();
			float size = cartForm.getSize();
			int quantity = cartForm.getQuantity();
			Cart cart = new Cart(productName, image, color, price, productDetailId, productDetailSQId, size, quantity);
			cartForm.addCart(cart);
		} else if ("update".equals(type))
			cartForm.updateQuantityCart(cartForm.getQuantity(), (cartForm.getSTT() - 1));
		else
			cartForm.deleteCart((cartForm.getSTT() - 1));
		//session
		session.setAttribute("cartForm", cartForm);
		return mapping.findForward("thanhCong");
	}
}
