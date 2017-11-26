package form;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.CommentProduct;

public class CommentProductForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int commentId;
	private int commentIdParent;
	private int levelCmt;
	private int productId;
	private String userName;
	private String contentConmment;
	private Timestamp createdDay;
	
	private String submit;
	private String action;
	
	private CommentProduct commentProduct;

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

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public CommentProduct getCommentProduct() {
		return commentProduct;
	}

	public void setCommentProduct(CommentProduct commentProduct) {
		this.commentProduct = commentProduct;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
}
