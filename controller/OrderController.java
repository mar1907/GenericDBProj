package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bll.OrderBLL;
import view.OrderCreation;

public class OrderController {
	private OrderCreation orderControl;
	private OrderBLL orderBLL;
	
	/**
	 * Constructor for the OrderController object
	 * 
	 * @param view the view
	 * @param model the model
	 */
	public OrderController(OrderCreation view, OrderBLL model){
		orderControl=view;
		orderBLL=model;
		try {
			orderControl.setTable(orderBLL.createTable(new ArrayList<Object>(orderBLL.getAllClients())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			orderControl.setTable_1(orderBLL.createTable(new ArrayList<Object>(orderBLL.getAllProducts())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		orderControl.addInsertActionListener(new CreateActionListener());
		orderControl.addShowActionListener(new ShowActionListener());
	}
	
	class CreateActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				String msg=orderBLL.insertNew(
						(Integer)orderControl.getTable().getValueAt(orderControl.getTable().getSelectedRow(), 0),
						(Integer)orderControl.getTable_1().getValueAt(orderControl.getTable_1().getSelectedRow(), 0),
						Integer.parseInt(orderControl.getTextField().getText()), 
						orderControl.getRdbtnCreateTextBill().isSelected());
				if(!msg.equals("")){
					orderControl.showMessage(msg);
				}
			} catch (Exception e1) {
				orderControl.showMessage("Could not insert, a database error ocurred!");
			}	
		}
	}
	
	class ShowActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				orderControl.showOrders(orderBLL.createTable(new ArrayList<Object>(orderBLL.getAll())));
			} catch (Exception e1) {
				orderControl.showMessage("Could not search, a database error ocurred!");
			}
		}
	}
}
