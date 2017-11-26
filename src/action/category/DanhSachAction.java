package action.category;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CategoryForm;
import model.bo.CategoryBO;


public class DanhSachAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CategoryForm categoryForm = (CategoryForm) form;
		CategoryBO categoryBO = new CategoryBO();
		ArrayList<model.bean.Category> listCategory = categoryBO.getlistCategory();
		categoryForm.setListCategory(listCategory);
		return mapping.findForward("thanhCong");
	}
}
