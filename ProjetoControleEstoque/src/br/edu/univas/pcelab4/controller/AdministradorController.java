package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;

import br.edu.univas.pcelab4.listener.AdministradorListener;
import br.edu.univas.pcelab4.view.AdministradorFrame;
import br.edu.univas.pcelab4.view.CadastroCargoFrame;
import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class AdministradorController {
	AdministradorFrame admFrame;
	AddCargoController addCargoController;
	AddUserController addUsuarioController;
	
	public AdministradorController() throws SQLException{
		admFrame = new AdministradorFrame();
		addCargoController = new AddCargoController();
		addUsuarioController = new AddUserController();
		
		admFrame.setListener(new AdministradorListener() {
			
			@Override
			public void abreTelaCadastroUsuario() {
				addUsuarioController.abrirTelaCadastroUsuario();
				
			}
			
			@Override
			public void abreTelaCadastroCargo() {
				addCargoController.abrirTelaCadastroCargo();
				
			}
		});
//		admFrame.setListener(new exibirTelaCadastroUsuarioListener() {
//			
//			@Override
//			public void abreTelaCadastroUsuario() {
//				addUsuarioController.abrirTelaCadastroUsuario();
//				
//			}
//		});
//		admFrame.setListenerCargo(new exibirTelaCadastroCargo() {
//			
//			@Override
//			public void abreTelaCadastroCargo() {
//				addCargoController.abrirTelaCadastroCargo();
//				
//			}
//		});
	}
	
	public void abrirTelaAdm(){
		admFrame.setVisible(true);
	}
	public void fecharTelaAdm(){
		admFrame.setVisible(false);
	}
	
}
