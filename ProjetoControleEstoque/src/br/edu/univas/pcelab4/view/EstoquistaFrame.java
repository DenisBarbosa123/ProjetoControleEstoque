package br.edu.univas.pcelab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.univas.pcelab4.listener.EstoquistaListener;

public class EstoquistaFrame extends JFrame{
	
	EstoquistaListener listener;
	
	public void setListener(EstoquistaListener listener){
		this.listener = listener;
	}

	public EstoquistaFrame(){
		this.setTitle("Tela Principal Estoquista");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel estoquistaLabel = new JLabel();
		estoquistaLabel.setText("Tela Principal Estoquista");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.insets = new Insets(10,10,10,10);
		this.add(estoquistaLabel,gbc);
		
		JButton botaoSalvaProduto = new JButton();
		botaoSalvaProduto.setText("Cadastrar Produto");
		botaoSalvaProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.exibeTelaCadastroProduto();;
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoSalvaProduto,gbc);
		
		JButton botaoSaidaProduto = new JButton();
		botaoSaidaProduto.setText("Saida de Produto");
		botaoSaidaProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.exibeTelaSaidaProduto();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoSaidaProduto,gbc);
		
		JButton botaoEntradaProduto = new JButton();
		botaoEntradaProduto.setText("Entrada de Produto");
		botaoEntradaProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.exibeTelaEntradaProduto();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoEntradaProduto,gbc);
		
		
		
	}
	
	
}
