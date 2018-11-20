package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.univas.pcelab4.model.Produto;

public class ProdutoDAO {
	private Connection connection;
	
	public ProdutoDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	

	public boolean salvar(Produto produto) {
		int index=1;
		String sql = "insert into produto (nome, valor, estoque_minimo, quantidade)"
				+ "values (?, ?, ?, ? )";
		PreparedStatement st;
		
		try {
			st = connection.prepareStatement(sql);
			st.setString(index++, produto.getNome());
			st.setDouble(index++, produto.getValor());
			st.setInt(index++, produto.getQtdeMinima());
			st.setInt(index++, 0);
			st.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("PROBLEMAS PARA POPULAR A TABELA PRODUTO");
			e.printStackTrace();
			return false;
		}
		
		
	}

}
