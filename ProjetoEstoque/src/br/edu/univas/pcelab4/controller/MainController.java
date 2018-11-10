package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class MainController {
	CadastroUsuarioFrame cadUsuario;
	
	public MainController(){
		cadUsuario = new CadastroUsuarioFrame();
	}
	
	public void exibirTelaCadUsuario(){
		cadUsuario.setVisible(true);
	}
}
