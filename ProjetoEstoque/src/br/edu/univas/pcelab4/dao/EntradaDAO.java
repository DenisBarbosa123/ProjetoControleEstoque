package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import br.edu.univas.pcelab4.model.Entrada;

public class EntradaDAO {
private Connection connection;
	
	public EntradaDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}

	public int salvarEntrada(Entrada entrada) {
		int codigoEntrada = 0;
		int index = 1;
		String sql = "insert into entrada (data, origem )"
				+ "values (?,?)";
		
		PreparedStatement st;
		
		try {
			st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			java.sql.Date dateSql = new java.sql.Date(entrada.getDataEntrada().getTime());
			st.setDate(index++, dateSql);
			st.setString(index++, entrada.getOrigemEntrada());
			st.execute();
			
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()){
				codigoEntrada = rs.getInt("codigo_entrada");
			}
			
			
		} catch (Exception e) {
			System.out.println("erro ao popular tabela entrada");
			e.printStackTrace();
			return 0;
		}
		return codigoEntrada;
	}

	public void salvarExecucaoEntrada(int codigoProduto, int codigoEntrada, String codigoUsuario) {
		int index = 1;
		String sql = "insert into executa_entrada(fk_usuario, fk_produto, fk_entrada)"+
		"values(?,?,?)";
		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(index++, codigoUsuario);
			ps.setInt(index++, codigoProduto);
			ps.setInt(index++, codigoEntrada);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro na hora de popular tabela executa_entrada");
		}
		
	}
	
		
	
	
}
