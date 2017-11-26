package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Favorites;
import model.bo.FavoritesBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.FavoritesForm;

public class AddFavoritesAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		FavoritesForm favoritesForm = (FavoritesForm) form;

		Favorites favorites = new Favorites();

		favorites.setProductId(favoritesForm.getProductId());
		favorites.setUserName(favoritesForm.getUserName());
		
		new FavoritesBO().insertFavorites(favorites);
		
		return super.execute(mapping, form, request, response);
	}
}
