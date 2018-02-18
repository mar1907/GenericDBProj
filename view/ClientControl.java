package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class ClientControl extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnDeleteSelected;
	private JButton btnNewButton_2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public ClientControl() {
		setTitle("Client Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 661, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setBounds(10, 13, 56, 16);
		contentPane.add(lblNewLabel);
		
		btnDeleteSelected = new JButton("Delete selected");
		btnDeleteSelected.setBounds(12, 253, 119, 25);
		contentPane.add(btnDeleteSelected);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(334, 13, 286, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 113, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 84, 56, 16);
		panel.add(lblName);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(152, 148, 56, 16);
		panel.add(lblCountry);
		
		comboBox = new JComboBox();
		comboBox.setBounds(152, 177, 116, 22);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 113, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 177, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(152, 84, 56, 16);
		panel.add(lblAddress);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(12, 148, 56, 16);
		panel.add(lblEmail);
		
		btnNewButton = new JButton("Insert new");
		btnNewButton.setBounds(12, 227, 116, 25);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(152, 227, 116, 25);
		panel.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 212, 256, 2);
		panel.add(separator);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(12, 49, 56, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(12, 20, 56, 16);
		panel.add(lblId);
		
		btnNewButton_2 = new JButton("Refresh table");
		btnNewButton_2.setBounds(161, 253, 119, 25);
		contentPane.add(btnNewButton_2);
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
	 * Getter for comboBox
	 * 
	 * @return the comboBox
	 */
	@SuppressWarnings("rawtypes")
	public final JComboBox getComboBox() {
		return comboBox;
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
	 * Getter for textField_1
	 * 
	 * @return the textField_1
	 */
	public final JTextField getTextField_1() {
		return textField_1;
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
	public void addDeleteActionListener(ActionListener aL){
		btnDeleteSelected.addActionListener(aL);
	}
	
	/**
	 * Setter for the JTable table. Also creates an ActionListener for it
	 * 
	 * @param newTable the table to be set
	 */
	public void setTable(JTable newTable){
		table=newTable;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 33, 268, 207);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
			    if (row >= 0) {
			    	textField_3.setText(table.getValueAt(row, 0).toString());
			    	textField.setText((String)table.getValueAt(row, 1));
			    	textField_1.setText((String)table.getValueAt(row, 2));
			    	textField_2.setText((String)table.getValueAt(row, 3));
			    	comboBox.setSelectedIndex((Integer)table.getValueAt(row, 4)-1);
			    }
			}
		});
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addSearchActionListener(ActionListener aL){
		btnNewButton_2.addActionListener(aL);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addInsertActionListener(ActionListener aL){
		btnNewButton.addActionListener(aL);
	}
	
	/**
	 * Adds an ActionListener to a button
	 * 
	 * @param aL the ActionListener to be added
	 */
	public void addUpdateActionListener(ActionListener aL){
		btnNewButton_1.addActionListener(aL);
	}

	/**
	 * Getter for textField
	 * 
	 * @return the textField
	 */
	public final JTextField getTextField() {
		return textField;
	}
}
