package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Person;
import model.bo.PersonBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;

import form.UpdatePasswordPersonForm;

public class UpdatePasswordPersonAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UpdatePasswordPersonForm updatePasswordPersonForm = (UpdatePasswordPersonForm) form;
		if("submit".equals(updatePasswordPersonForm.getSubmit())) {
			Person person = (Person) request.getSession().getAttribute("person");
			if(person!=null)
			{
				String userName = person.getUserName();
				String password = StringProcess.encrypt(updatePasswordPersonForm.getPassword());
				if(new PersonBO().checkLogin(userName, password, 0)) {
					Person person2 = new PersonBO().getPerson(userName);
					person2.setPassword(updatePasswordPersonForm.getPasswordNew());
					new PersonBO().updatePerson(person2);
					return mapping.findForward("thanhCong");
				}
			}
		}
		updatePasswordPersonForm.setThongBao("Doi mat khau khong thanh cong.");
		return mapping.findForward("thatBai");
	}
	
}
