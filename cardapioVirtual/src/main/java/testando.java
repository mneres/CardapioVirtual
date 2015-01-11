import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cardapio.virtual.model.beans.User;
import org.cardapio.virtual.model.db.dao.UserDao;
import org.cardapio.virtual.model.db.dao.UserDaoJPA;
import org.cardapio.virtual.model.manager.LoginManager;

public class testando {
	
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public static void main(String args[]){

		/*SuggestionDao dao = new SuggestionDaoJPA();
		
		Suggestion s = new Suggestion();
		s.setTitle("teste");
		s.setDescription("description is here");
		s.setSugDate(new Date());
		s.setEmail("marcelo.neres@gmail.com");
		
		dao.add(s);*/
		
		UserDao dao = new UserDaoJPA();
		User us = new User();
		us = dao.findByEmail("juca");
		System.out.println(us.getEmail() + " ------- " + us.getPassword());
		
		LoginManager manager = new LoginManager();
		if(manager.verifyUser("123", us)){
			System.out.println("Banana");
		}else{
			System.out.println("Maça");
		}
	}
}
