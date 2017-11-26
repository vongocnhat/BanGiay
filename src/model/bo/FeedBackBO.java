package model.bo;

import java.util.ArrayList;

import model.bean.FeedBack;
import model.dao.FeedBackDAO;


public class FeedBackBO {
	FeedBackDAO feedBackDAO = new FeedBackDAO();
	
	public ArrayList<FeedBack> getlistFeedBack() {
		return feedBackDAO.getListFeedBack();
	}
	
	public void insertFeedBack(FeedBack feedBack) {
		feedBackDAO.insertFeedBack(feedBack);
	}
	
	public void updateFeedBack(FeedBack feedBack) {
		feedBackDAO.updateFeedBack(feedBack);
	}
	
	public void deleteFeedBack(String feedBackId) {
		feedBackDAO.deleteFeedBack(feedBackId);
	}
}
