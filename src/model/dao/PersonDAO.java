package model.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import common.StringProcess;
import form.PersonForm;
import model.bean.Person;
import model.bean.Product;

public class PersonDAO {
	private MyDatabase db = new MyDatabase();

	public ArrayList<Person> getListPerson(int type) {
		ArrayList<Person> listPerson = new ArrayList<Person>();
		Person person = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ACCOUNT a LEFT OUTER JOIN Person p ON a.UserName = p.UserName WHERE a.Type = '"
				+ type + "'";
		rs = db.selectTable(sql);
		try {
			while (rs.next()) {
				person = new Person();
				person.setUserName(rs.getString("UserName"));
				person.setPassword(rs.getString("Password"));
				person.setType(rs.getInt("Type"));
				person.setStatus(rs.getBoolean("Status"));
				person.setFullName(rs.getString("FullName"));
				person.setGender(rs.getString("Gender"));
				person.setBirthday(rs.getDate("BirthDay"));
				person.setAddress(rs.getString("Address"));
				person.setPhone(rs.getString("Phone"));
				person.setEmail(rs.getString("Email"));
				person.setCreatedday(rs.getDate("Createdday"));
				listPerson.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPerson;
	}

	public boolean checkLogin(String userName, String password, int type) {
		ResultSet rs = null;
		String sql = "SELECT * FROM ACCOUNT WHERE Type = " + type + " AND UserName = '" + userName + "' AND password = '" + password + "' AND Status = 1 OR Type = 2 AND UserName = '" + userName + "' AND password = '" + password + "'";
		rs = db.selectTable(sql);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Person getPerson(String userName) {
		Person person = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ACCOUNT a LEFT OUTER JOIN Person p ON a.UserName = p.UserName WHERE a.UserName = '"
				+ userName + "'";
		rs = db.selectTable(sql);
		try {

			if (rs.next()) {
				person = new Person();
				person.setUserName(rs.getString("UserName"));
				person.setPassword(rs.getString("Password"));
				person.setType(rs.getInt("Type"));
				person.setStatus(rs.getBoolean("Status"));
				person.setFullName(rs.getString("FullName"));
				person.setGender(rs.getString("Gender"));
				person.setBirthday(rs.getDate("BirthDay"));
				person.setAddress(rs.getString("Address"));
				person.setPhone(rs.getString("Phone"));
				person.setEmail(rs.getString("Email"));
				person.setCreatedday(rs.getDate("createdday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

	public void updatePerson(PersonForm person, String typeUpdate) {
		String sql = "";
		if (typeUpdate.equals("add")) {
			try {
				sql = String.format("INSERT INTO Account VALUES('%s', '%s', '%s', %s)", person.getUserName(),
						StringProcess.encrypt(person.getPassword()), person.getType(), person.getStatus())
						+ String.format("INSERT INTO Person VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s)",
								person.getUserName(), person.getFullName(), person.getGender(), person.getBirthday(),
								person.getAddress(), person.getPhone(), person.getEmail(), "default");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (person.getPassword().equals(""))
				sql = String.format("UPDATE Account SET Type = %s, Status = %s WHERE UserName = '%s'", person.getType(),
						person.getStatus(), person.getUserName());
			else
				try {
					sql = String.format(
							"UPDATE Account SET Password = '%s', Type = %s, Status = %s WHERE UserName = '%s'",
							StringProcess.encrypt(person.getPassword()), person.getType(), person.getStatus(),
							person.getUserName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			sql += String.format(
					" UPDATE Person SET FullName = '%s', Gender = '%s', Birthday = '%s', Address = '%s', Phone = '%s', Email = '%s' WHERE UserName = '%s'",
					person.getFullName(), person.getGender(), person.getBirthday(), person.getAddress(),
					person.getPhone(), person.getEmail(), person.getUserName());
		}
		db.updateTable(sql);
	}
	// dungnv 14-8
	public void updatePerson(Person person) {
		String sSqlAcc = null;
		try {
			sSqlAcc = String.format("UPDATE Account SET Password = '%s', Type = %s, Status = %s WHERE UserName = '%s'",
								StringProcess.encrypt(person.getPassword()), person.getType(), person.getStatus(),
								person.getUserName() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.updateTable(sSqlAcc);
		String sSqlPerson = String.format(" UPDATE Person SET FullName = '%s', Gender = '%s', Birthday = '%s', Address = '%s', Phone = '%s', Email = '%s' WHERE UserName = '%s'",
				person.getFullName(), person.getGender(), person.getBirthday(), person.getAddress(),
				person.getPhone(), person.getEmail(), person.getUserName());
		db.updateTable(sSqlPerson);
	}

	public void deletePerson(String userName) {
		String sql = String.format("DELETE FROM Person WHERE UserName = '%s'", userName)
				+ String.format("DELETE FROM Account WHERE UserName = '%s'", userName);
		db.updateTable(sql);
	}
	//dung
	public boolean checkLoginCustomer(String userName, String passWord) {
		String sSql = "SELECT * FROM ACCOUNT WHERE Type = 0 AND UserName = '" + userName + "' AND PassWord = '"+ passWord +"' ";
		
		ResultSet rs = db.selectTable(sSql);
		
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUserName(String userName) {
		
		String sSql = "SELECT * FROM ACCOUNT WHERE UserName = '" + userName + "' ";
		
		ResultSet rs = db.selectTable(sSql);
		
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//thêm
	public void insertPerson(Person person){
		String sSql1 = String.format("INSERT INTO Account "
				+ "(UserName ,Password ,Type ,Status) "
				+ " VALUES ('%s', '%s', '%s', %s) ", 
				person.getUserName(),
				person.getPassword(),
				person.getType(),
				person.getStatus());
		
		MyDatabase db1 = new MyDatabase();
		db1.updateTable(sSql1);
		db1.close();
		
		
		String sSql = String.format("INSERT INTO Person "
				+ "(UserName ,FullName ,Gender ,Birthday ,Address ,Phone ,Email, Createdday )"
				+ " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s') ", 
				person.getUserName(),
				person.getFullName(),
				person.getGender(),
				person.getBirthday(),
				person.getAddress(),
				person.getPhone(),
				person.getEmail(),
				StringProcess.getDateNow());
		db.updateTable(sSql);
		db.close();
	}
	// dungnv 14-8
	public ArrayList<Product> getListProductNumberViewed() {
		String sSql = "SELECT * FROM Product p INNER JOIN Category c ON p.CategoryId = c.CategoryId ORDER BY numberViewed DESC LIMIT 4";
		ResultSet rs = db.selectTable(sSql);
		ResultSet rs2;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			while(rs.next()){
				Product product = new Product();
				
				product.setProductId(rs.getInt("productId"));
				product.setCategoryId(rs.getInt("CategoryId"));
				product.setProductName(rs.getString("productName"));
				product.setNumberViewed(rs.getLong("numberViewed"));
				product.setNumberSeller(rs.getLong("numberSeller"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getLong("price"));
				String sql = "SELECT * FROM ProductDetail WHERE ProductId ='"+rs.getInt("productId")+"' LIMIT 1";
				rs2 = db.selectTable(sql);
				if(rs2.next())
					product.setImage(rs2.getString("Image"));
				else
					product.setImage("Sản Phẩm Này Chưa Có");
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// dungnv 14-8
	public ArrayList<Product> getListProductNumberSeller() {
		String sSql = "SELECT * FROM Product p INNER JOIN Category c ON p.CategoryId = c.CategoryId ORDER BY numberSeller DESC LIMIT 4";
		ResultSet rs = db.selectTable(sSql);
		ResultSet rs2;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			while(rs.next()){
				Product product = new Product();
				
				product.setProductId(rs.getInt("productId"));
				product.setCategoryId(rs.getInt("CategoryId"));
				product.setProductName(rs.getString("productName"));
				product.setNumberViewed(rs.getLong("numberViewed"));
				product.setNumberSeller(rs.getLong("numberSeller"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getLong("price"));
				String sql = "SELECT * FROM ProductDetail WHERE ProductId ='"+rs.getInt("productId")+"' LIMIT 1";
				rs2 = db.selectTable(sql);
				if(rs2.next())
					product.setImage(rs2.getString("Image"));
				else
					product.setImage("Sản Phẩm Này Chưa Có");
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
