package br.edu.univas.pcelab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.univas.pcelab4.listener.GerenteListener;

public class GerenteFrame extends JFrame{
	
	private GerenteListener gerenteListener;
	
	public GerenteFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setTitle("Tela Gerentse");
		this.setLocationRelativeTo(null);
		addComponents();
	}

	public void setListenerRelatorio(GerenteListener listener) {
		gerenteListener = listener;
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets =new Insets(5, 5, 25, 5);
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Relatórios");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(lblTitulo,gbc);
		
		JButton btnRelatorioProduto = new JButton("Produtos");
		gbc.gridy = 1;
		
		btnRelatorioProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gerenteListener.ShowPageTelaEntradaRelatorio();
			}
		});
		
		this.add(btnRelatorioProduto, gbc);
		
		
		
		JButton btnRelatorioUsuario = new JButton("Usuario");
		gbc.gridy = 2;
		btnRelatorioUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gerenteListener.ShowPageTelaUsuarioRelatorio();
				
			}
		});
		this.add(btnRelatorioUsuario, gbc);
			
	}
	
	
}
