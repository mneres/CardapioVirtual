package org.cardapio.virtual.model.manager;

import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.cardapio.virtual.model.beans.service.Cep;

@Named
public class AddressManager {
	public static final String ADDRESS_CEP = "AddressCep";
	public static final String ADDRESS_BAIRRO = "AddressBairro";
	public static final String ADDRESS_LOCALIDADE = "AddressLocalidade";
	public static final String ADDRESS_LOGRADOURO = "AddressLogradouro";
	public static final String ADDRESS_NUMERO = "AddressNumero";

	public void saveAddress(Cep cep, int number, HttpSession session) {
		session.setAttribute(ADDRESS_CEP, cep.getCep());
		session.setAttribute(ADDRESS_BAIRRO, cep.getBairro());
		session.setAttribute(ADDRESS_LOCALIDADE, cep.getLocalidade());
		session.setAttribute(ADDRESS_LOGRADOURO, cep.getLogradouro());
		session.setAttribute(ADDRESS_NUMERO, number);
	}

	public void forgetAddress(HttpSession session) {
		session.removeAttribute(ADDRESS_CEP);
		session.removeAttribute(ADDRESS_BAIRRO);
		session.removeAttribute(ADDRESS_LOCALIDADE);
		session.removeAttribute(ADDRESS_LOGRADOURO);
		session.removeAttribute(ADDRESS_NUMERO);
	}
}
