package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcelab4.view.EstoquistaFrame;

public class EstoquistaController {
	EstoquistaFrame frame;
	
	public EstoquistaController(){
	}
	
	public void abrirTelaEstoquista(){
		frame = new EstoquistaFrame();
		frame.setVisible(true);
	}
	
	public void abrirTelaCadastroProduto(){
		
	}
}