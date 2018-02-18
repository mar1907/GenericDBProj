package model;

public class Product_Order {
	private int Client_ID;
	private int Product_Order_ID;
	private int Product_ID;
	private int quantity;
	
	/**
	 * Constructor for the product_order object
	 * 
	 * @param client_ID the id of the client from the database
	 * @param product_ID the the id of the order from the database 
	 * @param quantity the quantity
	 * @param product_order_id the id of the product_order from the database
	 */
	public Product_Order(int client_ID, int product_ID, int quantity, int product_order_id) {
		super();
		Product_Order_ID=product_order_id;
		Client_ID = client_ID;
		Product_ID = product_ID;
		this.quantity = quantity;
	}
	
	/**
	 * Parameterless constructor for the product_order object
	 */
	public Product_Order(){}

	/**
	 * Getter for the product_order_id
	 * 
	 * @return the product_Order_ID
	 */
	public final int getProduct_Order_ID() {
		return Product_Order_ID;
	}

	/**
	 * Setter for the product_order_id
	 * 
	 * @param product_Order_ID the product_Order_ID to set
	 */
	public final void setProduct_Order_ID(int product_Order_ID) {
		Product_Order_ID = product_Order_ID;
	}

	/**
	 * Getter for the client_id
	 * 
	 * @return the client_ID
	 */
	public final int getClient_ID() {
		return Client_ID;
	}

	/**
	 * Setter for the client_id
	 * 
	 * @param client_ID the client_ID to set
	 */
	public final void setClient_ID(int client_ID) {
		Client_ID = client_ID;
	}

	/**
	 * Getter for the product_id
	 * 
	 * @return the product_ID
	 */
	public final int getProduct_ID() {
		return Product_ID;
	}

	/**
	 * Setter for the product_id
	 * 
	 * @param order_ID the order_ID to set
	 */
	public final void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}

	/**
	 * Getter for the quantity
	 * 
	 * @return the quantity
	 */
	public final int getQuantity() {
		return quantity;
	}

	/**
	 * Setter for the quantity
	 * 
	 * @param quntity the quantity to set
	 */
	public final void setQuantity(int quntity) {
		this.quantity = quntity;
	}
	
}
