package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class OrderCreation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JCheckBox rdbtnCreateTextBill;
	private JButton btnCreateOrder;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public OrderCreation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClients = new JLabel("Clients");
		lblClients.setBounds(12, 13, 56, 16);
		contentPane.add(lblClients);
		
		JLabel lblProducts = new JLabel("Products");
		lblProducts.setBounds(611, 13, 56, 16);
		contentPane.add(lblProducts);
		
		textField = new JTextField();
		textField.setBounds(298, 60, 78, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(298, 37, 56, 16);
		contentPane.add(lblQuantity);
		
		rdbtnCreateTextBill = new JCheckBox("Create a text bill");
		rdbtnCreateTextBill.setBounds(272, 91, 127, 25);
		contentPane.add(rdbtnCreateTextBill);
		
		btnCreateOrder = new JButton("Create order");
		btnCreateOrder.setBounds(276, 125, 123, 25);
		contentPane.add(btnCreateOrder);
		
		btnNewButton = new JButton("View orders");
		btnNewButton.setBounds(276, 269, 123, 25);
		contentPane.add(btnNewButton);
	}
	
	/**
	 * Getter for rdbtnCreateTextBill
	 * 
	 * @return the rdbtnCreateTextBill
	 */
	public final JCheckBox getRdbtnCreateTextBill() {
		return rdbtnCreateTextBill;
	}

	/**
	 * Getter for textField
	 * 
	 * @return the textField
	 */
	public final JTextField getTextField() {
		return textField;
	}

	/**
	 * Setter for the table
	 * 
	 * @param newTable the table to set
	 */
	public final void setTable(JTable newTable) {
		table = newTable;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 37, 240, 260);
		contentPane.add(scrollPane);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}

	/**
	 * Setter for table_1
	 * 
	 * @param newTable the table_1 to set
	 */
	public final void setTable_1(JTable newTable) {
		table_1 = newTable;
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(425, 37, 240, 260);
		contentPane.add(scrollPane_1);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
	}
	
	/**
	 * Getter for table
	 * 
	 * @return the table
	 */
	public final JTable getTable() {
		return table;
	}

	/**
	 * Getter for table_1
	 * 
	 * @return the table_1
	 */
	public final JTable getTable_1() {
		return table_1;
	}
	
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(contentPane, msg);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addInsertActionListener(ActionListener aL){
		btnCreateOrder.addActionListener(aL);
	}
	
	public void showOrders(JTable table){
		ShowData sD=new ShowData(table);
		sD.setVisible(true);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addShowActionListener(ActionListener aL){
		btnNewButton.addActionListener(aL);
	}
}
