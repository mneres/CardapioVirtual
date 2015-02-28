import java.util.ArrayList;
import java.util.List;

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
	
	public static void main(String args[]) throws Exception{

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
		p.setDescription("X-Bacon");
		p.setIngredients("Queijo, Bacon, Salada");
		p.setPrice(10);

		m.getProduct().add(p);
		menuDao.add(m);
		
		m.setName("Bebidas");
		m.setFranchise(f);
		p.setDescription("Coca");
		p.setIngredients("250 ML");
		p.setPrice(5);

		m.getProduct().add(p);
		menuDao.add(m);		
		
		
		MenuDao menuDao = new MenuDaoJPA();
		
		FranchiseDao fraDao = new FranchiseDaoJPA();
		Franchise f = fraDao.listById((long) 61);
		
		Menu m = new Menu();
		m.setId((long)50);
		m.setName("Lanches");
		m.setFranchise(f);
		
		Product p = new Product();
		p.setDescription("Teste");
		p.setIngredients("Queijo, Bacon, Salada");
		p.setPrice(10);

		m.getProduct().add(p);
		
		menuDao.add(m);
		
		Product p = new Product();
		p.setDescription("X-Bacon");
		p.setIngredients("Queijo, Bacon, Salada");
		p.setPrice(10);

		m.getProduct().add(p);
		menuDao.add(m);

		FranchiseDao fraDao = new FranchiseDaoJPA();
		Franchise f = fraDao.listById((long) 61);
		
		MenuDao menuDao = new MenuDaoJPA();
		List<Menu> t = menuDao.listbyFranchise(f);
		for(Menu i:t){
			System.out.println(i.getName());
			for (Product p : i.getProduct()){
				System.out.println(p.getIngredients());
			}
		}
		System.out.println("FIM");
		
		
		GeoApiContext context = new KeyGoogle().getContext();
		
	    DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
	            .origins("12238-470")
	            .destinations("12232-234")
	            .mode(TravelMode.DRIVING)
	            .language("pt-BR")
	            .await();
	    
	    for (DistanceMatrixRow row : matrix.rows) {
	        for (DistanceMatrixElement cell : row.elements) {	
	        	  System.out.println(cell.duration);
	        	  System.out.println(cell.distance);
	        	  System.out.println(cell.status);
	        }
	    }*/
		
		
		
		
		//ADICIONAR PRODUTO
		MenuDao menuDao = new MenuDaoJPA();
		
		FranchiseDao fraDao = new FranchiseDaoJPA();
		Franchise f = fraDao.listById((long) 61);
		
		Menu m = new Menu();
		m.setId((long)50);
		m.setName("Lanches");
		m.setFranchise(f);
		
		Product p = new Product();
		p.setDescription("Teste");
		p.setIngredients("Queijo, Bacon, Salada");
		p.setPrice(10);

		m.getProduct().add(p);
		
		menuDao.add(m);
		
		//EDITAR PRODUTO
		
		
		//REMOVER PRODUTO
		long idProd = 64;
		
		List<Product> lst = new ArrayList<Product>();
		
		for(Product i : m.getProduct()){
			if(i.getId()!=idProd){
				lst.add(i);
			}
		}
		m.getProduct().clear();
		m.getProduct().addAll(lst);
		
		menuDao.add(m);	
		ProductDao prodDao = new ProductDaoJPA();
		prodDao.remove(idProd);
		
	}
}
