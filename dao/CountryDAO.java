package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectionFactory;
import model.Country;

public class CountryDAO extends AbstractDAO<Country>{
	
	/**
	 * Return the Country object with the given name
	 * 
	 * @param name the name to be searched for
	 * @return the Country with the given name
	 * @throws Exception
	 */
	public Country findByName(String name) throws Exception{
		String query="Select * from Country where name=\'"+name+"\'";
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
