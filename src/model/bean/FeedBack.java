package model.bean;

import java.sql.Date;

public class FeedBack {
	private int feedBackId;
	private String contentFeedBack;
	private String name;
	private String email;
	private String createdday;
	public FeedBack() {
		super();
	}
	public FeedBack(int feedBackId, String contentFeedBack, String name,
			String email, String createdday) {
		super();
		this.feedBackId = feedBackId;
		this.contentFeedBack = contentFeedBack;
		this.name = name;
		this.email = email;
		this.createdday = createdday;
	}
	public int getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}
	public String getContentFeedBack() {
		return contentFeedBack;
	}
	public void setContentFeedBack(String contentFeedBack) {
		this.contentFeedBack = contentFeedBack;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreatedday() {
		return createdday;
	}
	public void setCreatedday(String string) {
		this.createdday = string;
	}
}
