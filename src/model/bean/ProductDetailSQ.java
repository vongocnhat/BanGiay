package model.bean;

public class ProductDetailSQ extends ProductDetail {
	

	public ProductDetailSQ() {
		
	}
	
	private int productDetailSQId;
	private int productDetailId;
	private float size;
	private int quantity;

	public int getProductDetailSQId() {
		return productDetailSQId;
	}

	public void setProductDetailSQId(int productDetailSQId) {
		this.productDetailSQId = productDetailSQId;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
