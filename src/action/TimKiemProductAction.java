package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachProductForm;
import model.bean.Person;
import model.bean.Product;
import model.bean.ProductDetailSQ;
import model.bo.ProductBO;
import model.bo.ProductDetailSQBO;

public class TimKiemProductAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DanhSachProductForm danhSachProductForm=(DanhSachProductForm)form;
		
		ProductBO productBO =new ProductBO();
		ArrayList<Product> listProduct=new ArrayList<Product>();
		// Get List Product đã sửa
//		ProductBO productBO = new ProductBO();
//		ArrayList<ProductDetailSQ> listProduct = new ArrayList<ProductDetailSQ>();
		if("submitYeuThich".equals(danhSachProductForm.getSubmit()))
		{
			// dungnv de lai
			Person person = (Person) request.getSession().getAttribute("person");
			if(person!=null)
			{
				listProduct=productBO.getListSearchProductYeuThich(person.getUserName());
				danhSachProductForm.setListProduct(listProduct);
				danhSachProductForm.setStringSearch("Xem sản phẩm yêu thích của bạn");
				return mapping.findForward("timKiem200");
			}
			return mapping.findForward("timKiem404");
		}
		if("submit".equals(danhSachProductForm.getSubmit()))
		{
			String productName=danhSachProductForm.getStringSearch();
			productName = new String(productName.getBytes("ISO-8859-1"), "UTF-8");
			if(productName==null || productName.length()==0)
			{
				return mapping.findForward("timKiem404");
			}
			listProduct=productBO.getListSearchProduct(productName);
			danhSachProductForm.setListProduct(listProduct);
			danhSachProductForm.setStringSearch("KẾT QUẢ TÌM KIẾM VỚI TỪ KHÓA  " + productName);
			
			return mapping.findForward("timKiem200");
		}
		else
		{
			return mapping.findForward("timKiem404");
		}
	}
}
