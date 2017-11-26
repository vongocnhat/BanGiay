package model.bo;

import java.util.ArrayList;

import model.bean.CommentProduct;
import model.dao.CommentProductDAO;


public class CommentProductBO {
	CommentProductDAO commentProductDAO = new CommentProductDAO();
	
	public ArrayList<CommentProduct> getlistCommentProduct() {
		return commentProductDAO.getListCommentProduct();
	}
	
	public ArrayList<CommentProduct> getlistCommentProduct(int productId) {		
		return commentProductDAO.getListCommentProduct(productId);
	}
	
	public void insertCommentProduct(CommentProduct commentProduct) {
		commentProductDAO.insertCommentProduct(commentProduct);
	}
	
	public void updateCommentProduct(CommentProduct commentProduct) {
		commentProductDAO.updateCommentProduct(commentProduct);
	}
	
	public void updateCommentProduct(int commentProductId, String contentConmment) {
		commentProductDAO.updateCommentProduct(commentProductId, contentConmment);
	}
	
	public void deleteCommentProduct(int commentProductId) {
		commentProductDAO.deleteCommentProduct(commentProductId);
	}
}
