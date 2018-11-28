package br.edu.univas.pcelab4.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.univas.pcelab4.dao.ProdutoDAO;
import br.edu.univas.pcelab4.dao.UserDAO;
import br.edu.univas.pcelab4.listener.GerenteListener;
import br.edu.univas.pcelab4.listener.RelatorioProdutoListener;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.GerenteFrame;
import br.edu.univas.pcelab4.view.TelaRelatorioEntradaFrame;
import br.edu.univas.pcelab4.view.TelaRelatorioUsuario;

public class GerenteController {
	GerenteFrame gerenteFrame;
	TelaRelatorioEntradaFrame frameEntrada;
	ProdutoDAO produtoDAO;
	UserDAO userDAO;
	TelaRelatorioUsuario frameUserRelatorio;
	
	public GerenteController() throws SQLException{
		gerenteFrame = new GerenteFrame();
		frameEntrada = new TelaRelatorioEntradaFrame();
		produtoDAO = new ProdutoDAO();
		frameUserRelatorio = new TelaRelatorioUsuario();
		userDAO = new UserDAO();
		
		
		gerenteFrame.setListenerRelatorio(new GerenteListener() {

			@Override
			public void ShowPageTelaEntradaRelatorio() {
				// TODO Auto-generated method stub
				abrirTelaEntradaRelatorio();
			}

			@Override
			public void ShowPageTelaUsuarioRelatorio() {
				abrirTelaUsuarioRelatorio();
				
			}
		});
		
		frameEntrada.setListenerRelatorio(new RelatorioProdutoListener() {
			
			@Override
			public void createPDF() {
				// TODO Auto-generated method stub
				PrintProduto();
				JOptionPane.showMessageDialog(null, "PDF DE PRODUTOS GERADO !");
			}
		});
		
		frameUserRelatorio.setListenerRelatorio(new RelatorioProdutoListener() {
			
			@Override
			public void createPDF() {
				PrintUsuario();
				JOptionPane.showMessageDialog(null, "PDF DE USUARIOS GERADO!");
				
			}

			
		});
	
		
	}
	
	public void abrirTelaGerente(){
		gerenteFrame.setVisible(true);
	}
	
	public void abrirTelaEntradaRelatorio() {
		frameEntrada.setVisible(true);
		frameEntrada.updateProdutos(produtoDAO.getAllRelatorioProduto());
	}
	
	public void abrirTelaUsuarioRelatorio(){
		frameUserRelatorio.setVisible(true);
		frameUserRelatorio.updateUsers(userDAO.getAllUsuarios());
	}
	
	private void PrintProduto() {
			
			com.itextpdf.text.Document document = new com.itextpdf.text.Document();
			
			ArrayList<Produto> data = produtoDAO.getAllRelatorioProduto();
			
			try {
				
				
				PdfWriter.getInstance(document, new FileOutputStream("produtos.pdf"));
				document.open();
				
				Paragraph tituloPdf = new Paragraph("Relatório de Produto");
				tituloPdf.setAlignment(1);
				document.add(tituloPdf);
				tituloPdf = new Paragraph("\n");
				document.add(tituloPdf);
				
				
				PdfPTable table = new PdfPTable(5);
				
				PdfPCell celCodProduto = new PdfPCell(new Paragraph("Código"));
				PdfPCell celNomeProduto = new PdfPCell(new Paragraph("Produto"));
				PdfPCell celValorProduto = new PdfPCell(new Paragraph("Valor"));
				PdfPCell celQtdeMinima = new PdfPCell(new Paragraph("Quantidade minima"));
				PdfPCell celQuantidade = new PdfPCell(new Paragraph("Quantidade"));
				
				table.addCell(celCodProduto);
				table.addCell(celNomeProduto);
				table.addCell(celValorProduto);
				table.addCell(celQtdeMinima);
				table.addCell(celQuantidade);
				
				for(Produto produto : data) {
					celCodProduto = new PdfPCell(new Paragraph(produto.getCodigoProduto()+""));
					celNomeProduto = new PdfPCell(new Paragraph(produto.getNome()+ ""));
					celValorProduto = new PdfPCell(new Paragraph((float) produto.getValor() + "" ));
					celQtdeMinima = new PdfPCell(new Paragraph(produto.getQtdeMinima() + ""));
					celQuantidade = new PdfPCell(new Paragraph(produto.getQtde() + ""));
					
					table.addCell(celCodProduto);
					table.addCell(celNomeProduto);
					table.addCell(celValorProduto);
					table.addCell(celQtdeMinima);
					table.addCell(celQuantidade);
					
				}
				
				document.add(table);
				
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				document.close();
			}
	}
	
	public void PrintUsuario() {
		com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		
		ArrayList<Usuario> data = userDAO.getAllUsuarios();
		
		try {
			
			
			PdfWriter.getInstance(document, new FileOutputStream("usuarios.pdf"));
			document.open();
			
			Paragraph tituloPdf = new Paragraph("Relatório de Usuários");
			tituloPdf.setAlignment(1);
			document.add(tituloPdf);
			tituloPdf = new Paragraph("\n");
			document.add(tituloPdf);
			
			
			PdfPTable table = new PdfPTable(5);
			
			PdfPCell celCodUsuario = new PdfPCell(new Paragraph("CPF"));
			PdfPCell celNomeUsuario = new PdfPCell(new Paragraph("Nome"));
			PdfPCell celCargoUsuario = new PdfPCell(new Paragraph("Cargo"));
			PdfPCell celEmailUsuario = new PdfPCell(new Paragraph("E-mail"));
			PdfPCell celTelefoneUsuario = new PdfPCell(new Paragraph("Telefone"));
			
			table.addCell(celCodUsuario);
			table.addCell(celNomeUsuario);
			table.addCell(celCargoUsuario);
			table.addCell(celEmailUsuario);
			table.addCell(celTelefoneUsuario);
			
			for(Usuario usuario : data) {
				celCodUsuario = new PdfPCell(new Paragraph(usuario.getCpf()+""));
				celNomeUsuario = new PdfPCell(new Paragraph(usuario.getNome()+ ""));
				celCargoUsuario = new PdfPCell(new Paragraph(usuario.getCargo() + "" ));
				celEmailUsuario = new PdfPCell(new Paragraph(usuario.getEmail() + ""));
				celTelefoneUsuario = new PdfPCell(new Paragraph(usuario.getTelefone() + ""));
				
				table.addCell(celCodUsuario);
				table.addCell(celNomeUsuario);
				table.addCell(celCargoUsuario);
				table.addCell(celEmailUsuario);
				table.addCell(celTelefoneUsuario);
				
			}
			
			document.add(table);
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			document.close();
		}
	}
}
