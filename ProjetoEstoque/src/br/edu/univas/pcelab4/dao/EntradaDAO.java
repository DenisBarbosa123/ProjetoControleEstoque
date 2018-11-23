package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.univas.pcelab4.model.Entrada;

public class EntradaDAO {
private Connection connection;
	
	public EntradaDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}

	public boolean salvarEntrada(Entrada entrada) {
		int index = 1;
		String sql = "insert into entrada (data, origem )"
				+ "values (?,?)";
		
		PreparedStatement st;
		
		try {
			st = connection.prepareStatement(sql);
			java.sql.Date dateSql = new java.sql.Date(entrada.getDataEntrada().getTime());
			st.setDate(index++, dateSql);
			st.setString(index++, entrada.getOrigemEntrada());
			st.execute();
			return true;
			
		} catch (Exception e) {
			System.out.println("erro ao popular tabela entrada");
			e.printStackTrace();
			return false;
		}
	}
}
