package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Person;
import model.bo.PersonBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PersonForm;

public class ThongTinTaiKhoanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		PersonForm personForm = (PersonForm) form;
		
		// dung 13-08
		Person person = (Person) request.getSession().getAttribute("person");
		if(person!=null)
		{
			String uName = person.getUserName();
			personForm.setPerson(new PersonBO().getPerson(uName));
		}
		return mapping.findForward("thanhCong");
	}
}
