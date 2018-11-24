package br.edu.univas.pcelab4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.pcela4.listener.SaidaListener;
import br.edu.univas.pcelab4.model.Produto;

public class SaidaFrame extends JFrame{
	SaidaListener listener;
	
	Date dataAtual;
	JTextField destino;
	JComboBox<String> listaDeProdutos;
	JTextField qtdeSaida;
	
	public void setListener(SaidaListener listener){
		this.listener = listener;
	}
	
	public SaidaFrame() {
		this.setTitle("Saida de Produtos");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new BorderLayout());
		JPanel painelNorte = new JPanel();
		
		JLabel tituloLabel = new JLabel();
		tituloLabel.setText("D.A - Controle de Estoque - Registrar Saida de Produto");
		painelNorte.add(tituloLabel);
		this.add(painelNorte, BorderLayout.NORTH);
		
		JPanel painelCentral = new JPanel();
		painelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel produtosListados = new JLabel();
		produtosListados.setText("Escolha o produto que deseja dar saida no estoque: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx =0.0;
		gbc.insets = new Insets(5, 5, 5, 5);
		painelCentral.add(produtosListados, gbc);
		
		listaDeProdutos = new JComboBox<>();
		listaDeProdutos.setPreferredSize(new Dimension(100, 30));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(listaDeProdutos, gbc);
		
		JLabel qtdeLabel = new JLabel();
		qtdeLabel.setText("Quantidade: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		painelCentral.add(qtdeLabel, gbc);
		
		qtdeSaida = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(qtdeSaida, gbc);
		
		JLabel destinoLabel = new JLabel();
		destinoLabel.setText("Destino: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		painelCentral.add(destinoLabel, gbc);
		
		destino = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(destino, gbc);
		
		JButton botaoRegistrar = new JButton();
		botaoRegistrar.setText("Registrar");
		botaoRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.registraSaida();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		painelCentral.add(botaoRegistrar, gbc);
		
		JButton botaoSair = new JButton();
		botaoSair.setText("Sair");
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.sairTelaSaida();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.gridwidth = 2;
		//gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		painelCentral.add(botaoSair, gbc);
		
		
		this.add(painelCentral, BorderLayout.CENTER);
		
	}
	
	public void atualizaListaProduto(ArrayList<Produto> produtos){
		listaDeProdutos.removeAll();
		for (Produto produto : produtos) {
			listaDeProdutos.addItem(produto.getNome());
		}
		
	}
	
	public String getProdutoSelecionado(){
		String produto = listaDeProdutos.getSelectedItem()+"";
		return produto;
	}

	public Date getDataAtual() {
		Date dataAtual = new Date();
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public JTextField getDestino() {
		return destino;
	}

	public void setDestino(JTextField destino) {
		this.destino = destino;
	}

	public JTextField getQtdeSaida() {
		return qtdeSaida;
	}

	public void setQtdeSaida(JTextField qtdeSaida) {
		this.qtdeSaida = qtdeSaida;
	}
	
	
}
