package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcela4.listener.exibirTelaCadastroCargo;
import br.edu.univas.pcela4.listener.exibirTelaCadastroUsuarioListener;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.AdministradorFrame;
import br.edu.univas.pcelab4.view.CadastroCargoFrame;
import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class MainController {
	CadastroUsuarioFrame cadUsuario;
	Usuario usuario;
	AdministradorFrame admFrame;
	exibirTelaCadastroUsuarioListener listener;
	CadastroCargoFrame cgFrame;
	
	public MainController(){
		admFrame = new AdministradorFrame();
		usuario = new Usuario();
		admFrame.setListener(new exibirTelaCadastroUsuarioListener() {
			
			@Override
			public void abreTelaCadastroUsuario() {
				abrirTelaCadastroUsuario();
				
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
		cadUsuario = new CadastroUsuarioFrame();
		cadUsuario.setVisible(true);
		
	}
	
	private void abrirTelaCadastroCargo() {
		cgFrame = new CadastroCargoFrame();
		cgFrame.setVisible(true);
		
	}
	
}
