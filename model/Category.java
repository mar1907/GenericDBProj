package model;

public class Category {
	private int category_id;
	private String name;
	
	/**
	 * Constructor for the Category object
	 * 
	 * @param category_id the id of the category in the data base
	 * @param name the category name
	 */
	public Category(int category_id, String name) {
		super();
		this.category_id = category_id;
		this.name = name;
	}
	
	/**
	 * Parameterless constructor for the Category object
	 */
	public Category(){}

	/**
	 * Getter for the category id
	 * 
	 * @return the category_id
	 */
	public final int getCategory_id() {
		return category_id;
	}

	/**
	 * Setter for the category id
	 * 
	 * @param category_id the category_id to set
	 */
	public final void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	
	
}
