package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import view.ClientControl;
import view.MainPage;
import view.OrderCreation;
import view.ProductControl;

public class MainController {
	public MainPage mainPage;
	
	/**
	 * Constructor for the MainController object
	 * 
	 * @param mainPage the view
	 */
	public MainController(MainPage mainPage){
		this.mainPage=mainPage;
		mainPage.addClientActionListener(new ClientActionListener());
		mainPage.addProductActionListener(new ProductActionListener());
		mainPage.addOrderActionListener(new OrderActionListener());
	}
	
	public class ClientActionListener implements ActionListener{
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			ClientControl clientView=new ClientControl();
			ClientBLL clientModel=new ClientBLL();
			ClientController clientController=new ClientController(clientView, clientModel);
			clientView.setVisible(true);
		}
	}
	
	public class ProductActionListener implements ActionListener{
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			ProductControl productView=new ProductControl();
			ProductBLL productModel=new ProductBLL();
			ProductController productController=new ProductController(productView, productModel);
			productView.setVisible(true);
		}
	}
	
	public class OrderActionListener implements ActionListener{
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			OrderCreation orderView=new OrderCreation();
			OrderBLL orderModel=new OrderBLL();
			OrderController orderController=new OrderController(orderView, orderModel);
			orderView.setVisible(true);
		}
	}
}