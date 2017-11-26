package action.productdetail;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ProductDetailForm;
import form.ProductForm;
import model.bean.Category;
import model.bean.Product;
import model.bean.ProductDetail;
import model.bo.CategoryBO;
import model.bo.ProductBO;
import model.bo.ProductDetailBO;

public class DanhSachAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProductDetailForm productDetailForm = (ProductDetailForm) form;
		ProductDetailBO productDetailBO = new ProductDetailBO();
		ArrayList<ProductDetail> listProductDetail=productDetailBO.getListProductDetail();
		productDetailForm.setListProductDetail(listProductDetail);
		return mapping.findForward("thanhCong");
	}
}
