package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Account;


public class AccountDAO {
	public boolean checkLogin(String userName, String passWord) {
		String sSql = String.format("SELECT UserName From Account WHERE UserName = '%s' AND PassWord = '%s' ",
				userName,
				passWord);
		
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		db.close();
		
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public ArrayList<Account> getListAccount() {
		String sSql = "SELECT * FROM Account";
		MyDatabase db = new MyDatabase();
		ResultSet rs = db.selectTable(sSql);
		
		ArrayList<Account> list = new ArrayList<Account>();
		try {
			while(rs.next()){
				Account account = new Account();
				
				account.setUserName(rs.getString("userName"));
				account.setPassword(rs.getString("passWord"));
				account.setType(rs.getInt("type"));
				account.setStatus(rs.getBoolean("status"));
								
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm
	public void insertAccount(Account account){
		String sSql = String.format("INSERT INTO Account "
				+ "(UserName ,Password ,Type ,Status)"
				+ " VALUES ('%s', '%s', '%s', %s) ", 
				account.getUserName(),
				account.getPassword(),
				account.getType(),
				account.getStatus() );
		
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
	//	Sửa
	public void updateAccount(Account account){
		String sSql = String.format(" UPDATE Account "
				+"   SET Password = '%s' "
				+"      ,Type = '%s' "
				+"      ,Status = %s "
				+" WHERE UserName = '%s' " ,
				account.getPassword(),
				account.getType(),
				account.getStatus(),
				account.getUserName() );
		
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
	// Xóa
	public void deleteAccount(String userName){
		String sSql = String.format("DELETE FROM Account WHERE UserName = '%s' ",userName );
		MyDatabase db = new MyDatabase();
		db.updateTable(sSql);
		db.close();
	}
}
