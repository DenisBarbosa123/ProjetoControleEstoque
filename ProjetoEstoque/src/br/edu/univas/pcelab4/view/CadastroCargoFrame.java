package br.edu.univas.pcelab4.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroCargoFrame extends JFrame{
	JTextField campoCargo;
	
	public CadastroCargoFrame(){
		this.setTitle("Tela de Cadastro de Cargo");
		this.setSize(400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new FlowLayout());
		JLabel cargoLabel = new JLabel();
		cargoLabel.setText("Nome do cargo: ");
		this.add(cargoLabel);
		
		campoCargo = new JTextField();
		campoCargo.setColumns(20);
		this.add(campoCargo);
		
		JButton botaoCadastrarCargo = new JButton();
		botaoCadastrarCargo.setText("Cadastrar cargo");
		this.add(botaoCadastrarCargo);
		
		JButton botaoSair = new JButton();
		botaoSair.setText("Cancelar");
		botaoCadastrarCargo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//implementar interface listener para programa sair
				
			}
		});
		this.add(botaoSair);
		
		
	}
}
