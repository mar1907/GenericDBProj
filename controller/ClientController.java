package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bll.ClientBLL;
import model.Country;
import view.ClientControl;

public class ClientController {
	private ClientControl clientControl;
	private ClientBLL clientBLL;
	
	/**
	 * Constructor for the ClientController object
	 * 
	 * @param view the view
	 * @param model the model
	 */
	@SuppressWarnings("unchecked")
	public ClientController(ClientControl view, ClientBLL model){
		clientControl=view;
		clientBLL=model;
		try {
			clientControl.setTable(clientBLL.createTable(new ArrayList<Object>(clientBLL.getAll())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			for(Country c:clientBLL.getAllCountries()){
				clientControl.getComboBox().addItem(c.getName());
			}
		} catch (Exception e) {
			//do nothing
		}
		clientControl.addDeleteActionListener(new DeleteActionListener());
		clientControl.addSearchActionListener(new SearchActionListener());
		clientControl.addInsertActionListener(new InsertActionListener());
		clientControl.addUpdateActionListener(new UpdateActionListener());
	}
	
	class DeleteActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
				clientBLL.delete(clientControl.getIdOfSelected());
			} catch (Exception e) {
				clientControl.showMessage("Could not delete, a database error ocurred!");
			}
		}
	}
	
	class SearchActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
				clientControl.setTable(clientBLL.createTable(new ArrayList<Object>(clientBLL.getAll())));
			} catch (Exception e) {
				clientControl.showMessage("Could not search, a database error ocurred!");
			}
		}
	}
	
	class InsertActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				if(!clientBLL.insertNew(clientControl.getTextField().getText(), clientControl.getTextField_1().getText(), 
						clientControl.getTextField_2().getText(), (String)clientControl.getComboBox().getSelectedItem())){
					clientControl.showMessage("Invalid email address format!");
				}
			} catch (Exception e1) {
				clientControl.showMessage("Could not insert, a database error ocurred!");
			}
		}
	}
	
	class UpdateActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
				if(!clientBLL.update(Integer.parseInt(clientControl.getTextField_3().getText()),
						clientControl.getTextField().getText(), clientControl.getTextField_1().getText(), 
						clientControl.getTextField_2().getText(), (String)clientControl.getComboBox().getSelectedItem())){
					clientControl.showMessage("Invalid email address format!");
				}
			} catch (Exception e) {
				clientControl.showMessage("Could not update, a database error ocurred!");
			}
		}
	}
}
