package br.edu.univas.pcelab4.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.univas.pcelab4.model.Entrada;
import br.edu.univas.pcelab4.model.Produto;
import br.edu.univas.pcelab4.model.Usuario;

public class GerenteDAO {

	private Connection connection;
	
	public GerenteDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public ArrayList<Produto> getAllRelatorioProduto() {
		ArrayList<Produto> dataEntrada = new ArrayList<>();
		
		String sql = "select * from produto";
		
		Statement statement;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Produto produto = new Produto();
				produto.setCodigoProduto(resultSet.getInt("codigo_produto"));
				produto.setNome(resultSet.getString("nome"));
				produto.setValor(resultSet.getDouble("valor"));
				produto.setQtdeMinima(resultSet.getInt("estoque_minimo"));
				produto.setQtde(resultSet.getInt("quantidade"));
				dataEntrada.add(produto);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Chegou");
		return dataEntrada;
		
		
		
		
		
		
	}
}
