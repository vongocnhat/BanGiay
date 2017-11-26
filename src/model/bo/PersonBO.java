package model.bo;

import java.util.ArrayList;

import form.PersonForm;
import model.bean.Person;
import model.dao.PersonDAO;

public class PersonBO {
	private PersonDAO personDAO = new PersonDAO();

	public ArrayList<Person> getListPerson(int type) {
		return personDAO.getListPerson(type);
	}

	public boolean checkLogin(String userName, String password, int type) {
		return personDAO.checkLogin(userName, password,type);
	}

	public void updatePerson(PersonForm person, String typeUpdate) {
		personDAO.updatePerson(person, typeUpdate);
	}
	
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}
	

	public Person getPerson(String userName) {
		return personDAO.getPerson(userName);
	}

	public void deletePerson(String userName) {
		personDAO.deletePerson(userName);
	}
	//dung
	public boolean checkLoginCustomer(String userName, String passWord){
		return personDAO.checkLoginCustomer(userName, passWord);
	}
	
	public boolean checkUserName(String userName) {
		return personDAO.checkUserName(userName);
	}

	public void insertPerson(Person person) {
		personDAO.insertPerson(person);
	}
}
