package br.edu.univas.pcelab4.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.univas.pcela4.listener.EstoquistaListener;

public class EstoquistaFrame extends JFrame{
	
	EstoquistaListener listener;
	
	public void setListener(EstoquistaListener listener){
		this.listener = listener;
	}

	public EstoquistaFrame(){
		this.setTitle("Tela Principal Estoquista");
		this.setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new FlowLayout());
		JLabel estoquistaLabel = new JLabel();
		estoquistaLabel.setText("Tela Principal Estoquista");
		this.add(estoquistaLabel);
		
		JButton botaoSalvaProduto = new JButton();
		botaoSalvaProduto.setText("Cadastrar Produto");
		botaoSalvaProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.cadastrarProduto();
				
			}
		});
		this.add(botaoSalvaProduto);
		
		JButton botaoSaidaProduto = new JButton();
		botaoSaidaProduto.setText("Saida de Produto");
		botaoSaidaProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listener.saidaProduto();
			}
		});
		this.add(botaoSaidaProduto);
		
		JButton botaoEntradaProduto = new JButton();
		botaoEntradaProduto.setText("Entrada de Produto");
		botaoEntradaProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.cadastrarProduto();
				
			}
		});;
		this.add(botaoEntradaProduto);
		
		
		
	}
	
	
}
