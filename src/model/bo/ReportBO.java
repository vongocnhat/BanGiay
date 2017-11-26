package model.bo;

import java.util.ArrayList;

import model.bean.Report;
import model.dao.ReportDAO;

public class ReportBO {
	public ArrayList<Report> getListReport(String from, String to, String groupBy){
		return new ReportDAO().getListReport(from, to, groupBy);
	}
}
