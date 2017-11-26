package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import model.bean.Report;

public class ReportForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String month;
	private String year;
	private int totalQuantity;
	private long totalPrice;

	private String from, to, groupBy;

	private ArrayList<Report> listReport;

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

	public ArrayList<Report> getListReport() {
		return listReport;
	}

	public void setListReport(ArrayList<Report> listReport) {
		this.listReport = listReport;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

}
