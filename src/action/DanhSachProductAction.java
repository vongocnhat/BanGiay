package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.DanhSachProductForm;
import model.bean.Category;
import model.bean.Product;
import model.bo.CategoryBO;
import model.bo.ProductBO;

public class DanhSachProductAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DanhSachProductForm danhSachProductForm = (DanhSachProductForm) form;
		// Get List Category
		CategoryBO categoryBO = new CategoryBO();
		ArrayList<Category> listCategory = categoryBO.getlistCategory();
		danhSachProductForm.setListCategory(listCategory);
		// Get List Product đã sửa
		ProductBO productBO = new ProductBO();
		ArrayList<Product> listProduct = new ArrayList<Product>();
		int categoryId = danhSachProductForm.getCategoryId();
		//đã sửa
		if (categoryId == 0) {
			listProduct = productBO.getListProduct();
			// đã sửa
			danhSachProductForm.setListProduct(listProduct);
		} else {
			listProduct = productBO.getListProductByCategoryId(categoryId);
			// đã sửa
			danhSachProductForm.setListProduct(listProduct);
		}
		// dungnv 14-08
		ArrayList<Product> listProductNumberViewed = new ArrayList<Product>();
		listProductNumberViewed = productBO.getListProductNumberViewed();
		danhSachProductForm.setListProductNumberViewed(listProductNumberViewed);
		
		ArrayList<Product> listProductNumberSeller = new ArrayList<Product>();
		listProductNumberSeller = productBO.getListProductNumberSeller();
		danhSachProductForm.setListProductNumberSeller(listProductNumberSeller);
	
		//sắp xếp
//		request.setAttribute("order","select");
//		if("descPrice".equals(danhSachProductForm.getOrderProduct()))
//		{
//			request.setAttribute("order",danhSachProductForm.getOrderProduct());
//			listProduct=productBO.getListOrderProductPrice("DESC");
//			danhSachProductForm.setListProduct(listProduct);
//		}
//		if("ascPrice".equals(danhSachProductForm.getOrderProduct()))
//		{
//			request.setAttribute("order",danhSachProductForm.getOrderProduct());
//			listProduct=productBO.getListOrderProductPrice("ASC");
//			danhSachProductForm.setListProduct(listProduct);
//		}
//		if("ascName".equals(danhSachProductForm.getOrderProduct()))
//		{
//			request.setAttribute("order",danhSachProductForm.getOrderProduct());
//			listProduct=productBO.getListOrderProductName("ASC");
//			danhSachProductForm.setListProduct(listProduct);
//		}
//		if("descName".equals(danhSachProductForm.getOrderProduct()))
//		{
//			request.setAttribute("order",danhSachProductForm.getOrderProduct());
//			listProduct=productBO.getListOrderProductName("DESC");
//			danhSachProductForm.setListProduct(listProduct);
//		}
		
		return mapping.findForward("danhSachProduct");
	}

}
