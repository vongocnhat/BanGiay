package model.bean;

import java.sql.Date;
import java.util.ArrayList;

public class Promotion {
	private int promotionId;
	private int productId;
	private int accessoriesId;
	private int discount;
	private Date mfgDate;
	private Date expDate;
	private ArrayList<Accessories> listAccessories;
	
	public Promotion() {
		super();
	}
	public Promotion(int promotionId, int productId, int accessoriesId,
			int discount, Date mfgDate, Date expDate) {
		super();
		this.promotionId = promotionId;
		this.productId = productId;
		this.accessoriesId = accessoriesId;
		this.discount = discount;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}
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
	public ArrayList<Accessories> getListAccessories() {
		return listAccessories;
	}
	public void setListAccessories(ArrayList<Accessories> listAccessories) {
		this.listAccessories = listAccessories;
	}
}
