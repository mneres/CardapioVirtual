package org.cardapio.virtual.model.manager;

import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.cardapio.virtual.model.beans.User;

@Named
public class LoginManager {
	public static final String USER_EMAIL = "userName";
	public static final String USER_ID = "userId";

	public void login(User user, HttpSession session) {
		session.setAttribute(USER_ID, user.getId());
		session.setAttribute(USER_EMAIL, user.getName());
	}

	public void logout(HttpSession session) {
		session.removeAttribute(USER_ID);
		session.removeAttribute(USER_EMAIL);
	}

	public boolean verifyUser(String password, User user) {
		//String encrypted = EncryptUtils.encrypt(password);
		return user.getPassword().equals(password);
	}
}
