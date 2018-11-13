package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;

import br.edu.univas.pcela4.listener.exibirTelaCadastroCargo;
import br.edu.univas.pcela4.listener.exibirTelaCadastroUsuarioListener;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.AdministradorFrame;
import br.edu.univas.pcelab4.view.CadastroCargoFrame;
import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class MainController {
	AddUserController addUserController;
	AddCargoController addCargoController;
	AdministradorFrame admFrame;
	exibirTelaCadastroUsuarioListener listener;
	
	public MainController() throws SQLException{
		addUserController = new AddUserController();
		admFrame = new AdministradorFrame();
		addCargoController = new AddCargoController();
		
		admFrame.setListener(new exibirTelaCadastroUsuarioListener() {
			
			@Override
			public void abreTelaCadastroUsuario() {
				addUserController.abrirTelaCadastroUsuario();
				
			}
		});
		
		admFrame.setListenerCargo(new exibirTelaCadastroCargo() {
			
			@Override
			public void abreTelaCadastroCargo() {
				addCargoController.abrirTelaCadastroCargo();
				
			}
		});
		
	}
	public void abrirTelaAdm(){
		admFrame.setVisible(true);
	}
//	private void abrirTelaCadastroUsuario() {
//		//cadUsuario = new CadastroUsuarioFrame();
//		cadUsuario.setVisible(true);
//		
//	}
//	
//	private void abrirTelaCadastroCargo() {
//		//cgFrame = new CadastroCargoFrame();
//		cgFrame.setVisible(true);
//		
//	}
	
}
