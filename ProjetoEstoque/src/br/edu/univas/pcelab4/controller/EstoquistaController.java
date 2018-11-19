package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcelab4.view.EstoquistaFrame;

public class EstoquistaController {
	EstoquistaFrame estoquistaFrame;
	
	public EstoquistaController(){
		estoquistaFrame = new EstoquistaFrame();
	}
	
	public void abrirTelaEstoquista(){
	
		estoquistaFrame.setVisible(true);
	}
	
	public void abrirTelaCadastroProduto(){
		
	}
}
