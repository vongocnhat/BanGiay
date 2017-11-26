package model.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.sql.Connection;

public class MyDatabase {
	Connection conn = null;
	Statement stmt;
	//Mở kết nối
	public MyDatabase(){
		createConnect();
	}
	public void createConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BanGiay?useUnicode=true&characterEncoding=utf-8", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Đóng kết nối
	public void close() {
//		try {
//			conn.close();
//			System.out.println("Da dong ket noi...");
//		} catch (SQLException e) {
//			System.out.println("Loi dong ket noi...");
//			e.printStackTrace();
//		}
	}

	// Xem bảng dữ liệu
	public ResultSet selectTable(String sSql){
		stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			return stmt.executeQuery(sSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		close();
		return null;
	}
	
	// Thực thi lệnh sql
	public void updateTable(String sSql){
		Statement stmt = null;
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		close();
	}
/*	public static void main(String args) {

		MyDatabase db=new MyDatabase();
		System.out.println(db);
	}*/
}
