package model.bo;

import java.util.ArrayList;

import model.bean.Category;
import model.dao.CategoryDAO;

public class CategoryBO {
	CategoryDAO categoryDAO = new CategoryDAO();
	
	public ArrayList<Category> getlistCategory() {
		return categoryDAO.getListCategory();
	}
	
	public void insertCategory(Category category) {
		categoryDAO.insertCategory(category);
	}
	
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}
	
	public void deleteCategory(int categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}
	public Category getCategory(int categoryId) {
		return categoryDAO.getCategory(categoryId);
	}
}
