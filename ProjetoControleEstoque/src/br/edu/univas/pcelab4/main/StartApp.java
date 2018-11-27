package br.edu.univas.pcelab4.main;

import java.sql.SQLException;

import br.edu.univas.pcelab4.controller.AdministradorController;
import br.edu.univas.pcelab4.controller.MainController;

public class StartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		AdministradorController controller;
//		try {
//			controller = new AdministradorController();
//			controller.abrirTelaAdm();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		MainController controller;
		try {
			controller = new MainController();
			controller.initApp();;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
