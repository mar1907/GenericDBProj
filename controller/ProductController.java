package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bll.ProductBLL;
import model.Category;
import view.ProductControl;

public class ProductController {
	private ProductControl productControl;
	private ProductBLL productBLL;
	
	/**
	 * Controller for the ProductController object
	 * 
	 * @param view the view
	 * @param model the model
	 */
	@SuppressWarnings("unchecked")
	public ProductController(ProductControl view, ProductBLL model){
		productControl=view;
		productBLL=model;
		try {
			productControl.setTable(productBLL.createTable(new ArrayList<Object>(productBLL.getAll('a',0))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			for(Category c:productBLL.getAllCategories()){
				productControl.getComboBox().addItem(c.getName());
			}
		} catch (Exception e) {
			//do nothing
		}
		productControl.addDeleteActionListener(new DeleteActionListener());
		productControl.addSearchActionListener(new SearchActionListener());
		productControl.addInsertActionListener(new InsertActionListener());
		productControl.addUpdateActionListener(new UpdateActionListener());
	}
	
	public class DeleteActionListener implements ActionListener{
		public void actionPerformed(ActionEvent argo0) {
			try {
				productBLL.delete(productControl.getIdOfSelected());
			} catch (Exception e) {
				productControl.showMessage("Could not delete, a database error ocurred!");
			}
		}
	}
	
	class SearchActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
				if(productControl.getRdbtnNewRadioButton().isSelected()){
					productControl.setTable(productBLL.createTable(new ArrayList<Object>(productBLL.getAll('a',0))));
				} else if(productControl.getRdbtnUnderstockProducts().isSelected()){
					productControl.setTable(productBLL.createTable(new ArrayList<Object>(productBLL.getAll('u',0))));
				} else if(productControl.getRdbtnProductsWithPrices().isSelected()){
					productControl.setTable(productBLL.createTable(new ArrayList<Object>(productBLL.getAll('<',
							Integer.parseInt(productControl.getTextField_3().getText())))));
				}
			} catch (Exception e) {
				productControl.showMessage("Could not search, a database error ocurred!");
			}
		}
	}
	
	class InsertActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				String msg=productBLL.insertNew(productControl.getTextField().getText(), 
						Integer.parseInt(productControl.getTextField_1().getText()), 
						Integer.parseInt(productControl.getTextField_2().getText()), 
						(String)productControl.getComboBox().getSelectedItem());
				if(!msg.equals("")){
					productControl.showMessage(msg);
				}
			} catch (Exception e1) {
				productControl.showMessage("Could not insert, a database error ocurred!");
			}
		}
	}
	
	class UpdateActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try {
				String msg=productBLL.update(Integer.parseInt(productControl.getTextField_4().getText()),
						productControl.getTextField().getText(), 
						Integer.parseInt(productControl.getTextField_1().getText()), 
						Integer.parseInt(productControl.getTextField_2().getText()), 
						(String)productControl.getComboBox().getSelectedItem());
				if(!msg.equals("")){
					productControl.showMessage(msg);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				productControl.showMessage("Could not update, a database error ocurred!");
			}
		}
	}
}
