package br.edu.univas.pcelab4.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.univas.pcelab4.listener.CadastraUsuarioListener;
import br.edu.univas.pcelab4.model.Cargo;


public class CadastroUsuarioFrame extends JFrame{
	private CadastraUsuarioListener listener;

	 JTextField campoCpf;
	 JTextField campoNome;
	 JTextField campoEmail;
	 JTextField campoUser;
	 JTextField campoSenha;
	 JTextField campoTelefone;
	
	 JTextField campoRua;
	 JTextField campoNumero;
	 JTextField campoBairro;
	 JTextField campoCep;
	 
	 JComboBox<String> listaDeCargos;

	public void setListener(CadastraUsuarioListener listener){
		this.listener = listener;
		System.out.println("setListener" + listener);
	}
	
	public CadastroUsuarioFrame(){
		this.setSize(750,750);
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
		gbc.insets = new Insets(10,10,10,10);
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
		
		JLabel cargoLabel = new JLabel();
		cargoLabel.setText("Cargo:");
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 0.0;
		this.add(cargoLabel,gbc);
		
		listaDeCargos = new JComboBox<>();
		listaDeCargos.setPreferredSize(new Dimension(100, 40));
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(listaDeCargos, gbc);
		
		JLabel userNameLabel = new JLabel();
		userNameLabel.setText("Login:");
		gbc.gridx = 0;
		gbc.gridy = 10;
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
		gbc.gridy = 11;
		gbc.weightx = 0.0;
		this.add(senhaLabel, gbc);
		
		campoSenha = new JPasswordField();
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
		gbc.gridy = 12;
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
				listener.fecharTelaCadastroUsuario();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		this.add(botaoCancelar,gbc);
		
	
	}

//	public void exibirTelaSucesso(){
//		JOptionPane.showMessageDialog(null,this, "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
//	}
//	public void exibirTelaErro(){
//		JOptionPane.showMessageDialog(null,this, "Erro", JOptionPane.ERROR_MESSAGE);
//	}
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

	public JTextField getCampoTelefone() {
		return campoTelefone;
	}

	public JTextField getCampoRua() {
		return campoRua;
	}

	public void setCampoRua(JTextField campoRua) {
		this.campoRua = campoRua;
	}

	public JTextField getCampoNumero() {
		return campoNumero;
	}

	public void setCampoNumero(JTextField campoNumero) {
		this.campoNumero = campoNumero;
	}

	public JTextField getCampoBairro() {
		return campoBairro;
	}

	public void setCampoBairro(JTextField campoBairro) {
		this.campoBairro = campoBairro;
	}

	public JTextField getCampoCep() {
		return campoCep;
	}

	public void setCampoCep(JTextField campoCep) {
		this.campoCep = campoCep;
	}
	
	public void atualizaCargoLista(ArrayList<Cargo> cargos){
		listaDeCargos.removeAllItems();
		for (Cargo cargo : cargos) {
			listaDeCargos.addItem(cargo.getNome());
		}
		
	}

	public String getCampoCargo() {
		String cargo = listaDeCargos.getSelectedItem()+"";
		return cargo;
	}

//	public void setListaDeCargos(String cargo) {
//		this.listaDeCargos = cargo;
//	}
	
}

