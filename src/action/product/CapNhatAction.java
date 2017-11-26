package action.product;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.ProductForm;
import model.bean.Category;
import model.bean.Product;
import model.bo.CategoryBO;
import model.bo.ProductBO;

public class CapNhatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProductForm productForm = (ProductForm) form;
		String btnUpdate = productForm.getBtnUpdate();
		//list Category
		CategoryBO categoryBO=new CategoryBO();
		ArrayList<Category> listCategory=categoryBO.getlistCategory();
		productForm.setListCategory(listCategory);
		//xoa list sản phẩm
		if("delete".equals(btnUpdate))
		{
			ProductBO productBO = new ProductBO();
			productBO.deleteProduct(productForm.getProductId());
			return mapping.findForward("thanhCong");
		}
		if("addView".equals(btnUpdate)){
			return mapping.findForward("thatBai");
		}
		//edit view
		if("updateView".equals(btnUpdate))
		{
			ProductBO productBO = new ProductBO();
			Product product = productBO.getProduct(productForm.getProductId());
			int categoryId = product.getCategoryId();
			String productName = product.getProductName();
			String description = product.getDescription();
			long price = product.getPrice();
			productForm.addProductForm(categoryId, productName, description, price);
			return mapping.findForward("thatBai");
		}
		
		ProductBO productBO = new ProductBO();
		int categoryId = productForm.getCategoryId();
		String productName = productForm.getProductName();
		String description = productForm.getDescription();
		long price = productForm.getPrice();
		String image = "chưa làm";
		Product product = new Product(categoryId, productName,description, price, image);
		if("add".equals(productForm.getBtnUpdate()))
		{
			productBO.insertProduct(product);
		}
		else
		{
			int productId = productForm.getProductId();
			product.setProductId(productId);
			productBO.updateProduct(product);
		}
		return mapping.findForward("thanhCong");
	}
}
