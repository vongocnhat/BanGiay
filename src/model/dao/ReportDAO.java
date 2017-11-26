package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Report;

public class ReportDAO {
	MyDatabase db = new MyDatabase();
	public ArrayList<Report> getListReport(String from, String to, String groupBy) {
		String sql;
		if("year".equalsIgnoreCase(groupBy))
			sql = "SELECT YEAR(Createdday) AS YEAR, SUM(TotalQuantity) AS TotalQuantity, SUM(TotalPrice) AS TotalPrice FROM `Order` WHERE Createdday >= '"+from+"' AND Createdday <= '"+to+"' GROUP BY YEAR ORDER BY YEAR";
		else
			sql = "SELECT YEAR(Createdday) AS YEAR, MONTH(Createdday) AS MONTH, SUM(TotalQuantity) AS TotalQuantity, SUM(TotalPrice) AS TotalPrice FROM `Order` WHERE Createdday >= '"+from+"' AND Createdday <= '"+to+"' GROUP BY MONTH, YEAR ORDER BY YEAR";
		ResultSet rs = db.selectTable(sql);
		ArrayList<Report> list = new ArrayList<Report>();
		try {
			if("year".equalsIgnoreCase(groupBy))
				while(rs.next()){
					String year = rs.getString("YEAR");
					int totalQuantity = rs.getInt("TotalQuantity");
					long totalPrice = rs.getLong("TotalPrice");
					Report report = new Report(year, totalQuantity, totalPrice);
					list.add(report);
				}
			else
				while(rs.next()){
					String month = rs.getString("MONTH");
					String year = rs.getString("YEAR");
					int totalQuantity = rs.getInt("TotalQuantity");
					long totalPrice = rs.getLong("TotalPrice");
					Report report = new Report(month, year, totalQuantity, totalPrice);
					list.add(report);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
