package action.productdetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ProductDetailForm;
import model.bean.ProductDetail;
import model.bo.ProductDetailBO;

public class XoaAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProductDetailForm productDetailForm =(ProductDetailForm)form;
		ProductDetailBO productDetailBO=new ProductDetailBO();
		int productDetailId=productDetailForm.getProductDetailId();
		int productId=productDetailForm.getProductId();
		if("btnUpdate".equals(productDetailForm.getBtnUpdate()))
		{
			productDetailBO.deleteProductDetail(productDetailId);
			return mapping.findForward("thanhCong");
		}else
		{

			ProductDetail productDetail=productDetailBO.getProductDetail(productId);
			productDetailForm.setProductDetailId(productDetail.getProductDetailId());
			productDetailForm.setImage(productDetail.getImage());
			productDetailForm.setImage2(productDetail.getImage2());
			productDetailForm.setImage3(productDetail.getImage3());
			productDetailForm.setColor(productDetail.getColor());
			return mapping.findForward("thatBai");
		}
	}

}
