package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcela4.listener.EstoquistaListener;
import br.edu.univas.pcelab4.view.EstoquistaFrame;

public class EstoquistaController {
	EstoquistaFrame estoquistaFrame;
	AddProdutoController addProdutoController;
	
	public EstoquistaController(){
		estoquistaFrame = new EstoquistaFrame();
		addProdutoController = new AddProdutoController();
		estoquistaFrame.setListener(new EstoquistaListener() {
			
			@Override
			public void exibeTelaSaidaProduto() {
				
			}
			
			@Override
			public void exibeTelaEntradaProduto() {
				// TODO Auto-generated method stub
				
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
