package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

//import form.KhoaForm;
//import model.bo.KhoaBO;

public class TimKhoaAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		KhoaForm khoaForm = (KhoaForm) form;
//		String tenKhoa = khoaForm.getTenKhoa();
//		KhoaBO khoaBO = new KhoaBO();
		//khoaForm.setListKhoa(khoaBO.timKhoa(tenKhoa));
		return mapping.findForward("timKhoa");
	}
}
