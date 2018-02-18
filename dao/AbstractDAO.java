package dao;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.*;

public abstract class AbstractDAO<T> {	
	private final Class<T> type;
	
	/**
	 * Constructor to be called when instantiating a subclass
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO(){
		type=(Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * Creates a SELECT SQL query based on the argument (or not, if the argument is null)
	 * 
	 * @param field the argument to be used in generating the query
	 * @return the generated query
	 */
	private String createSelectQuery(String field){
		if (field!=null) {
			return "SELECT * FROM " + type.getSimpleName() + " WHERE " + field + "=?";
		}
		else{
			return "SELECT * FROM " + type.getSimpleName();
		}
	}
	
	/**
	 * Returns the object from the database with the given id
	 * 
	 * @param id the id of the required object
	 * @return the object with the given id
	 * @throws Exception
	 */
	public T findByID(int id) throws Exception{
		Connection con=null;
		PreparedStatement pS=null;
		ResultSet rS=null;
		String query=createSelectQuery(type.getSimpleName()+"_ID");
		con=ConnectionFactory.getConnection();
		try {
			pS = con.prepareStatement(query);
			pS.setInt(1, id);
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

	/**
	 * Creates a list of objects from a ResulSet
	 * 
	 * @param rS the resultSet
	 * @return the list of objects
	 * @throws Exception
	 */
	protected List<T> createObjects(ResultSet rS) throws Exception{
		List<T> list=new ArrayList<T>();
		
		try {
			while(rS.next()){
				T instance=type.newInstance();
				for(Field field:type.getDeclaredFields()){
					Object value=rS.getObject(field.getName());
					PropertyDescriptor pD=new PropertyDescriptor(field.getName(), type);
					Method method=pD.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Returns all the entries from the database of this type
	 * 
	 * @return the list of all the entries
	 * @throws Exception
	 */
	public List<T> findAll() throws Exception{
		Connection con=null;
		PreparedStatement pS=null;
		ResultSet rS=null;
		String query=createSelectQuery(null);
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
	 * Inserts a new entry in the database
	 * 
	 * @param t the new entry to be inserted
	 * @throws Exception
	 */
	public void insert(T t) throws Exception{
		String insertQuery="Insert into "+type.getSimpleName()+" values (";
		try {
			Object value=null;
			for (Field field : type.getDeclaredFields()) {
				if(field.getName().equalsIgnoreCase(type.getSimpleName()+"_ID")){
					continue;
				}
				PropertyDescriptor pD = new PropertyDescriptor(field.getName(), type);
				Method method = pD.getReadMethod();
				value=method.invoke(t);
				insertQuery += "\'" + value + "\',";
			}
			insertQuery = insertQuery.substring(0, insertQuery.length() - 1);
			insertQuery += ")";
			executeUpdate(insertQuery);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Updates in the database the entry with the same id as the given parameter
	 * 
	 * @param t the entry's new data
	 * @throws Exception
	 */
	public void update(T t) throws Exception{
		String updateQuery="Update "+type.getSimpleName()+" set ";
		try {
			Object value=null;
			for (Field field : type.getDeclaredFields()) {
				if(field.getName().equalsIgnoreCase(type.getSimpleName()+"_ID")){
					continue;
				}
				PropertyDescriptor pD = new PropertyDescriptor(field.getName(), type);
				Method method = pD.getReadMethod();
				value=method.invoke(t);
				updateQuery += field.getName()+"=\'"+value+"\',";
			}
			updateQuery = updateQuery.substring(0, updateQuery.length() - 1);
			updateQuery += "where "+type.getSimpleName()+"_ID=\'";
			PropertyDescriptor pD = new PropertyDescriptor(type.getSimpleName()+"_ID", type);
			Method method = pD.getReadMethod();
			value=method.invoke(t);
			updateQuery+=value+"\'";
			executeUpdate(updateQuery);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Delete from the database the entry with the given id
	 * 
	 * @param id the id of the entry to be deleted
	 * @throws Exception
	 */
	public void delete(int id) throws Exception{
		String deleteQuery="Delete from "+type.getSimpleName()+" where "+type.getSimpleName()+"_ID=\'"+id+"\'";
		executeUpdate(deleteQuery);
	}
	
	/**
	 * Execute a database insert/update/delete based on the given String as query
	 * 
	 * @param query the query to be executed
	 * @throws Exception
	 */
	public void executeUpdate(String query) throws Exception{
		Connection con=null;
		PreparedStatement pS=null;
		con=ConnectionFactory.getConnection();	
		try {
			pS = con.prepareStatement(query);
			pS.executeUpdate();
		} catch (Exception e) { //check for invalid insertion
			throw e;
		} finally{
			ConnectionFactory.close(con);
			ConnectionFactory.close(pS);
		}
	}
}