package action.person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.PersonForm;
import model.bo.PersonBO;

public class AdminDangNhapAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// PersonBO personBO = new PersonBO();
		// ArrayList<Person> listPerson = personBO.getListPerson();
		
		PersonForm personForm = (PersonForm) form;
		PersonBO personBO = new PersonBO();
		if(personForm.getUserName() != null)
			if(personBO.checkLogin(personForm.getUserName(), StringProcess.encrypt(personForm.getPassword()), 1))
			{
				return mapping.findForward("thanhCong");
			}
			else
				personForm.setThongBao("Sai Tài Khoản Hoặc Mật Khẩu Hoặc Bị Khóa");
		return mapping.findForward("thatBai");
	}

}
