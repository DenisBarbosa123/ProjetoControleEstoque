package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcela4.listener.EstoquistaListener;
import br.edu.univas.pcelab4.view.EstoquistaFrame;

public class EstoquistaController {
	EstoquistaFrame estoquistaFrame;
	AddProdutoController addProdutoController;
	EntradaController entradaController;
	
	public EstoquistaController(){
		estoquistaFrame = new EstoquistaFrame();
		addProdutoController = new AddProdutoController();
		entradaController = new EntradaController();
		estoquistaFrame.setListener(new EstoquistaListener() {
			
			@Override
			public void exibeTelaSaidaProduto() {
				
			}
			
			@Override
			public void exibeTelaEntradaProduto() {
				entradaController.abrirTelaEntrada();
				
			}
			
			@Override
			public void exibeTelaCadastroProduto() {
				addProdutoController.abrirTelaCadastroProduto();
				
			}
		});
	}
	
	public void abrirTelaEstoquista(){
		estoquistaFrame.setVisible(true);
	}
	
}
