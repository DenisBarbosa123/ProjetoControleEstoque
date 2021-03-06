package br.edu.univas.pcelab4.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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


	public ArrayList<Produto> getAllProdutos() {
		ArrayList<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";
		
		try{
			java.sql.Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				Produto produto = new Produto();
				produto.setCodigoProduto(rs.getInt("codigo_produto"));
				produto.setNome(rs.getString("nome"));
				produtos.add(produto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return produtos;

	}
	
	public Produto getProdutoByNome(String nome){
		Produto produto = new Produto();
		String sql = "select codigo_produto, nome, quantidade, estoque_minimo from produto where nome = "+ "'"+nome+"'";
		
		try {
			java.sql.Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				produto.setCodigoProduto(rs.getInt("codigo_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setQtde(rs.getInt("quantidade"));
				produto.setQtdeMinima(rs.getInt("estoque_minimo"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
	}
	
	public boolean updateTabelaProduto(int qtde, int codigoProduto){
		int index = 1;
		String sql = "update produto set quantidade = ? where codigo_produto = ?";
		
		PreparedStatement st;
		
		try {
			st = connection.prepareStatement(sql);
			st.setInt(index++, qtde);
			st.setInt(index++, codigoProduto);
			st.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("erro no update da tabela produto");
			e.printStackTrace();
		}
		
		return false;
	}


	public void salvarNF(String caminhoNF, int codigoProduto) {
		int index = 1;
		String sql = "insert into notafiscal (fk_produto, caminho_nf)"+
		 "values (?,?)";
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(index++, codigoProduto);
			statement.setString(index++, caminhoNF);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Produto> getAllRelatorioProduto() {
		ArrayList<Produto> dataEntrada = new ArrayList<>();
		
		String sql = "select * from produto";
		
		 //statement;
		
		try {
			java.sql.Statement statement = connection.createStatement();
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
		
		return dataEntrada;
		
	}




	

}
