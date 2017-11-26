package action.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CategoryForm;
import model.bean.Category;
import model.bo.CategoryBO;



public class CapNhatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CategoryForm categoryForm = (CategoryForm) form;
		String btnUpdate = categoryForm.getBtnUpdate();
		//xoa list category
		if("delete".equals(btnUpdate))
		{
			CategoryBO categoryBO = new CategoryBO();
			categoryBO.deleteCategory(categoryForm.getCategoryId());
			return mapping.findForward("thanhCong");
		}
		if("addView".equals(btnUpdate)){
			return mapping.findForward("thatBai");
		}
		//edit view
		if("updateView".equals(btnUpdate))
		{
			CategoryBO categoryBO = new CategoryBO();
			Category category = categoryBO.getCategory(categoryForm.getCategoryId());
			String categoryParent = category.getCategoryParent();
			String categoryName = category.getCategoryName();
			categoryForm.addCategoryForm( categoryParent, categoryName);
			return mapping.findForward("thatBai");
		}
		CategoryBO categoryBO = new CategoryBO();
		int categoryId= categoryForm.getCategoryId();
		String categoryParent = categoryForm.getCategoryParent();
		String categoryName = categoryForm.getCategoryName();
		Category category = new Category(categoryId ,categoryParent, categoryName);
		
		if("add".equals(categoryForm.getBtnUpdate()))
		{
			categoryBO.insertCategory(category);
		}
		else
		{
			categoryBO.updateCategory(category);
		}
		return mapping.findForward("thanhCong");
	}

}
