package action.promotion;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PromotionForm;
import model.bean.Promotion;
import model.bo.PromotionBO;

public class DanhSachAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PromotionForm promotionForm =(PromotionForm) form;
		PromotionBO promotionBO=new PromotionBO();
		ArrayList<Promotion> listPromotion=new ArrayList<Promotion>();
		listPromotion=promotionBO.getListPromotion();
		promotionForm.setListPromotion(listPromotion);
		return mapping.findForward("promotionSuccess");
	}
	
}
