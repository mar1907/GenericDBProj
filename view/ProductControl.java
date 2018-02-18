package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class ProductControl extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnUnderstockProducts;
	private JRadioButton rdbtnProductsWithPrices;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public ProductControl() {
		setTitle("Product Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducts = new JLabel("Products");
		lblProducts.setBounds(12, 13, 56, 16);
		contentPane.add(lblProducts);
		
		button = new JButton("Delete selected");
		button.setBounds(12, 398, 119, 25);
		contentPane.add(button);
		
		button_1 = new JButton("Refresh table");
		button_1.setBounds(161, 398, 119, 25);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(320, 24, 320, 200);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 101, 153, 22);
		panel.add(textField);
		
		JLabel label = new JLabel("Name");
		label.setBounds(12, 72, 56, 16);
		panel.add(label);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(12, 136, 56, 16);
		panel.add(lblCategory);
		
		comboBox = new JComboBox();
		comboBox.setBounds(12, 165, 153, 22);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 69, 41, 22);
		panel.add(textField_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(177, 40, 56, 16);
		panel.add(lblPrice);
		
		button_2 = new JButton("Insert new");
		button_2.setBounds(177, 121, 116, 25);
		panel.add(button_2);
		
		button_3 = new JButton("Update");
		button_3.setBounds(177, 164, 116, 25);
		panel.add(button_3);
		
		JLabel label_1 = new JLabel("Stock");
		label_1.setBounds(252, 40, 56, 16);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(252, 69, 41, 22);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(12, 37, 41, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(12, 13, 56, 16);
		panel.add(lblId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(320, 281, 320, 142);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblShowProductWhich = new JLabel("Show:");
		lblShowProductWhich.setBounds(12, 9, 49, 16);
		panel_1.add(lblShowProductWhich);
		
		rdbtnNewRadioButton = new JRadioButton("All products");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(26, 34, 127, 25);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnUnderstockProducts = new JRadioButton("Understock products");
		buttonGroup.add(rdbtnUnderstockProducts);
		rdbtnUnderstockProducts.setBounds(26, 64, 145, 25);
		panel_1.add(rdbtnUnderstockProducts);
		
		rdbtnProductsWithPrices = new JRadioButton("Products with prices smaller than");
		buttonGroup.add(rdbtnProductsWithPrices);
		rdbtnProductsWithPrices.setBounds(26, 94, 219, 25);
		panel_1.add(rdbtnProductsWithPrices);
		
		textField_3 = new JTextField();
		textField_3.setBounds(246, 95, 28, 22);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setBounds(320, 253, 56, 16);
		contentPane.add(lblFilters);
	}
	
	/**
	 * Getter for comboBox
	 * 
	 * @return the comboBox
	 */
	@SuppressWarnings("rawtypes")
	public final JComboBox getComboBox() {
		return comboBox;
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
	 * Getter for textField_1
	 * 
	 * @return the textField_1
	 */
	public final JTextField getTextField_1() {
		return textField_1;
	}

	/**
	 * Getter for textField_2
	 * 
	 * @return the textField_2
	 */
	public final JTextField getTextField_2() {
		return textField_2;
	}

	/**
	 * Getter for textField_3
	 * 
	 * @return the textField_3
	 */
	public final JTextField getTextField_3() {
		return textField_3;
	}

	/**
	 * Getter for textField_4
	 * 
	 * @return the textField_4
	 */
	public final JTextField getTextField_4() {
		return textField_4;
	}

	/**
	 * Returns the value from the id field of the selected row of the JTable 
	 * 
	 * @return the value
	 */
	public int getIdOfSelected(){
		return (Integer)table.getValueAt(table.getSelectedRow(),0);
	}
	
	/**
	 * Displays an error message
	 * 
	 * @param msg the message
	 */
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(contentPane, msg);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addDeleteActionListener(ActionListener al){
		button.addActionListener(al);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addSearchActionListener(ActionListener aL){
		button_1.addActionListener(aL);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addInsertActionListener(ActionListener aL){
		button_2.addActionListener(aL);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addUpdateActionListener(ActionListener aL){
		button_3.addActionListener(aL);
	}
	
	/**
	 * Setter for the JTable table. Also creates an ActionListener for it
	 * 
	 * @param newTable the table to be set
	 */
	public void setTable(JTable newTable){
		table = newTable;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 42, 268, 343);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
			    if (row >= 0) {
			    	textField_4.setText(table.getValueAt(row, 0).toString());
			    	textField.setText((String)table.getValueAt(row, 1));
			    	textField_1.setText(table.getValueAt(row, 2).toString());
			    	textField_2.setText((String)table.getValueAt(row, 3).toString());
			    	comboBox.setSelectedIndex((Integer)table.getValueAt(row, 4)-1);
			    }
			}
		});
	}

	/**
	 * Getter for rdbtnNewRadioButton
	 * 
	 * @return the rdbtnNewRadioButton
	 */
	public final JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}

	/**
	 * Getter for rdbtnUnderstockProducts
	 * 
	 * @return the rdbtnUnderstockProducts
	 */
	public final JRadioButton getRdbtnUnderstockProducts() {
		return rdbtnUnderstockProducts;
	}

	/**
	 * Getter for rdbtnProductsWithPrices
	 * 
	 * @return the rdbtnProductsWithPrices
	 */
	public final JRadioButton getRdbtnProductsWithPrices() {
		return rdbtnProductsWithPrices;
	}
}
