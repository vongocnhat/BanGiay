package model.bo;

import java.util.ArrayList;

import model.bean.Account;
import model.dao.AccountDAO;


public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();
	
	public ArrayList<Account> getlistAccount() {
		return accountDAO.getListAccount();
	}
	
	public void insertAccount(Account account) {
		accountDAO.insertAccount(account);
	}
	
	public void updateAccount(Account account) {
		accountDAO.updateAccount(account);
	}
	
	public void deleteAccount(String userName) {
		accountDAO.deleteAccount(userName);
	}
	
	public boolean checkLogin(String userName, String passWord) {
		return accountDAO.checkLogin(userName, passWord);
	}
}
