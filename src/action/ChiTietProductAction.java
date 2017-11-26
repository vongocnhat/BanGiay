package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CartForm;
import form.DanhSachProductForm;
import model.bean.Category;
import model.bean.CommentProduct;
import model.bean.Person;
import model.bean.Product;
import model.bean.ProductDetail;
import model.bean.ProductDetailSQ;
import model.bean.Promotion;
import model.bo.AccessoriesBO;
import model.bo.CategoryBO;
import model.bo.CommentProductBO;
import model.bo.ProductBO;
import model.bo.ProductDetailBO;
import model.bo.ProductDetailSQBO;
import model.bo.PromotionBO;
import model.dao.ProductDetailDAO;

public class ChiTietProductAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DanhSachProductForm danhSachProductForm = (DanhSachProductForm)form;
		//get list category bỏ
		int productId = danhSachProductForm.getProductId();
		int categoryId = danhSachProductForm.getCategoryId();
		//get list category
		CategoryBO categoryBO = new CategoryBO();
		danhSachProductForm.setCategory(categoryBO.getCategory(categoryId));
		
		//get list product
		ProductBO productBO = new ProductBO();
		ArrayList<Product> listProduct= productBO.getListProductTop4();
		//get product
		Product product = new Product();
		product = productBO.getProduct(productId);
		//get list product detail by productId
		ProductDetailBO productDetailBO = new ProductDetailBO();
		ArrayList<ProductDetail> listProductDetail = productDetailBO.getListProductDetail(productId);
		//get promotion by productId
		PromotionBO promotionBO = new PromotionBO();
		ArrayList<Promotion> listPromotion = promotionBO.getListPromotion(productId);
		//get listAccessories ở trong productDAO rồi
		//get listProductDetailSQ ở trong productDetailDAO rồi
		//set vao list
		danhSachProductForm.setListProduct(listProduct);
		danhSachProductForm.setProduct(product);
		danhSachProductForm.setListProductDetail(listProductDetail);
		danhSachProductForm.setListPromotion(listPromotion);
		//binh luan dung
		ArrayList<CommentProduct> listCommentProduct = new CommentProductBO().getlistCommentProduct(productId);
		danhSachProductForm.setListCommentProduct(listCommentProduct);
		// Dungnv
		Person person = (Person) request.getSession().getAttribute("person");
		if(person!=null)
		{
			danhSachProductForm.setUserName(person.getUserName());
		}
		
		//5 phut tang view 1 lan
		Cookie cookie = new Cookie(Integer.toString(productId), "");
		cookie.setMaxAge(300);
		response.addCookie(cookie);
		Cookie[] cookies =request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
//			cookies[i].setMaxAge(0);
//			response.addCookie(cookies[i]);
			if(i == (cookies.length-1) && !(Integer.toString(productId).equals(cookies[i].getName())))
			{
				product.setIncreaseNumberViewed();
				productBO.increaseNumberViewed(productId);
			}
		}
		//thoi gian ton tai cookie
		return mapping.findForward("chiTietSanPham");
	}
}
