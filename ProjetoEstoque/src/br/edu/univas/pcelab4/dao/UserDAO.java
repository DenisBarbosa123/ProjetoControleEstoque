package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.univas.pcelab4.model.Endereco;
import br.edu.univas.pcelab4.model.Usuario;

public class UserDAO {
	private Connection connection;
	
	public UserDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	
	public void salvarUser(Usuario usuario){
		int index = 1;
		String sql = "insert into usuario (cpf, nome, telefone, email, login, senha, fk_cargo)"
				+ "values(?,?,?,?,?,?,?)";
		
		PreparedStatement statement;
		
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(index++, usuario.getCpf());
			statement.setString(index++, usuario.getNome());
			statement.setString(index++, usuario.getTelefone());
			statement.setString(index++, usuario.getEmail());
			statement.setString(index++, usuario.getUserName());
			statement.setString(index++, usuario.getPassword());
			statement.setInt(index++, 1);
			statement.execute();
		}catch(SQLException e){
			System.out.println("Problemas para popular a tabela usuario");
			e.printStackTrace();
		}
	}
	
	public void salvarEndereco(Usuario usuario,Endereco endereco){
		int index = 1;
		String sql = "insert into endereco (fk_usuario, rua, numero, bairro, cep)"+
		"values (?,?,?,?,?)";
		
		PreparedStatement statement;
			
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(index++, usuario.getCpf());
			statement.setString(index++, endereco.getRua());
			statement.setInt(index++, Integer.parseInt(endereco.getNumero()));
			statement.setString(index++, endereco.getBairro());
			statement.setString(index++, endereco.getCep());
			statement.execute();
		}catch(SQLException e){
			System.out.println("Problemas para popular tabela endereco");
			e.printStackTrace();
		}
	}
}
