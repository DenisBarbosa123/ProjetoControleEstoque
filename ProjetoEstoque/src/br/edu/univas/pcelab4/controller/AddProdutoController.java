package br.edu.univas.pcelab4.controller;

import javax.swing.JOptionPane;

import br.edu.univas.pcela4.listener.CadastraProdutoListener;
import br.edu.univas.pcelab4.dao.ProdutoDAO;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.view.CadastroProdutoFrame;

public class AddProdutoController {
	CadastroProdutoFrame addProdutoFrame;
	Produto produto;
	ProdutoDAO daoProduto;
	public AddProdutoController() {
		addProdutoFrame = new CadastroProdutoFrame();
		daoProduto = new ProdutoDAO();
		
		addProdutoFrame.setListener(new CadastraProdutoListener() {

			@Override
			public void salvaProduto() {
				salvarProduto();
				
			}

			@Override
			public void sairTelaCadastro() {
				fecharTelaCadastroProduto();
				
			}

			
			
		});
	}
	
	public void abrirTelaCadastroProduto(){
		addProdutoFrame.setVisible(true);
	}
	public void fecharTelaCadastroProduto(){
		addProdutoFrame.setVisible(false);
	}
	
	private void salvarProduto() {
		if(addProdutoFrame.getCampoNome().getText().length()==0 || addProdutoFrame.getCampoQtdeMinima().getText().length()==0
			||	addProdutoFrame.getCampoValor().getText().length()==0){
			JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO - CAMPO NULO", "Erro", JOptionPane.ERROR_MESSAGE);
		}else{
			produto = new Produto();
			produto.setNome(addProdutoFrame.getCampoNome().getText());
			produto.setQtdeMinima(Integer.parseInt(addProdutoFrame.getCampoQtdeMinima().getText()));
			produto.setValor(Double.parseDouble(addProdutoFrame.getCampoValor().getText()));
			if(daoProduto.salvar(produto)==true){
				JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
}	
