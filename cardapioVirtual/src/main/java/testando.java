import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.beans.Product;
import org.cardapio.virtual.model.db.dao.FranchiseDao;
import org.cardapio.virtual.model.db.dao.FranchiseDaoJPA;
import org.cardapio.virtual.model.db.dao.MenuDao;
import org.cardapio.virtual.model.db.dao.MenuDaoJPA;
import org.cardapio.virtual.model.db.dao.ProductDao;
import org.cardapio.virtual.model.db.dao.ProductDaoJPA;

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
		
		/*UserDao dao = new UserDaoJPA();
		User us = new User();
		us = dao.findByEmail("juca");
		System.out.println(us.getEmail() + " ------- " + us.getPassword());
		
		LoginManager manager = new LoginManager();
		if(manager.verifyUser("123", us)){
			System.out.println("Banana");
		}else{
			System.out.println("Maça");
		}
		
		FranchiseDao franDao = new FranchiseDaoJPA();
		
		Company c = new Company();
		c.setCompanyName("MarceloCompany");
		c.setImprint("MarceloCompanyLogo");
		franDao.addCompany(c);
		
		Franchise f = new Franchise();
		f.setCompany(c);
    	f.setCnpj("12345678912345");
		f.setPassword("123");
		f.setPhone(33228928);
		
		Address a = new Address();
		a.setStreet("kkkkkkk");
		a.setAd_number(1);
		a.setCity("sanjaa");
		a.setCode(12234321);
		a.setNeighborhood("bairro");
		
		f.setAddress(a);
		
		franDao.addFranchise(f);

		List<Franchise> l = franDao.listFranchiseByTypeOrName("Pizza","MarceloCompany5");
		for(Object i : l){
			Franchise fa = (Franchise) i;
			System.out.println(fa.getId());
			System.out.println(fa.getCompany());
			System.out.println(fa.getPhone());
			System.out.println(fa.getSecondPhone());
			System.out.println(fa.getCnpj());
			System.out.println(fa.getAddress());
		}
		
		MenuDao menuDao = new MenuDaoJPA();
		
		FranchiseDao fraDao = new FranchiseDaoJPA();
		Franchise f = fraDao.listById((long) 61);
		
		Menu m = new Menu();
		m.setName("Lanches");
		m.setFranchise(f);
		
		Product p = new Product();
		p.setDescription("X-Calafrango");
		p.setIngredients("Frango, Calabresa, Queijo");
		p.setPrice(12.5);

		m.getProduct().add(p);
		menuDao.add(m);*/
		
		MenuDao menuDao = new MenuDaoJPA();
		List<Menu> t = menuDao.list();
		for(Menu i:t){
			System.out.println(i.getName());
			System.out.println(i.getFranchise());
			for (Product p : i.getProduct()){
				System.out.println(p.getIngredients());
			}
		}
	}
}
