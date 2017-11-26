package model.bean;

import java.util.ArrayList;

public class ProductDetail extends Product {
	private int productDetailId;
	private int productId;
	private String image;
	private String image2;
	private String image3;
	private String color;
	private ArrayList<ProductDetailSQ> listProductDetailSQ;

	public ProductDetail(int productId, String image, String image2, String image3, String color) {
		super();
		this.productId = productId;
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
		this.color = color;
	}

	public ProductDetail(int productDetailId, int productId, String image, String image2, String image3, String color) {
		super();
		this.productDetailId = productDetailId;
		this.productId = productId;
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
		this.color = color;
	}
	
	public ProductDetail() {
		
	}
	
	

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<ProductDetailSQ> getListProductDetailSQ() {
		return listProductDetailSQ;
	}

	public void setListProductDetailSQ(ArrayList<ProductDetailSQ> listProductDetailSQ) {
		this.listProductDetailSQ = listProductDetailSQ;
	}
}
