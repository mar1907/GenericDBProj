package model;

public class Product {
	private int product_ID;
	private String name;
	private int price;
	private int stock;
	private int category_ID;
	
	/**
	 * Constructor for the product object
	 * 
	 * @param product_ID the product id from the database
	 * @param name the name
	 * @param price the price
	 * @param stock the stock
	 * @param category_ID the category id from the database
	 */
	public Product(int product_ID, String name, int price, int stock, int category_ID) {
		super();
		this.product_ID = product_ID;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category_ID = category_ID;
	}
	
	/**
	 * Parameterless constructor for the product object
	 */
	public Product(){}

	/**
	 * Getter for the product_id
	 * 
	 * @return the product_ID
	 */
	public final int getProduct_ID() {
		return product_ID;
	}

	/**
	 * Setter for the product_id
	 * 
	 * @param product_ID the product_ID to set
	 */
	public final void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

	/**
	 * Getter for the name
	 * 
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Setter for the name
	 * 
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the price
	 * 
	 * @return the price
	 */
	public final int getPrice() {
		return price;
	}

	/**
	 * Setter for the set
	 * 
	 * @param price the price to set
	 */
	public final void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Getter for the stock
	 * 
	 * @return the stock
	 */
	public final int getStock() {
		return stock;
	}

	/**
	 * Setter for the stock
	 * 
	 * @param stock the stock to set
	 */
	public final void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Getter for the category_id
	 * 
	 * @return the category_ID
	 */
	public final int getCategory_ID() {
		return category_ID;
	}

	/**
	 * Setter for the category_id
	 * 
	 * @param category_ID the category_ID to set
	 */
	public final void setCategory_ID(int category_ID) {
		this.category_ID = category_ID;
	}
	
	
}
