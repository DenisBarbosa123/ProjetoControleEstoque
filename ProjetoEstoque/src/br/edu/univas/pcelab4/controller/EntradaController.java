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
	Usuario user;
	
	public EntradaController() {
		entradaFrame = new EntradaFrame();
		user = new Usuario();
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
				updateProduto();
				
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
			JOptionPane.showMessageDialog(null,"CAMPO NULO", "Confirmação", JOptionPane.WARNING_MESSAGE);
		}
		Entrada entrada = new Entrada();
		entrada.setDataEntrada(entradaFrame.getPegaDataAtual());
		entrada.setOrigemEntrada(entradaFrame.getOrigem().getText());
		if(daoEntrada.salvarEntrada(entrada)){
			JOptionPane.showMessageDialog(null,"ENTRADA FEITA COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null,"ENTRADA ABORTADA", "Confirmação", JOptionPane.ERROR_MESSAGE);
		}
//		String produtoEntrada = entradaFrame.getProdutoSelecionado();
//		
//		
		
		
	}
	
	public void updateProduto(){
		Produto produto = new Produto();
		String caminhoNF = entradaFrame.getLocalArquivoNF().getText();
		
		produto = daoProduto.getProdutoByNome(entradaFrame.getProdutoSelecionado());
		
		int qtde = produto.getQtde();
		int qtdeEntrada = Integer.parseInt(entradaFrame.getQtdeEntrada().getText());
		qtde+=qtdeEntrada;
		
		int codigoProduto = produto.getCodigoProduto();
		
		daoProduto.updateTabelaProduto(qtde, caminhoNF,codigoProduto);
		System.out.println(user.getCpf());
			
		
	}
}
