package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectionFactory;
import model.Category;

public class CategoryDAO extends AbstractDAO<Category>{
	
	/**
	 * Return the Category object with the given name
	 * 
	 * @param name the name to be searched for
	 * @return the Category with the given name
	 * @throws Exception
	 */
	public Category findByName(String name) throws Exception{
		String query="Select * from Category where name=\'"+name+"\'";
		Connection con=null;
		PreparedStatement pS=null;
		ResultSet rS=null;
		con=ConnectionFactory.getConnection();
		try {
			pS = con.prepareStatement(query);
			rS = pS.executeQuery();

			return createObjects(rS).get(0);
		} catch (Exception e) {
			throw e;
		} finally{
			ConnectionFactory.close(con);
			ConnectionFactory.close(pS);
			ConnectionFactory.close(rS);
		}
	}
}
