package org.cardapio.virtual.model.manager;

import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.User;

@Named
public class FranchiseLoginManager {
	public static final String FRANCHISE_EMAIL = "franchiseEmail";
	public static final String FRANCHISE_ID = "franchiseId";

	public void login(Franchise f, HttpSession session) {
		session.setAttribute(FRANCHISE_ID, f.getId());
		session.setAttribute(FRANCHISE_EMAIL, f.getEmail());
	}

	public void logout(HttpSession session) {
		session.removeAttribute(FRANCHISE_ID);
		session.removeAttribute(FRANCHISE_EMAIL);
	}

	public boolean verifyUser(String password, Franchise f) {
		//String encrypted = EncryptUtils.encrypt(password);
		return f.getPassword().equals(password);
	}
}
