package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.PersonForm;
import model.bean.Account;
import model.bean.Person;
import model.bo.PersonBO;


public class CustomerLoginAddAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PersonForm personForm = (PersonForm) form;
		PersonBO personBO = new PersonBO();
				
		if("submitDangNhap".equals(personForm.getSubmit())) {
			if(personForm.getUserName() != null)
				if(personBO.checkLogin(personForm.getUserName(), StringProcess.encrypt(personForm.getPassword()), 0))
				{
					HttpSession session=request.getSession();
					Person person = new Person();
					person = personBO.getPerson(personForm.getUserName());
					session.setAttribute("person", person);
					return mapping.findForward("dangNhapThanhCong");
				}
				else
					personForm.setThongBao("Sai tài khoản, mật khẩu hoặc bị khóa");
			return mapping.findForward("dangNhapThatBai");
		}
		
		if("submitDangKy".equals(personForm.getSubmit())) {
			if(personBO.checkUserName(personForm.getUserName())){
				personForm.setThongBao("Tài khoản đã tồn tại.");
			} else {
				Person person = new Person();

				person.setUserName(personForm.getUserName());
				person.setPassword(StringProcess.encrypt(personForm.getPassword()));
				person.setType(0);
				person.setStatus(true);
				
				person.setFullName(personForm.getFullName());
				person.setGender(personForm.getGender());
				person.setBirthday(personForm.getBirthday());
				
				person.setAddress(personForm.getAddress());
				
				person.setPhone(personForm.getPhone());
				person.setEmail(personForm.getEmail());
				
				personBO.insertPerson(person);
				
				HttpSession session =request.getSession();
				Person person2 = new Person();
				person2 = personBO.getPerson(personForm.getUserName());
				session.setAttribute("person", person2);
				
				return mapping.findForward("dangKyThanhCong");
			}
		}
		return mapping.findForward("loi");
	}
	
}
