package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	private JPanel contentPane;
	private JButton btnManageClients;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnManageClients = new JButton("Manage clients");
		btnManageClients.setBounds(12, 13, 143, 25);
		contentPane.add(btnManageClients);
		
		btnNewButton = new JButton("Manage products");
		btnNewButton.setBounds(12, 51, 143, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Add new orders");
		btnNewButton_1.setBounds(12, 89, 143, 25);
		contentPane.add(btnNewButton_1);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addClientActionListener(ActionListener aL){
		btnManageClients.addActionListener(aL);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addProductActionListener(ActionListener aL){
		btnNewButton.addActionListener(aL);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addOrderActionListener(ActionListener aL){
		btnNewButton_1.addActionListener(aL);
	}
}
