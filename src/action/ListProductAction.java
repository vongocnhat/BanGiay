package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListProductForm;
import model.bean.Category;
import model.bean.Product;
import model.bo.CategoryBO;
import model.bo.ProductBO;

public class ListProductAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ListProductForm listProductForm = (ListProductForm) form;
		
		//ArrayList<Category> listCategory = new CategoryBO().getlistCategory();
		ArrayList<Product> listProduct = null;
		
		//listProductForm.setListCategory(listCategory);
		
		int categoryId = listProductForm.getCategoryId();
		
		
		
		//if(String.valueOf(categoryId).length()==0) {
			listProduct = new ProductBO().getListProduct();
		//}
		
		listProductForm.setListProduct(listProduct);
		return mapping.findForward("listProduct");
	}
	
}
