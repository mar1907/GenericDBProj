package connection;
import java.sql.*;

public class ConnectionFactory {
	private static final String URL = "jdbc:sqlserver://localhost;database=HW3;integratedSecurity=true";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static ConnectionFactory singleInstance=new ConnectionFactory();
	
	/**
	 * Private constructor for the connectionFactory object, can only be accessed through static methods
	 */
	private ConnectionFactory(){
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a connection to the database
	 * 
	 * @return the Connection object
	 */
	private Connection createConnection(){
		Connection con=null;
		try {
			con = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * Creates and returns a Connection to the database through a private method
	 * 
	 * @return the Connection object
	 */
	public static Connection getConnection(){
		return singleInstance.createConnection();
	}
	
	/**
	 * Closes a connection to the database
	 * 
	 * @param con the Connection object to be closed
	 */
	public static void close(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Closes a statement
	 * 
	 * @param stat the Statement object to be closed
	 */
	public static void close(Statement stat){
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Closes a ResultSet
	 * 
	 * @param rS the ResultSet object to be closed
	 */
	public static void close(ResultSet rS){
		if(rS!=null){
			try {
				rS.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}