package br.edu.univas.pcelab4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.pcela4.listener.EntradaListener;

public class EntradaFrame extends JFrame{
	EntradaListener listener;
	JTextField qtdeEntrada;
	JTextField localArquivoNF;
	JComboBox<String> listaDeProdutos;
	
	
	public void setListener(EntradaListener listener){
		this.listener = listener;
	}
	
	public EntradaFrame() {
		this.setTitle("Entrada de Produtos");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		localArquivoNF = new JTextField();
		localArquivoNF.setEditable(false);
		addComponents();
		
	}

	private void addComponents() {
		this.setLayout(new BorderLayout());
		JPanel painelNorte = new JPanel();
		
		JLabel tituloLabel = new JLabel();
		tituloLabel.setText("D.A - Controle de Estoque - Registrar Entrada de Produto");
		painelNorte.add(tituloLabel);
		this.add(painelNorte, BorderLayout.NORTH);
		
		JPanel painelCentral = new JPanel();
		painelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel produtosListados = new JLabel();
		produtosListados.setText("Escolha o produto que deseja dar entrada no estoque: ");
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
		//gbc.gridy = 1;
		//gbc.weightx = 1.0;
		painelCentral.add(listaDeProdutos, gbc);
		
		JLabel qtdeLabel = new JLabel();
		qtdeLabel.setText("Quantidade: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		painelCentral.add(qtdeLabel, gbc);
		
		qtdeEntrada = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 3;
		//gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(qtdeEntrada, gbc);
		
		JLabel localArquivo = new JLabel();
		localArquivo.setText("Escolha a nota fiscal do produto: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		painelCentral.add(localArquivo, gbc);
		
		JButton botaoSelecionarArquivo = new JButton();
		botaoSelecionarArquivo.setText("...");
		botaoSelecionarArquivo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if(i==1){
					localArquivoNF.setText("");
				}else{
					File arquivo = file.getSelectedFile();
					localArquivoNF.setText(arquivo.getPath());
					//System.out.println(localArquivoNF.getText());
				}
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		painelCentral.add(botaoSelecionarArquivo, gbc);
		
		JButton botaoRegistrar = new JButton();
		botaoRegistrar.setText("Registrar");
		botaoRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.registraEntrada();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 6;
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
				listener.sairTelaEntrada();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.NONE;
		//gbc.gridwidth = 2;
		//gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		painelCentral.add(botaoSair, gbc);
		
		
		this.add(painelCentral, BorderLayout.CENTER);
		
		
		
	}
	
	public void selecionarArquivo(){
		
	}
}
