package model;

public class Country {
	private int country_id;
	private String name;
	
	/**Constructor for the country object
	 * 
	 * @param country_id the country id from the database
	 * @param name the name
	 */
	public Country(int country_id, String name) {
		super();
		this.country_id = country_id;
		this.name = name;
	}
	
	/**
	 * Parameterless constructor for the country object
	 */
	public Country(){}

	/**
	 * Getter for the country id
	 * 
	 * @return the country_id
	 */
	public final int getCountry_id() {
		return country_id;
	}

	/**
	 * Setter for the country id
	 * 
	 * @param country_id the country_id to set
	 */
	public final void setCountry_id(int country_id) {
		this.country_id = country_id;
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
