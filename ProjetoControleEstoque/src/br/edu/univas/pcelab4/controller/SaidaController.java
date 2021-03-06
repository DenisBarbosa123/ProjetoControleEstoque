package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.univas.pcelab4.listener.SaidaListener;
import br.edu.univas.pcelab4.dao.ProdutoDAO;
import br.edu.univas.pcelab4.dao.SaidaDAO;
import br.edu.univas.pcelab4.dao.UserDAO;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.model.Saida;
import br.edu.univas.pcelab4.view.SaidaFrame;

public class SaidaController {
	SaidaFrame saidaFrame;
	ProdutoDAO produtoDAO;
	SaidaDAO saidaDAO;
	int codigoSaida;
	UserDAO userDAO;
	
	public SaidaController() {
		saidaFrame = new SaidaFrame();
		try {
			produtoDAO = new ProdutoDAO();
			saidaDAO = new SaidaDAO();
			userDAO = new UserDAO();
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
				JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
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
		int qtdeSaida=0;
		
		try {
			qtdeSaida = Integer.parseInt(saidaFrame.getQtdeSaida().getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(saidaFrame, this, "Campo Quantidade saida s� aceita n�meros!",JOptionPane.INFORMATION_MESSAGE, null);
		}
		
		int codigoProduto = produto.getCodigoProduto();
		String codigoUsuario=LoginController.getCpfAtual();
		
		qtde-=qtdeSaida;
		
		if(qtde<0){
			System.out.println("quantidade invalida");

		}else{
			if(qtde<=qtdeMinima){
				JavaMailApp email = new JavaMailApp();
				email.enviarEmail(Integer.toString(qtde),produto.getNome(),userDAO.getAllEmailComercial());
				produtoDAO.updateTabelaProduto(qtde, codigoProduto);
				saidaDAO.salvarExecucaoSaida(codigoSaida, codigoProduto, codigoUsuario);
				System.out.println("feito update na tabela produto e enviado email");
			}else{
				produtoDAO.updateTabelaProduto(qtde, codigoProduto);
				saidaDAO.salvarExecucaoSaida(codigoSaida, codigoProduto, codigoUsuario);
				System.out.println("feito update na tabela produto");
				clearFields();
			}
		}
	}
	
	private void clearFields() {
		List<JTextField> fields = Arrays.asList(
				saidaFrame.getQtdeSaida(),
				saidaFrame.getDestino());
				
		
		for(JTextField jTextField:fields){
			clearField(jTextField);
		}
		
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
}
