package bll;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import bll.AbstractBLL;
import bll.validators.QuantityValidator;
import dao.ClientDAO;
import dao.ProductDAO;
import dao.Product_OrderDAO;
import model.Client;
import model.Product;
import model.Product_Order;

public class OrderBLL extends AbstractBLL {
	private Product_OrderDAO orderDAO;
	private ProductDAO productDAO;
	private ClientDAO clientDAO;
	private QuantityValidator quantityValidator;
	
	/**
	 * Constructor for the OrderBLL object
	 */
	public OrderBLL(){
		orderDAO=new Product_OrderDAO();
		productDAO=new ProductDAO();
		clientDAO=new ClientDAO();
		quantityValidator=new QuantityValidator();
	}
	
	/**
	 * Inserts a new order in the database with the given parameters
	 * 
	 * @param clientId the client_id
	 * @param productId the product_id
	 * @param quantity the quantity
	 * @param createBill true if a .txt bill needs to be created
	 * @return an error message if any error occurs
	 * @throws Exception
	 */
	public String insertNew(int clientId, int productId, int quantity, boolean createBill) throws Exception{
		Product_Order order=new Product_Order(clientId, productId, quantity, 0);
		if(!quantityValidator.isValid(order)){
			return "Invalid quantity, must be >0";
		}
		try {
			Product product = productDAO.findByID(productId);
			if (product.getStock() < quantity) {
				return "Product understock";
			}
			product.setStock(product.getStock()-quantity);
			productDAO.update(product);
			orderDAO.insert(order);
			if(createBill){
				Client client=clientDAO.findByID(order.getClient_ID());
				Writer writer = null;
				try {
				    writer = new BufferedWriter(new OutputStreamWriter(
				          new FileOutputStream("Order "+orderDAO.getfLastInsert().getProduct_Order_ID()+" report.txt"), "utf-8"));
				    writer.write(client.getName()+" ordered "+product.getName()+" quantity: "+order.getQuantity());
				} catch (IOException ex) {
				  // report
				} finally {
				   try {
					   writer.close();
				   } catch (Exception ex) {
					   //nothing
				   }
				}
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Deletes all entries in the database with a certain product_id
	 * 
	 * @param id the product_id
	 * @throws Exception
	 */
	public void deleteByProductId(int id) throws Exception{
		try {
			orderDAO.deleteByProduct(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Deletes all entries in the database with a certain client_id
	 * 
	 * @param id the client_id
	 * @throws Exception
	 */
	public void deleteByClientId(int id) throws Exception{
		try {
			orderDAO.deleteByClient(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Return a list of all the product_order entries in the database
	 * 
	 * @return the list of all the product_order entries in the database
	 * @throws Exception
	 */
	public List<Product_Order> getAll() throws Exception{
		try {
			return orderDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Return a list of all the product entries in the database
	 * 
	 * @return the list of all the product entries in the database
	 * @throws Exception
	 */
	public List<Product> getAllProducts() throws Exception{
		try {
			return productDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Return a list of all the client entries in the database
	 * 
	 * @return the list of all the client entries in the database
	 * @throws Exception
	 */
	public List<Client> getAllClients() throws Exception{
		try {
			return clientDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
