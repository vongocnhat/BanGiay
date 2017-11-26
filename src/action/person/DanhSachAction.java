package action.person;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PersonForm;
import model.bean.Person;
import model.bo.PersonBO;

public class DanhSachAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		PersonForm personForm = (PersonForm) form;
		PersonBO personBO = new PersonBO();
		ArrayList<Person> listPerson = personBO.getListPerson(personForm.getType());
		personForm.setListPerson(listPerson);
		return mapping.findForward("thanhCong");
	}
}
