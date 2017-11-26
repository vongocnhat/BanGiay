package model.bo;

import java.util.ArrayList;

import model.bean.Rate;
import model.dao.RateDAO;

public class RateBO {
	RateDAO rateDAO = new RateDAO();
	
	public ArrayList<Rate> getlistRate() {
		return rateDAO.getListRate();
	}
	
	public void insertRate(Rate rate) {
		rateDAO.insertRate(rate);
	}
	
	public void deleteRate(Rate rate) {
		rateDAO.deleteRate(rate);
	}
}
