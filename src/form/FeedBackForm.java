package form;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.FeedBack;

public class FeedBackForm extends ActionForm{

	private String contentFeedBack;
	private String name;
	private String email;
	private String submit;
	private ArrayList<FeedBack> listFeedBack;
	
	public ArrayList<FeedBack> getListFeedBack() {
		return listFeedBack;
	}
	public void setListFeedBack(ArrayList<FeedBack> listFeedBack) {
		this.listFeedBack = listFeedBack;
	}
	public String getContentFeedBack() {
		return contentFeedBack;
	}
	public void setContentFeedBack(String contentFeedBack) {
		this.contentFeedBack = contentFeedBack;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}


	
}
