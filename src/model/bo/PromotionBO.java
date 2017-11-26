package model.bo;

import java.util.ArrayList;

import model.bean.Promotion;
import model.dao.PromotionDAO;

public class PromotionBO {
	PromotionDAO promotionDAO = new PromotionDAO();
	
	public ArrayList<Promotion> getListPromotion(int productId) {
		return promotionDAO.getListPromotion(productId);
	}
	
	public void insertPromotion(Promotion promotion) {
		promotionDAO.insertPromotion(promotion);
	}
	
	public void updatePromotion(Promotion promotion) {
		promotionDAO.updatePromotion(promotion);
	}
	
	public void deletePromotion(String promotionId) {
		promotionDAO.deletePromotion(promotionId);
	}
	public ArrayList<Promotion> getListPromotion() {
		return promotionDAO.getListPromotion();
	}
}
