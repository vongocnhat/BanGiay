package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CommentProductForm;
import model.bean.CommentProduct;
import model.bo.CommentProductBO;

public class AddCommentProductAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		CommentProductForm commentProductForm = (CommentProductForm) form;

		CommentProduct commentProduct = new CommentProduct();
		commentProduct.setCommentIdParent(commentProductForm.getCommentIdParent());
		commentProduct.setLevelCmt(commentProductForm.getLevelCmt());
		commentProduct.setProductId(commentProductForm.getProductId());
		commentProduct.setUserName(commentProductForm.getUserName());

		String contentConmment = commentProductForm.getContentConmment();
		contentConmment = new String(contentConmment.getBytes("ISO-8859-1"), "UTF-8");
		commentProduct.setContentConmment(contentConmment);

		new CommentProductBO().insertCommentProduct(commentProduct);
		
		return super.execute(mapping, form, request, response);
	}
	
}
