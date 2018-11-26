package br.edu.univas.pcelab4.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.univas.pcelab4.listener.AdministradorListener;


public class AdministradorFrame extends JFrame{
	AdministradorListener listener;
	
//	exibirTelaCadastroUsuarioListener listener;
//	exibirTelaCadastroCargo listenerCargo;
	
	public void setListener(AdministradorListener listener){
		this.listener=listener;
	}
	
	
	
	public AdministradorFrame(){
		this.setSize(300, 300);
		this.setTitle("Tela Principal Adminstrador");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
		
	}

	private void addComponents() {
		this.setLayout(new FlowLayout());
		JLabel tituloAdm = new JLabel();
		tituloAdm.setText("Tela Principal : Administrador");
		this.add(tituloAdm);
		
		JButton botaoCadastroUsuario = new JButton();
		botaoCadastroUsuario.setText("Cadastro de Usuário");
		botaoCadastroUsuario.setPreferredSize(new Dimension(200,30));
		botaoCadastroUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.abreTelaCadastroUsuario();
				
			}
		});
		this.add(botaoCadastroUsuario);
		
		JButton botaoCadastrarCargo = new JButton();
		botaoCadastrarCargo.setText("CadastrarCargo");
		botaoCadastrarCargo.setPreferredSize(new Dimension(200, 30));
		botaoCadastrarCargo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.abreTelaCadastroCargo();
				
			}
		});
		this.add(botaoCadastrarCargo);
		
		
		
		
		
	}
}
