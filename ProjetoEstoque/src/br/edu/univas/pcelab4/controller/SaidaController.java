package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.univas.pcela4.listener.SaidaListener;
import br.edu.univas.pcelab4.dao.ProdutoDAO;
import br.edu.univas.pcelab4.dao.SaidaDAO;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.model.Saida;
import br.edu.univas.pcelab4.view.SaidaFrame;

public class SaidaController {
	SaidaFrame saidaFrame;
	ProdutoDAO produtoDAO;
	SaidaDAO saidaDAO;
	int codigoSaida;
	
	public SaidaController() {
		saidaFrame = new SaidaFrame();
		try {
			produtoDAO = new ProdutoDAO();
			saidaDAO = new SaidaDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problemas com saida de produtos");
			e.printStackTrace();
		}
		
		saidaFrame.setListener(new SaidaListener() {
			
			@Override
			public void sairTelaSaida() {
				fecharTelaSaida();
				
			}
			
			@Override
			public void registraSaida() {
				registrarSaida();
				updateTabelaProduto();
				
			}
		});
	}
	
	public void abrirTelaSaida(){
		saidaFrame.setVisible(true);
		saidaFrame.atualizaListaProduto(produtoDAO.getAllProdutos());
	}
	
	public void fecharTelaSaida(){
		saidaFrame.setVisible(false);
	}
	
	public void registrarSaida(){
		if(saidaFrame.getQtdeSaida().getText().length()==0 || saidaFrame.getDestino().getText().length()==0){
			JOptionPane.showMessageDialog(null,"CAMPO NULO", "Alerta", JOptionPane.WARNING_MESSAGE);
		}else{
			Saida saida = new Saida();
			saida.setDataSaida(saidaFrame.getDataAtual());
			saida.setDestino(saidaFrame.getDestino().getText());
			codigoSaida = saidaDAO.salvarSaida(saida);
			if (codigoSaida!=0) {
				JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		
	}
	
	public void updateTabelaProduto(){
		Produto produto = new Produto();
		produto = produtoDAO.getProdutoByNome(saidaFrame.getProdutoSelecionado());
		
		int qtde = produto.getQtde();
		int qtdeMinima = produto.getQtdeMinima();
		int qtdeSaida = Integer.parseInt(saidaFrame.getQtdeSaida().getText());
		int codigoProduto = produto.getCodigoProduto();
		String codigoUsuario=LoginController.getCpfAtual();
		
		qtde-=qtdeSaida;
		
		if(qtde<=qtdeMinima){
			//Email.dispararEmail();
		}
//		System.out.print(qtde);
//		System.out.println(qtdeMinima);
		if(qtde>0){
			produtoDAO.updateTabelaProduto(qtde, codigoProduto);
			saidaDAO.salvarExecucaoSaida(codigoSaida, codigoProduto, codigoUsuario);
			System.out.println("feito update na tabela produto");
		}else{
			System.out.println("quantidade invalida");
		}
		
	}
}
