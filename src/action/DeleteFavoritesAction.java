package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Favorites;
import model.bean.Person;
import model.bo.FavoritesBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.FavoritesForm;

public class DeleteFavoritesAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		FavoritesForm favoritesForm = (FavoritesForm) form;
		
		Favorites favorites = new Favorites();

		favorites.setProductId(favoritesForm.getProductId());
		
		Person person = (Person) request.getSession().getAttribute("person");
		String userName = null;
		if(person!=null)
		{
			userName = person.getUserName();
		}
		favorites.setUserName(userName);
			
		new FavoritesBO().deleteFavorites(favorites);
		
		//return mapping.findForward("thanhCong");
		return super.execute(mapping, form, request, response);
	}
}
