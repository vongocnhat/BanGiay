package model.bo;

import java.util.ArrayList;

import model.bean.Favorites;
import model.dao.FavoritesDAO;


public class FavoritesBO {
	FavoritesDAO favoritesDAO = new FavoritesDAO();
	
	public ArrayList<Favorites> getlistFavorites() {
		return favoritesDAO.getListFavorites();
	}
	
	public ArrayList<Favorites> getListFavoritesProductDetailId(int productId, String userName) {
		return favoritesDAO.getListFavorites(productId, userName);
	}
	///===========================
	public ArrayList<Favorites> getListFavorites(String userName) {
		return favoritesDAO.getListFavorites(userName);
	}
	
	public void insertFavorites(Favorites favorites) {
		favoritesDAO.insertFavorites(favorites);
	}
	
	public void deleteFavorites(Favorites favorites) {
		favoritesDAO.deleteFavorites(favorites);
	}
}
