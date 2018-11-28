package br.edu.univas.pcelab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.pcelab4.listener.RelatorioProdutoListener;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.model.Usuario;

public class TelaRelatorioUsuario extends JFrame {
	
	private RelatorioProdutoListener listenerRelatorio;
	private JTable tblRelatorio;
	private JScrollPane jspRelatorio;
	public void setListenerRelatorio(RelatorioProdutoListener listener) {
		listenerRelatorio = listener;
	}
	
	public TelaRelatorioUsuario() {
		// TODO Auto-generated constructor stub
		this.setTitle("Tela relatorio usuário");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 20, 5);
			
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Relatório de Usuários");
		gbc.gridy =0;
		gbc.gridy =0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(lblTitulo,gbc);
		
		Vector<String> columns = new Vector<>();
		
		columns.add("CPF");
		columns.add("Nome");
		columns.add("Cargo");
		columns.add("E-mail");
		columns.add("Telefone");
		
		tblRelatorio = new JTable(null,columns);
		
		jspRelatorio = new JScrollPane(tblRelatorio);
		jspRelatorio.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jspRelatorio.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		gbc.gridy = 1;
		this.add(jspRelatorio, gbc);
		
		JButton btnGerarRelatorio = new JButton("Gerar PDF");
		gbc.gridy = 2;
		
		btnGerarRelatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listenerRelatorio.createPDF();
			}
		});
	
	
		this.add(btnGerarRelatorio, gbc);
		
	}
	
	public void updateUsers(ArrayList<Usuario> userRelatorio) {
		DefaultTableModel model = (DefaultTableModel) tblRelatorio.getModel();
		
		model.setRowCount(0);
		
		for (Usuario usuario : userRelatorio) {
			model.addRow(new Object[] {
					usuario.getCpf(),
					usuario.getNome(),
					usuario.getCargo(),
					usuario.getEmail(),
					usuario.getTelefone()
			});
		}
	}
	
}
