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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.univas.pcela4.listener.CadastraUsuarioListener;

public class CadastroUsuarioFrame extends JFrame{
	CadastraUsuarioListener listener;
	
	 JTextField campoCpf;
	 JTextField campoNome;
	 JTextField campoEmail;
	 JTextField campoUser;
	 JTextField campoSenha;
	 JTextField campoSenhaConf;
	 JTextField campoTelefone;
	
	 JTextField campoRua;
	 JTextField campoNumero;
	 JTextField campoBairro;
	 JTextField campoCep;

	public void setListener(CadastraUsuarioListener listener){
		this.listener = listener;
	}
	
	public CadastroUsuarioFrame(){
		this.setSize(700,700);
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
		gbc.fill = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(15,15,15,15);
		this.add(cpfLabel, gbc);
		
		campoCpf = new JTextField();
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
		
		campoNome = new JTextField();
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
		
		campoEmail = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoEmail, gbc);
		
		JLabel telefoneLabel = new JLabel();
		telefoneLabel.setText("Telefone: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		this.add(telefoneLabel,gbc);
		
		campoTelefone = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoTelefone,gbc);
		
		JLabel ruaLabel = new JLabel();
		ruaLabel.setText("Rua: ");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		this.add(ruaLabel, gbc);
		
		campoRua = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoRua,gbc);
		
		JLabel numeroLabel = new JLabel();
		numeroLabel.setText("N�mero: ");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 0.0;
		this.add(numeroLabel,gbc);
		
		campoNumero = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoNumero, gbc);
		
		JLabel bairroLabel = new JLabel();
		bairroLabel.setText("Bairro: ");
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 0.0;
		this.add(bairroLabel,gbc);
		
		campoBairro = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoBairro,gbc);
		
		JLabel cepLabel = new JLabel();
		cepLabel.setText("CEP: ");
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.weightx = 0.0;
		this.add(cepLabel,gbc);
		
		campoCep = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoCep,gbc);
		
		JLabel userNameLabel = new JLabel();
		userNameLabel.setText("Login:");
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0.0;
		this.add(userNameLabel, gbc);
		
		campoUser = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoUser, gbc);

		JLabel senhaLabel = new JLabel();
		senhaLabel.setText("Senha:");
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.weightx = 0.0;
		this.add(senhaLabel, gbc);
		
		campoSenha = new JTextField();
		campoSenha.setColumns(15);
		gbc.gridx = 1;
		gbc.weightx = 1.00;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(campoSenha,gbc);
		
		JButton botaoSalvarUsuario = new JButton();
		botaoSalvarUsuario.setText("Cadastrar Usuario");
		botaoSalvarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					listener.salvarUsuario();
					
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoSalvarUsuario,gbc);
		
		JButton botaoCancelar = new JButton();
		botaoCancelar.setText("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoCancelar,gbc);
		
	
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JTextField getCampoUser() {
		return campoUser;
	}

	public JTextField getCampoSenha() {
		return campoSenha;
	}

	public JTextField getCampoSenhaConf() {
		return campoSenhaConf;
	}

	public JTextField getCampoTelefone() {
		return campoTelefone;
	}
}

