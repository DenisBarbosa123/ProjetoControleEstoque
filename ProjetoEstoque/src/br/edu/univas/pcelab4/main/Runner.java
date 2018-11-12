package br.edu.univas.pcelab4.main;

import java.sql.SQLException;

import br.edu.univas.pcelab4.controller.EstoquistaController;
import br.edu.univas.pcelab4.controller.MainController;

public class Runner {

	public static void main(String[] args) {
//		EstoquistaController controller = new EstoquistaController();
//		controller.abrirTelaEstoquista();
		MainController controller;
		try {
			controller = new MainController();
			controller.abrirTelaAdm();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
