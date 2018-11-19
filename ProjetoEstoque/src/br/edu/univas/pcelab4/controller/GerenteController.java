package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcelab4.view.GerenteFrame;

public class GerenteController {
	GerenteFrame gerenteFrame;
	
	public GerenteController(){
		gerenteFrame = new GerenteFrame();
	}
	
	public void abrirTelaGerente(){
		gerenteFrame.setVisible(true);
	}
}
