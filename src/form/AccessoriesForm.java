package form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Accessories;

public class AccessoriesForm extends ActionForm{
	private int accessoriesId;
	private String accessoriesName;
	private double price;
	private int size;
	private int quantity;
	private String image;
	private String color;
	private String description;
	private ArrayList<Accessories> listAccessories;
	public int getAccessoriesId() {
		return accessoriesId;
	}
	public void setAccessoriesId(int accessoriesId) {
		this.accessoriesId = accessoriesId;
	}
	public String getAccessoriesName() {
		return accessoriesName;
	}
	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Accessories> getListAccessories() {
		return listAccessories;
	}
	public void setListAccessories(ArrayList<Accessories> listAccessories) {
		this.listAccessories = listAccessories;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}
	
	
}
