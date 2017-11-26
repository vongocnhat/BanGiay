package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachProductForm;
import model.bean.Product;
import model.bo.ProductBO;

public class AjaxProductAction extends Action {
	 @Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DanhSachProductForm danhSachProductForm = (DanhSachProductForm) form;
		ProductBO productBO = new ProductBO();
		String column = danhSachProductForm.getColumn();
		String sortType = danhSachProductForm.getSortType();
		ArrayList<Product> listProduct = productBO.sortListProduct(column, sortType);
		danhSachProductForm.setListProduct(listProduct);
		return mapping.findForward("thanhCong");
	}
}
