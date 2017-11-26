package action.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.OrderForm;
import model.bean.Order;
import model.bo.OrderBO;

public class DanhSachAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		OrderForm orderForm = (OrderForm) form;
		OrderBO orderBO = new OrderBO();
		ArrayList<Order> listOrder = orderBO.getlistOrder();
		orderForm.setListOrder(listOrder);
		return mapping.findForward("thanhCong");
	}
}
