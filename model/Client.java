package model;

public class Client {
	private int client_ID;
	private String name;
	private String address;
	private String email;
	private int country_id;
	
	/**
	 * Constructor for the client object
	 * 
	 * @param client_ID the client id from the database
	 * @param name the client name
	 * @param country_id the country id from the database
	 */
	public Client(int client_ID, String name, String address, String email, int country_id) {
		this.client_ID = client_ID;
		this.name = name;
		this.address=address;
		this.email=email;
		this.country_id = country_id;
	}
	
	/**
	 * Parameterless constructor for the client object
	 */
	public Client(){}
	
	/**
	 * Getter for the address
	 * 
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * Setter for the address
	 * 
	 * @param address the address to set
	 */
	public final void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for the email
	 * 
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Setter for the email
	 * 
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for the client id
	 * 
	 * @return the client_ID
	 */
	public final int getClient_ID() {
		return client_ID;
	}

	/**
	 * Setter for the client id
	 * 
	 * @param client_ID the client_ID to set
	 */
	public final void setClient_ID(int client_ID) {
		this.client_ID = client_ID;
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
	
	@Override
	public String toString(){
		return client_ID+", "+name+", "+country_id;
	}
}
