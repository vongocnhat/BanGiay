package action.accessories;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AccessoriesForm;
import model.bean.Accessories;
import model.bo.AccessoriesBO;

public class DanhSachAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AccessoriesForm accessoriesForm = (AccessoriesForm)form;
		AccessoriesBO accessoriesBO=new AccessoriesBO();
		ArrayList<Accessories>listAccessories=new ArrayList<Accessories>();
		listAccessories=accessoriesBO.getlistAccessories();
		accessoriesForm.setListAccessories(listAccessories);
		return mapping.findForward("accessoriesSuccess");
	}

}
