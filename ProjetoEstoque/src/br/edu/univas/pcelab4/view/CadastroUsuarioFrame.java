package br.edu.univas.pcelab4.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.univas.pcela4.listener.CadastraUsuarioListener;

public class CadastroUsuarioFrame extends JFrame{
	CadastraUsuarioListener listener;
	
	public void setListener(CadastraUsuarioListener listener){
		this.listener = listener;
	}
	
	public CadastroUsuarioFrame(){
		this.setSize(500,500);
		this.setTitle("Tela de Cadastro de Usu�rio");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
		
	}

	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel textoCadastro = new JLabel();
		textoCadastro.setText("Cadastro de Usu�rio");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(textoCadastro);
		
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		//gbc.fill = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(15,15,15,15);
		this.add(cpfLabel, gbc);
		
		JTextField campoCpf = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoCpf, gbc);
		
		JLabel nomeLabel = new JLabel();
		nomeLabel.setText("Nome: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		this.add(nomeLabel,gbc);
		
		JTextField campoNome = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoNome, gbc);
		
		JLabel emailLabel = new JLabel();
		emailLabel.setText("E-mail:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		this.add(emailLabel, gbc);
		
		JTextField campoEmail = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoEmail, gbc);
		
		JLabel userNameLabel = new JLabel();
		userNameLabel.setText("Login:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		this.add(userNameLabel, gbc);
		
		JTextField campoUser = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoUser, gbc);

		JLabel senhaLabel = new JLabel();
		senhaLabel.setText("Senha:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		this.add(senhaLabel, gbc);
		
		JTextField campoSenha = new JTextField();
		campoSenha.setColumns(15);
		gbc.gridx = 1;
		gbc.weightx = 1.00;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoSenha,gbc);
		
		JLabel senhaConfLabel = new JLabel();
		senhaConfLabel.setText("Confirme senha:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 0.0;
		this.add(senhaConfLabel, gbc);
		
		JTextField campoSenhaConf = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoSenhaConf, gbc);
		
		JButton botaoSalvarUsuario = new JButton();
		botaoSalvarUsuario.setText("Cadastrar Usuario");
		botaoSalvarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.salvarUsuario();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoSalvarUsuario,gbc);
	
	}
}

