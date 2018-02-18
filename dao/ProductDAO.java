package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import connection.ConnectionFactory;
import model.Product;

public class ProductDAO extends AbstractDAO<Product>{
	public static final int U_STOCK=3;
	
	/**
	 * Return a list of all the understock products
	 * 
	 * @return the list of all the understock products
	 * @throws Exception
	 */
	public List<Product> getUnderstock() throws Exception{
		String query="Select * from Product where stock<"+U_STOCK;
		Connection con=null;
		PreparedStatement pS=null;
		ResultSet rS=null;
		con=ConnectionFactory.getConnection();
		try {
			pS = con.prepareStatement(query);
			rS = pS.executeQuery();

			return createObjects(rS);
		} catch (Exception e) {
			throw e;
		} finally{
			ConnectionFactory.close(con);
			ConnectionFactory.close(pS);
			ConnectionFactory.close(rS);
		}
	}
	
	/**
	 * Return a list of Product objects filtered by some criteria
	 * 
	 * @param field the field by which the filtering is done
	 * @param c < or >
	 * @param filter the value by which the filtering is done
	 * @return
	 * @throws Exception
	 */
	public List<Product> filterBy(String field, char c, int filter) throws Exception{
		String query="Select * from Product where "+field+c+filter;
		Connection con=null;
		PreparedStatement pS=null;
		ResultSet rS=null;
		con=ConnectionFactory.getConnection();
		try {
			pS = con.prepareStatement(query);
			rS = pS.executeQuery();

			return createObjects(rS);
		} catch (Exception e) {
			throw e;
		} finally{
			ConnectionFactory.close(con);
			ConnectionFactory.close(pS);
			ConnectionFactory.close(rS);
		}
	}
	
	/**
	 * Return the Product object with the given name
	 * 
	 * @param name the name to be searched for
	 * @return the Product with the given name
	 * @throws Exception
	 */
	public Product findByName(String name) throws Exception{
		String query="Select * from Product where name="+name;
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
