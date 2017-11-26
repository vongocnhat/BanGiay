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

public class CapNhatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProductDetailForm productDetailForm = (ProductDetailForm) form;
		ProductDetailBO productDetailBO =new ProductDetailBO();
		int productId =productDetailForm.getProductId();
		int productDetailId =productDetailForm.getProductDetailId();
//		if("btnUpdate".equals(productDetailForm.getBtnUpdate()))
//		{
//			String image=productDetailForm.getImage();
//			String image2=productDetailForm.getImage2();
//			String image3=productDetailForm.getImage3();
//			String color=productDetailForm.getColor();
//			productDetailBO.updateProductDetail(new ProductDetail(productDetailId, productId, image, image2, image3, color));
//			return mapping.findForward("thanhCong");
//		}else
//		{
//			ProductDetail productDetail=productDetailBO.getListProductDetail(productId);
//			productDetailForm.setProductDetailId(productDetail.getProductDetailId());
//			productDetailForm.setImage(productDetail.getImage());
//			productDetailForm.setImage2(productDetail.getImage2());
//			productDetailForm.setImage3(productDetail.getImage3());
//			productDetailForm.setColor(productDetail.getColor());
//		}
			return mapping.findForward("thatBai");
	}
}
