package br.edu.univas.pcelab4.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.univas.pcela4.listener.TelaPrincipalListener;

public class TelaInicialFrame extends JFrame {
	TelaPrincipalListener listener;
	
	public void setListener(TelaPrincipalListener listener){
		this.listener = listener;
	}

	public TelaInicialFrame() {
		this.setTitle("D.A - Controle de Estoque - Tela Inicial");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
		
	}

	private void addComponents() {
		this.setLayout(new FlowLayout());
		JLabel textoPrincipal = new JLabel();
		textoPrincipal.setText("D.A - Controle de Estoque - Tela Inicial");
		this.add(textoPrincipal);
		
		JButton botaoEntrar = new JButton();
		botaoEntrar.setText("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.exibirTelaLogin();
				
			}
		});
		this.add(botaoEntrar);
		
		JButton botaoSair = new JButton();
		botaoSair.setText("Sair");
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.sairTelaPrincipal();
				
			}
		});
		this.add(botaoSair);
		
	}
	
}
