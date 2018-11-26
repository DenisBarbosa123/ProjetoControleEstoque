package br.edu.univas.pcelab4.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.univas.pcela4.listener.GerenteListener;
import br.edu.univas.pcela4.listener.RelatorioProdutoListener;
import br.edu.univas.pcelab4.dao.GerenteDAO;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.view.GerenteFrame;
import br.edu.univas.pcelab4.view.TelaRelatorioEntradaFrame;

public class GerenteController {
	GerenteFrame gerenteFrame;
	TelaRelatorioEntradaFrame frameEntrada;
	GerenteDAO daoGerente;
	
	
	public GerenteController() throws SQLException{
		gerenteFrame = new GerenteFrame();
		frameEntrada = new TelaRelatorioEntradaFrame();
		daoGerente = new GerenteDAO();
		
		gerenteFrame.setListenerRelatorio(new GerenteListener() {

			@Override
			public void ShowPageTelaEntradaRelatorio() {
				// TODO Auto-generated method stub
				abrirTelaEntradaRelatorio();
			}
		});
		
		frameEntrada.setListenerRelatorio(new RelatorioProdutoListener() {
			
			@Override
			public void createPDF() {
				// TODO Auto-generated method stub
				Print();
			}
		});
	
		
	}
	
	public void abrirTelaGerente(){
		gerenteFrame.setVisible(true);
	}
	
	public void abrirTelaEntradaRelatorio() {
		frameEntrada.setVisible(true);
		frameEntrada.updateStudents(daoGerente.getAllRelatorioProduto());
	}
	
private void Print() {
		
		com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		
		ArrayList<Produto> data = daoGerente.getAllRelatorioProduto();
		
		try {
			
			
			PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
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
}
