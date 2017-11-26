package action.person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PersonForm;
import model.bean.Person;
import model.bo.PersonBO;

public class CapNhatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		PersonForm personForm = (PersonForm) form;
		String btnUpdate = personForm.getBtnUpdate();
		PersonBO personBO = new PersonBO();
		//lay thong tin nguoi dung
		if("delete".equals(btnUpdate))
		{
			personBO.deletePerson(personForm.getUserName());
			return mapping.findForward("thanhCong");
		}
		if("addView".equals(btnUpdate)){
			return mapping.findForward("thatBai");
		}
		//update view
		if("updateView".equals(btnUpdate))
		{
			Person person = personBO.getPerson(personForm.getUserName());
			personForm.setUserName(person.getUserName());
//			personForm.setPassword(person.getPassword());
			personForm.setType(person.getType());
			personForm.setStatus(person.getStatus());
			personForm.setFullName(person.getFullName());
			personForm.setGender(person.getGender());
			personForm.setBirthday(person.getBirthday());
			personForm.setAddress(person.getAddress());
			personForm.setPhone(person.getPhone());
			personForm.setEmail(person.getEmail());
			return mapping.findForward("thatBai");
		}
		if(personBO.checkUserName(personForm.getUserName()) && !"edit".equals(btnUpdate)){
			personForm.setThongBao("Tài khoản đã tồn tại.");
			return mapping.findForward("thatBai");
		}
		//them sua vao databas
		personBO.updatePerson(personForm, btnUpdate);
		return mapping.findForward("thanhCong");
	}
}
