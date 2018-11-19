package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;

import br.edu.univas.pcela4.listener.TelaPrincipalListener;
import br.edu.univas.pcela4.listener.exibirTelaCadastroCargo;
import br.edu.univas.pcela4.listener.exibirTelaCadastroUsuarioListener;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.AdministradorFrame;
import br.edu.univas.pcelab4.view.CadastroCargoFrame;
import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;
import br.edu.univas.pcelab4.view.LoginFrame;
import br.edu.univas.pcelab4.view.TelaInicialFrame;

public class MainController {
	//AddUserController addUserController;
	//AddCargoController addCargoController;
	//AdministradorFrame admFrame;
	//exibirTelaCadastroUsuarioListener listener;
	TelaInicialFrame telaInicialFrame;
	LoginController loginController;
	
	public MainController() throws SQLException{
		loginController = new LoginController();
		telaInicialFrame = new TelaInicialFrame();
		telaInicialFrame.setListener(new TelaPrincipalListener() {
			
			@Override
			public void sairTelaPrincipal() {
				sairApp();
				
			}
			
			@Override
			public void exibirTelaLogin() {
				
				loginController.abrirTelaLogin();
				
				
			}
		});
//		addUserController = new AddUserController();
//		admFrame = new AdministradorFrame();
//		addCargoController = new AddCargoController();
//		
//		admFrame.setListener(new exibirTelaCadastroUsuarioListener() {
//			
//			@Override
//			public void abreTelaCadastroUsuario() {
//				addUserController.abrirTelaCadastroUsuario();
//				
//			}
//		});
//		
//		admFrame.setListenerCargo(new exibirTelaCadastroCargo() {
//			
//			@Override
//			public void abreTelaCadastroCargo() {
//				addCargoController.abrirTelaCadastroCargo();
//				
//			}
//		});
		
	}
//	public void abrirTelaAdm(){
//		admFrame.setVisible(true);
//	}
	
	public void initApp(){
		telaInicialFrame.setVisible(true);
	}
	public void sairApp(){
		telaInicialFrame.setVisible(false);
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
