package br.edu.univas.pcelab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.univas.pcela4.listener.GerenteListener;
import br.edu.univas.pcelab4.controller.GerenteController;

public class GerenteFrame extends JFrame{
	
	private GerenteListener gerenteListener;
	
	public GerenteFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setTitle("Tela Gerente");
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
		
		JButton btnRelatorioEntrada = new JButton("Entrada");
		gbc.gridy = 1;
		
		btnRelatorioEntrada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gerenteListener.ShowPageTelaEntradaRelatorio();
			}
		});
		
		this.add(btnRelatorioEntrada, gbc);
		
		
		
		JButton btnRelatorioSaida = new JButton("Saida");
		gbc.gridy = 2;
		this.add(btnRelatorioSaida, gbc);
			
	}
	
	
}
