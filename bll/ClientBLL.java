package bll;

import java.util.List;

import bll.validators.EmailValidator;
import dao.ClientDAO;
import dao.CountryDAO;
import dao.Product_OrderDAO;
import model.Client;
import model.Country;

public class ClientBLL extends AbstractBLL{
	private ClientDAO clientDAO;
	private CountryDAO countryDAO;
	private EmailValidator emailValidator;
	
	/**
	 * Constructor for the ClientBLL object
	 */
	public ClientBLL(){
		clientDAO=new ClientDAO();
		countryDAO=new CountryDAO();
		emailValidator=new EmailValidator();
	}
	
	/**
	 * Inserts a new Client in the database with the given arguments as instance variables
	 * 
	 * @param name the name
	 * @param address the address
	 * @param email the email
	 * @param country the country
	 * @return true for a successful insertion, false if the object is not valid 
	 * @throws Exception 
	 */
	public boolean insertNew(String name, String address, String email, String country) throws Exception{
		countryDAO=new CountryDAO();
		try {
			Country countryObj=countryDAO.findByName(country);
			Client client=new Client(0, name, address, email, countryObj.getCountry_id());
			if(!emailValidator.isValid(client)){
				return false;
			}
			clientDAO.insert(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return true;
	}
	
	/**
	 * Updates the Client with the given id in the database
	 * 
	 * @param id the id
	 * @param name the name
	 * @param address the address
	 * @param email the email
	 * @param country the country
	 * @return true for a successful update, false if the object is not valid 
	 * @throws Exception
	 */
	public boolean update(int id, String name, String address, String email, String country) throws Exception{
		countryDAO=new CountryDAO();
		try {
			Country countryObj=countryDAO.findByName(country);
			Client client=new Client(id, name, address, email, countryObj.getCountry_id());
			if(!emailValidator.isValid(client)){
				return false;
			}
			clientDAO.update(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return true;
	}
	
	/**
	 * Deletes an entry from the database based on the id
	 * 
	 * @param id the id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception{
		try {
			clientDAO.delete(id);
			new Product_OrderDAO().deleteByClient(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Returns a list of all the client entries in the database
	 * 
	 * @return the list of all the client entries in the database
	 * @throws Exception
	 */
	public List<Client> getAll() throws Exception{
		try {
			return clientDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Returns a list of all the country entries in the database
	 * 
	 * @return the list of all the country entries in the database
	 * @throws Exception
	 * 
	 */
	public List<Country> getAllCountries() throws Exception{
		try {
			return countryDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
