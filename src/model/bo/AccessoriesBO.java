package model.bo;

import java.util.ArrayList;

import model.bean.Accessories;
import model.dao.AccessoriesDAO;

public class AccessoriesBO {
	AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
	
	public ArrayList<Accessories> getlistAccessories() {
		return accessoriesDAO.getListAccessories();
	}
	
	public ArrayList<Accessories> getListAccessories(int accessoriesId) {
		return accessoriesDAO.getListAccessories(accessoriesId);
	}
	
	public void insertAccessories(Accessories accessories) {
		accessoriesDAO.insertAccessories(accessories);
	}
	
	public void updateAccessories(Accessories accessories) {
		accessoriesDAO.updateAccessories(accessories);
	}
	
	public void deleteAccessories(String accessoriesId) {
		accessoriesDAO.deleteAccessories(accessoriesId);
	}
}
