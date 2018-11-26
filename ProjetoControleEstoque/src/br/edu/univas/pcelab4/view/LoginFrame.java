package br.edu.univas.pcelab4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.pcelab4.listener.UsuarioLoginListener;


public class LoginFrame extends JFrame {

	UsuarioLoginListener ListenerLogin;
	private JTextField JtfUser;
	private JTextField JtfPassword;
	
	public JTextField getJtfUser() {
		return JtfUser;
	}

	public void setJtfUser(JTextField jtfUser) {
		JtfUser = jtfUser;
	}

	public JTextField getJtfPassword() {
		return JtfPassword;
	}

	public void setJtfPassword(JTextField jtfPassword) {
		JtfPassword = jtfPassword;
	}
	
	public LoginFrame() {
		this.setTitle("D.A - Controle de Estoque");
		this.setSize(new Dimension(800,600));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	public void setListenerLogar(UsuarioLoginListener LoginListener) {
		this.ListenerLogin = LoginListener;
	}
	
	private void addComponents() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("D.A - Controle de Estoque - Tela Login");
		northPanel.add(lblTitulo);
		
		this.add(northPanel,BorderLayout.NORTH);
		
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,3,10,10);
		
		JLabel lblUser = new JLabel();
		lblUser.setText("Informe o usuario:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		CenterPanel.add(lblUser,gbc);
		
		JtfUser = new JTextField();
		JtfUser.setPreferredSize(new Dimension(550,25));
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		CenterPanel.add(JtfUser,gbc);
		
		JLabel lblPassord = new JLabel();
		lblPassord.setText("Informe a senha:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		CenterPanel.add(lblPassord,gbc);
		
		JtfPassword = new JTextField();
		JtfPassword.setPreferredSize(new Dimension(550,25));
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		CenterPanel.add(JtfPassword,gbc);
		
		AddButtons(CenterPanel,gbc);
		
		this.add(CenterPanel,BorderLayout.CENTER);
		
		
		
		
	}

	private void AddButtons(JPanel panel,GridBagConstraints gbc) {
		// TODO Auto-generated method stub
		
		JButton BtnLogin = new JButton();
		BtnLogin.setText("Entrar no sistema");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.EAST;
		panel.add(BtnLogin, gbc);
		
		BtnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListenerLogin.LogarSistema();
			}

			
		});
		
		this.add(panel);
	}
	
	
	
}
