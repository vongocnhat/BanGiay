package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CommentProductForm;
import model.bo.CommentProductBO;

public class UpdateCommentProductAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CommentProductForm commentProductForm = (CommentProductForm) form;
		
		int commentProductId = commentProductForm.getCommentId();
		String contentConmment = commentProductForm.getContentConmment();
		contentConmment = new String(contentConmment.getBytes("ISO-8859-1"), "UTF-8");
		
		new CommentProductBO().updateCommentProduct(commentProductId, contentConmment);
		
		//return mapping.findForward("thanhCong");
		return super.execute(mapping, form, request, response);
	}
}
