package main;

import controller.MainController;
import view.MainPage;

public class MainClass {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		MainPage view=new MainPage();
		MainController mainController=new MainController(view);
		view.setVisible(true);
	}
}
