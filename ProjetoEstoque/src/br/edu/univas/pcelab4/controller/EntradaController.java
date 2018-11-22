package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcela4.listener.EntradaListener;
import br.edu.univas.pcelab4.view.EntradaFrame;

public class EntradaController {
	EntradaFrame entradaFrame;
	
	public EntradaController() {
		entradaFrame = new EntradaFrame();
		
		entradaFrame.setListener(new EntradaListener() {
			
			@Override
			public void sairTelaEntrada() {
				fecharTelaEntrada();
				
			}
			
			@Override
			public void registraEntrada() {
				registrarEntrada();
				
			}
		});
	}
	
	public void abrirTelaEntrada(){
		entradaFrame.setVisible(true);
	}
	
	public void fecharTelaEntrada(){
		entradaFrame.setVisible(false);
	}
	
	public void registrarEntrada(){
		
	}
}
