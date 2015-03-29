package org.cardapio.virtual.model.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cardapio.virtual.model.beans.Company;
import org.cardapio.virtual.model.beans.Product;

public class RecomendationDaoJDBC implements RecomendationDao{
	public List<Product> recomendation(Long id_user){
		List<Product> lst = new ArrayList<Product>();
		
		Connection con = new ConnectionFactory().createConnection();
		String sql = new String(
				"select p.*\n" +
						"  from (select id_product, max(peso) as peso\n" + 
						"          from (select anot_user.id_product,\n" + 
						"                       case\n" + 
						"                         when upper(user_recom.neighborhood) =\n" + 
						"                              upper(anot_user.neighborhood) then\n" + 
						"                          1\n" + 
						"                         else\n" + 
						"                          0\n" + 
						"                       end as peso\n" + 
						"                  from (select u.*,\n" + 
						"                               upper(ad.neighborhood) as neighborhood,\n" + 
						"                               upper(ad.city) as CITY\n" + 
						"                          from users u\n" + 
						"                          left join address ad on u.id_address = ad.id_address\n" + 
						"                         where u.id_user = " + id_user + ") user_recom\n" + 
						"                 inner join (select t.id_product,\n" + 
						"                                   upper(a.neighborhood) as neighborhood,\n" + 
						"                                   upper(a.city) as CITY\n" + 
						"                              from evaluation_product t\n" + 
						"                              left join users u on t.id_user = u.id_user\n" + 
						"                              left join address a on u.id_address =\n" + 
						"                                                     a.id_address\n" + 
						"                             where u.id_user <> " + id_user + "\n" + 
						"                             group by t.id_product, a.neighborhood, a.city) anot_user on user_recom.city =\n" + 
						"                                                                                         anot_user.city\n" + 
						"                union all\n" + 
						"                SELECT id_product, 2 as peso\n" + 
						"                  FROM (select avals.description as us_descr,\n" + 
						"                               avals.id_product as us_prod,\n" + 
						"                               p.*\n" + 
						"                          from (select upper(p.description) as description,\n" + 
						"                                       p.id_product\n" + 
						"                                  from evaluation_product t\n" + 
						"                                  left join product p on t.id_product =\n" + 
						"                                                         p.id_product\n" + 
						"                                 where t.id_user = " + id_user + ") avals,\n" + 
						"                               (select upper(p.description) as description,\n" + 
						"                                       p.id_product\n" + 
						"                                  from product p) p\n" + 
						"                         where avals.description like\n" + 
						"                               '%' || p.description || '%'\n" + 
						"                            or p.description like\n" + 
						"                               '%' || avals.description || '%')\n" + 
						"                 WHERE us_prod <> id_product)\n" + 
						"         group by id_product\n" + 
						"         order by 2 desc) recomendation\n" + 
						"  left join product p on recomendation.id_product = p.id_product order by peso desc");
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getLong("id_product"));
				p.setDescription(rs.getString("description"));
				p.setIngredients(rs.getString("ingredients"));
				p.setPrice(rs.getDouble("price"));
				lst.add(p);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return lst;
	}
	
	public Company CompanylistByProduct(Long id_prod){
		Connection con = new ConnectionFactory().createConnection();
		Company c = new Company();
		String sql = new String(
				"select c.*\n" +
						"from product p\n" + 
						"left join menu_product mp on p.id_product = mp.id_product\n" + 
						"left join menu m on mp.id_menu = m.id_menu\n" + 
						"left join franchise f on m.id_franchise = f.id_franchise\n" + 
						"left join company c on f.company_id_company = c.id_company\n" + 
						"where p.id_product = " + id_prod );
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				c.setId(rs.getLong("id_company"));
				c.setCompanyName(rs.getString("COMPANY_NAME"));
				c.setImprint(rs.getString("IMPRINT"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;	
	}
}

