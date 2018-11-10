package br.edu.univas.pcelab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.univas.pcela4.listener.CadastraUsuarioListener;

public class CadastroUsuarioFrame extends JFrame{
	CadastraUsuarioListener listener;
	
	public CadastroUsuarioFrame(){
		this.setSize(600,600);
		this.setName("Tela de Cadastro de Usu�rio");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
		
	}

	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.FIRST_LINE_START;
		this.add(cpfLabel, gbc);
		
		JTextField campoCpf = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.00;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoCpf, gbc);
		
		JLabel nomeLabel = new JLabel();
		nomeLabel.setText("Nome: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.FIRST_LINE_START;
		this.add(nomeLabel,gbc);
		
		JTextField campoNome = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.00;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoNome, gbc);
		
	}
}

