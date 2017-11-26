package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.FeedBackForm;
import model.bean.FeedBack;
import model.bo.FeedBackBO;

public class FeedBackAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		FeedBackForm feedBackForm= (FeedBackForm)form;
		FeedBackBO feedBackBO =new FeedBackBO();
		FeedBack feedback=new FeedBack();
		
		if("submit".equals(feedBackForm.getSubmit()))
		{
			String name = new String(feedBackForm.getName().getBytes("ISO-8859-1"), "UTF-8");
			String email = new String(feedBackForm.getEmail().getBytes("ISO-8859-1"), "UTF-8");
			String contentFeedBack = new String(feedBackForm.getContentFeedBack().getBytes("ISO-8859-1"), "UTF-8");
			
			feedback.setName(name);
			feedback.setEmail(email);
			feedback.setContentFeedBack(contentFeedBack);
			
			feedBackBO.insertFeedBack(feedback);
			return mapping.findForward("feedBackSuccess");
		}else
		{
			return mapping.findForward("feedBackFail");	
		}
	}
}
