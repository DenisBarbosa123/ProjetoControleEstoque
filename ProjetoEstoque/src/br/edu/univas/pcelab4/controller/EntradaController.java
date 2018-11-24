package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.univas.pcela4.listener.EntradaListener;
import br.edu.univas.pcelab4.dao.EntradaDAO;
import br.edu.univas.pcelab4.dao.ProdutoDAO;
import br.edu.univas.pcelab4.model.Entrada;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.EntradaFrame;

public class EntradaController {
	EntradaFrame entradaFrame;
	ProdutoDAO daoProduto;
	EntradaDAO daoEntrada;
	int codigoEntrada;
	
	public EntradaController() {
		entradaFrame = new EntradaFrame();
		try {
			daoProduto = new ProdutoDAO();
			daoEntrada = new EntradaDAO();
		} catch (SQLException e) {
			System.out.println("Problemas com entrada de produtos");
			e.printStackTrace();
		}
		
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
		entradaFrame.atualizaListaProduto(daoProduto.getAllProdutos());
	}
	
	public void fecharTelaEntrada(){
		entradaFrame.setVisible(false);
	}
	
	public void registrarEntrada(){
		if(entradaFrame.getOrigem().getText().length()==0 || entradaFrame.getLocalArquivoNF().getText().length()==0){
			JOptionPane.showMessageDialog(null,"CAMPO NULO", "Alerta", JOptionPane.WARNING_MESSAGE);
		}
		
		Entrada entrada = new Entrada();
		entrada.setDataEntrada(entradaFrame.getPegaDataAtual());
		entrada.setOrigemEntrada(entradaFrame.getOrigem().getText());
		
		codigoEntrada=daoEntrada.salvarEntrada(entrada);
		if (codigoEntrada!=0) {
			JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	public void updateProduto(){
		Produto produto = new Produto();
		String caminhoNF = entradaFrame.getLocalArquivoNF().getText();
		
		produto = daoProduto.getProdutoByNome(entradaFrame.getProdutoSelecionado());
		
		int qtde = produto.getQtde();
		int qtdeEntrada = Integer.parseInt(entradaFrame.getQtdeEntrada().getText());
		qtde+=qtdeEntrada;
		
		int codigoProduto = produto.getCodigoProduto();
		String codigoUsuario=LoginController.getCpfAtual();
		
		daoProduto.updateTabelaProduto(qtde,codigoProduto);
		daoEntrada.salvarExecucaoEntrada(codigoProduto,codigoEntrada,codigoUsuario);
		daoProduto.salvarNF(caminhoNF, codigoProduto);
		
			
		
	}
}
