package form;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Promotion;

public class PromotionForm extends ActionForm{
	private int promotionId;
	private int productId;
	private int accessoriesId;
	private int discount;
	private Date mfgDate;
	private Date expDate;
	private ArrayList<Promotion> listPromotion;
	

	public int getPromotionId() {
		return promotionId;
	}


	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getAccessoriesId() {
		return accessoriesId;
	}


	public void setAccessoriesId(int accessoriesId) {
		this.accessoriesId = accessoriesId;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public Date getMfgDate() {
		return mfgDate;
	}


	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}


	public Date getExpDate() {
		return expDate;
	}


	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}


	public ArrayList<Promotion> getListPromotion() {
		return listPromotion;
	}


	public void setListPromotion(ArrayList<Promotion> listPromotion) {
		this.listPromotion = listPromotion;
	}


	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}

}
