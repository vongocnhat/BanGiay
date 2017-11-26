package model.bean;

import java.sql.Timestamp;

public class CommentProduct {
	private int commentId;
	private int commentIdParent;
	private int levelCmt;
	private int productId;
	private String userName;
	private String contentConmment;
	private Timestamp createdDay;
	
	public CommentProduct(int commentId, int commentIdParent, int levelCmt,
			int productId, String userName, String contentConmment,
			Timestamp createdDay) {
		super();
		this.commentId = commentId;
		this.commentIdParent = commentIdParent;
		this.levelCmt = levelCmt;
		this.productId = productId;
		this.userName = userName;
		this.contentConmment = contentConmment;
		this.createdDay = createdDay;
	}
	public CommentProduct() {
		super();
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentIdParent() {
		return commentIdParent;
	}
	public void setCommentIdParent(int commentIdParent) {
		this.commentIdParent = commentIdParent;
	}
	public int getLevelCmt() {
		return levelCmt;
	}
	public void setLevelCmt(int levelCmt) {
		this.levelCmt = levelCmt;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContentConmment() {
		return contentConmment;
	}
	public void setContentConmment(String contentConmment) {
		this.contentConmment = contentConmment;
	}
	public Timestamp getCreatedDay() {
		return createdDay;
	}
	public void setCreatedDay(Timestamp createdDay) {
		this.createdDay = createdDay;
	}
	@Override
	public String toString() {
		return "CommentProduct [commentId=" + commentId + ", commentIdParent=" + commentIdParent + ", levelCmt=" + levelCmt
				+ ", productId=" + productId + ", userName=" + userName + ", contentConmment=" + contentConmment
				+ ", createdDay=" + createdDay + "]";
	}
}
