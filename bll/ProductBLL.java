package bll;

import java.util.List;

import bll.validators.PriceValidator;
import bll.validators.StockValidator;
import dao.CategoryDAO;
import dao.ProductDAO;
import dao.Product_OrderDAO;
import model.Category;
import model.Product;

public class ProductBLL extends AbstractBLL {
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	private PriceValidator priceValidator;
	private StockValidator stockValidator;
	
	/**
	 * Constructor for the ProductBLL object
	 */
	public ProductBLL(){
		productDAO=new ProductDAO();
		categoryDAO=new CategoryDAO();
		priceValidator=new PriceValidator();
		stockValidator=new StockValidator();
	}
	
	/**
	 * Inserts a new product in the database with the given parameters 
	 * 
	 * @param name the name
	 * @param price the price
	 * @param stock the stock
	 * @param category the category
	 * @return a String representing the error message (if any)
	 * @throws Exception
	 */
	public String insertNew(String name, int price, int stock, String category) throws Exception{
		categoryDAO=new CategoryDAO();
		try {
			Category categoryObj=categoryDAO.findByName(category);
			Product product=new Product(0, name, price, stock, categoryObj.getCategory_id());
			String resMessage="";
			if(!priceValidator.isValid(product)){
				resMessage+="Invalid price, must be >0;\n";
			}
			if(!stockValidator.isValid(product)){
				resMessage+="Invalid stock, must be >=0;\n";
				return resMessage;
			}
			productDAO.insert(product);
			return resMessage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Updates the Product with the given id in the database
	 * 
	 * @param id the id
	 * @param name the name
	 * @param price the price
	 * @param stock the stock
	 * @param category the category
	 * @return a String representing the error message (if any)
	 * @throws Exception
	 */
	public String update(int id, String name, int price, int stock, String category) throws Exception{
		categoryDAO=new CategoryDAO();
		try {
			Category categoryObj=categoryDAO.findByName(category);
			Product product=new Product(id, name, price, stock, categoryObj.getCategory_id());
			String resMessage="";
			if(!priceValidator.isValid(product)){
				resMessage+="Invalid price, must be >0;\n";
			}
			if(!stockValidator.isValid(product)){
				resMessage+="Invalid stock, must be >=0;\n";
				return resMessage;
			}
			productDAO.update(product);
			return resMessage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Deletes an entry from the database based on the id
	 * 
	 * @param id the id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception{
		try {
			productDAO.delete(id);
			new Product_OrderDAO().deleteByProduct(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Returns a list of all the Product entries based on the filtering criteria
	 * 
	 * @param c < for less than filter, u for understock, anything else for all
	 * @param filter the filter
	 * @return the list of all the Product entries in the database based on the criteria
	 * @throws Exception
	 */
	public List<Product> getAll(char c, int filter) throws Exception{
		try {
			if(c=='<'){
				return productDAO.filterBy("price", c, filter);
			} else if(c=='u'){
				return productDAO.getUnderstock();
			} else 
				return productDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Returns a list of all the category entries in the database
	 * 
	 * @return the list of all the category entries in the database
	 * @throws Exception
	 */
	public List<Category> getAllCategories() throws Exception{
		try {
			return categoryDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
