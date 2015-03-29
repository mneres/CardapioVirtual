package org.cardapio.virtual.model.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection createConnection(){
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","projeto","root");
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return con;	
	}
}
