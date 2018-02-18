package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectionFactory;
import model.Product_Order;

public class Product_OrderDAO extends AbstractDAO<Product_Order>{
	
	/**
	 * Delete from the database all the entries with the given product_id
	 * 
	 * @param id the product_id to be deleted by
	 * @throws Exception
	 */
	public void deleteByProduct(int id) throws Exception{
		String deleteQuery="Delete from Product_Order where Product_ID=\'"+id+"\'";
		executeUpdate(deleteQuery);
	}
	
	/**
	 * Delete from the database all the entries with the given client_id
	 * 
	 * @param id the client_id to be deleted by
	 * @throws Exception
	 */
	public void deleteByClient(int id) throws Exception{
		String deleteQuery="Delete from Product_Order where Client_ID=\'"+id+"\'";
		executeUpdate(deleteQuery);
	}
	
	/**
	 * Return the last inserted product_order
	 * 
	 * @return the last inserted product_order
	 * @throws Exception
	 */
	public Product_Order getfLastInsert() throws Exception{
		String query="Select * from Product_Order where product_order_id in "
				+ "(Select max(product_order_id) from Product_Order)";
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
