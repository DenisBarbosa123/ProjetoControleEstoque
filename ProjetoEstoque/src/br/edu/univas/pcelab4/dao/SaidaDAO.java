package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.univas.pcelab4.model.Saida;

public class SaidaDAO {
	private Connection connection;
	
	public SaidaDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public int salvarSaida(Saida saida){
		int codigoSaida=0;
		
		int index = 1;
		String sql = "insert into saida (data, destino )"
				+ "values (?,?)";
		
		PreparedStatement st;
		
		try {
			st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			java.sql.Date dateSql = new java.sql.Date(saida.getDataSaida().getTime());
			st.setDate(index++, dateSql);
			st.setString(index++, saida.getDestino());
			st.execute();
			
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()){
				codigoSaida = rs.getInt("codigo_saida");
			}
			
			
		} catch (Exception e) {
			System.out.println("erro ao popular tabela saida");
			e.printStackTrace();
			//return 0;
		}
		
		return codigoSaida;
	}
	
	public void salvarExecucaoSaida(int codigoSaida, int codigoProduto,String codigoUser){
		int index = 1;
		String sql = "insert into realiza_saida(fk_usuario, fk_produto, fk_saida)"+
		"values(?,?,?)";
		
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(index++, codigoUser);
			ps.setInt(index++, codigoProduto);
			ps.setInt(index++, codigoSaida);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro na hora de popular tabela realiza_saida");
		}
	}
}
