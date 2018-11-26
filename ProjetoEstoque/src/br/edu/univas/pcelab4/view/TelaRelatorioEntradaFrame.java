package br.edu.univas.pcelab4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.univas.pcela4.listener.GerenteListener;
import br.edu.univas.pcela4.listener.RelatorioProdutoListener;
import br.edu.univas.pcelab4.model.Produto;

public class TelaRelatorioEntradaFrame extends JFrame{
	
	private JTable tblRelatorio;
	private JScrollPane jspRelatorio;
	private RelatorioProdutoListener listenerRelatorio;
	
	public TelaRelatorioEntradaFrame() {
		this.setTitle("Relatorio de entrada de materiais");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
		
	}

	public void setListenerRelatorio(RelatorioProdutoListener listener) {
		listenerRelatorio = listener;
	}
	
	
	private void addComponents() {
		// TODO Auto-generated method stub
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 20, 5);
			
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Relatório de entrada");
		gbc.gridy =0;
		gbc.gridy =0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(lblTitulo,gbc);
		
		Vector<String> columns = new Vector<>();
				
		columns.add("Codigo");
		columns.add("Nome");
		columns.add("valor");
		columns.add("Quiantidade minima");
		columns.add("Quantidade disponivel");
		 
		tblRelatorio = new JTable(null,columns);
		
		jspRelatorio = new JScrollPane(tblRelatorio);
		jspRelatorio.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jspRelatorio.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		gbc.gridy = 1;
		this.add(jspRelatorio, gbc);
		
		JButton btnGerarRelatorio = new JButton("Gerar relatorio");
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

	public void updateStudents(ArrayList<Produto> produtoRelatorio) {
		DefaultTableModel model = (DefaultTableModel) tblRelatorio.getModel();
		
		model.setRowCount(0);
		
		for (Produto produto : produtoRelatorio) {
			model.addRow(new Object[] {
					produto.getCodigoProduto(),
					produto.getNome(),
					produto.getValor(),
					produto.getQtdeMinima(),
					produto.getQtde(),
			});
		}
}
	
}
