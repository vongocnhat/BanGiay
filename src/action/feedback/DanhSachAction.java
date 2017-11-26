package action.feedback;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.FeedBackForm;
import model.bean.FeedBack;
import model.bo.FeedBackBO;
import model.dao.FeedBackDAO;

public class DanhSachAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			FeedBackForm feedBackForm = (FeedBackForm)form;
			FeedBackBO feedBackBO =new FeedBackBO();
			ArrayList<FeedBack> listFeedBack=new ArrayList<FeedBack>();
			listFeedBack=feedBackBO.getlistFeedBack();
			feedBackForm.setListFeedBack(listFeedBack);
			return mapping.findForward("feedBackSuccess");
	}
	
}
