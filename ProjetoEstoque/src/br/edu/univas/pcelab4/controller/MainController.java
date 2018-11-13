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
	CadastroUsuarioFrame cadUsuario;
	Usuario usuario;
	AdministradorFrame admFrame;
	exibirTelaCadastroUsuarioListener listener;
	CadastroCargoFrame cgFrame;
	
	public MainController() throws SQLException{
		addUserController = new AddUserController();
		admFrame = new AdministradorFrame();
		usuario = new Usuario();
		//cadUsuario = new CadastroUsuarioFrame();
		admFrame.setListener(new exibirTelaCadastroUsuarioListener() {
			
			@Override
			public void abreTelaCadastroUsuario() {
				//abrirTelaCadastroUsuario();
				addUserController.abrirTelaCadastro();
				
			}
		});
		
		admFrame.setListenerCargo(new exibirTelaCadastroCargo() {
			
			@Override
			public void abreTelaCadastroCargo() {
				abrirTelaCadastroCargo();
				
			}
		});
		
	}
	public void abrirTelaAdm(){
		admFrame.setVisible(true);
	}
	private void abrirTelaCadastroUsuario() {
		//cadUsuario = new CadastroUsuarioFrame();
		cadUsuario.setVisible(true);
		
	}
	
	private void abrirTelaCadastroCargo() {
		//cgFrame = new CadastroCargoFrame();
		cgFrame.setVisible(true);
		
	}
	
}
