package model.bean;

public class Report {
	private String month;
	private String year;
	private int totalQuantity;
	private long totalPrice;

	public Report(String year, int totalQuantity, long totalPrice) {
		super();
		this.year = year;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}
	
	public Report(String month, String year, int totalQuantity, long totalPrice) {
		super();
		this.month = month;
		this.year = year;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

}