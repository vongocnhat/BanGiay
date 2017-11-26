package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AddProductForm;
import model.bean.Category;
import model.bean.Product;
import model.bo.CategoryBO;
import model.bo.ProductBO;

public class AddProductAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		AddProductForm addProductForm = (AddProductForm) form;
		
		ArrayList<Category> listCategory = new CategoryBO().getlistCategory();
		addProductForm.setListCategory(listCategory);
		
		if("submit".equals(addProductForm.getSubmit())) {
			Product product = new Product();
			product.setCategoryId(addProductForm.getCategoryId());
			product.setProductName(addProductForm.getProductName());
			product.setDescription(addProductForm.getDescription());
			//tạm thời xóa
//			product.setPrice(addProductForm.getPrice());
			
			new ProductBO().insertProduct(product);
			
			return mapping.findForward("addProductSucess");
		} else {
			return mapping.findForward("addProductErr");
		}
	}
	
}
