package br.edu.univas.pcelab4.view;

import java.awt.BorderLayout;
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

import br.edu.univas.pcelab4.listener.CadastraProdutoListener;

public class CadastroProdutoFrame extends JFrame{
	JTextField campoNome;
	JTextField campoQtdeMinima;
	JTextField campoValor;
	
	
	CadastraProdutoListener listener;
	public void setListener(CadastraProdutoListener listener){
		this.listener = listener;
	}
	
	public CadastroProdutoFrame(){
		this.setTitle("Cadastro de Produto");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new BorderLayout());
		JPanel painelNorte = new JPanel();
		
		JLabel tituloLabel = new JLabel();
		tituloLabel.setText("D.A - Controle de Estoque - Tela Cadastro de Produto");
		painelNorte.add(tituloLabel);
		this.add(painelNorte, BorderLayout.NORTH);
		
		JPanel painelCentral = new JPanel();
		painelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nomeLabel = new JLabel();
		nomeLabel.setText("Nome: ");
		gbc.gridx=0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);
		painelCentral.add(nomeLabel,gbc);
		
		campoNome = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(campoNome,gbc);
		
		JLabel qtdeMinimaLabel = new JLabel();
		qtdeMinimaLabel.setText("Quantidade Minima: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		painelCentral.add(qtdeMinimaLabel,gbc);
		
		campoQtdeMinima = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(campoQtdeMinima,gbc);
		
		JLabel valorLabel = new JLabel();
		valorLabel.setText("Valor: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		painelCentral.add(valorLabel,gbc);
		
		campoValor = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		painelCentral.add(campoValor, gbc);
		
		JButton botaoCadastrar = new JButton();
		botaoCadastrar.setText("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.salvaProduto();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		//gbc.fill = GridBagConstraints.NONE;
		//gbc.anchor = GridBagConstraints.CENTER;
		//gbc.weightx = 0.0;
		painelCentral.add(botaoCadastrar, gbc);
		
		JButton botaoSair = new JButton();
		botaoSair.setText("Sair");
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.sairTelaCadastro();
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		//gbc.fill = GridBagConstraints.NONE;
		//gbc.anchor = GridBagConstraints.CENTER;
		//gbc.weightx = 0.0;
		painelCentral.add(botaoSair, gbc);
		
		
		
		this.add(painelCentral, BorderLayout.CENTER);
		
		
		
		
		
		
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoQtdeMinima() {
		return campoQtdeMinima;
	}

	public void setCampoQtdeMinima(JTextField campoQtdeMinima) {
		this.campoQtdeMinima = campoQtdeMinima;
	}

	public JTextField getCampoValor() {
		return campoValor;
	}

	public void setCampoValor(JTextField campoValor) {
		this.campoValor = campoValor;
	}
}
