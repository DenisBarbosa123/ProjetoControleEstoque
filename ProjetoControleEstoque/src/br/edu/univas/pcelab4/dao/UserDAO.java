package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import br.edu.univas.pcelab4.model.Endereco;
import br.edu.univas.pcelab4.model.Usuario;

public class UserDAO {
	private Connection connection;
	
	public UserDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	
	public boolean salvarUser(Usuario usuario){
		int index = 1;
		String sql = "insert into usuario (cpf, nome, telefone, email, login, senha, fk_nome_cargo)"
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
			statement.setString(index++, usuario.getCargo());
			statement.execute();
			return true;
		}catch(SQLException e){
			System.out.println("Problemas para popular a tabela usuario");
			e.printStackTrace();
			return false;
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
	
	public ArrayList<String> getAllEmailComercial(){
		ArrayList<String> listaEmailComercial = new ArrayList<>();
		int index = 1;
		String sql = "select email from usuario where fk_nome_cargo = 'Comercial'";
		
		PreparedStatement ps;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				listaEmailComercial.add(resultSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaEmailComercial;
	}
	
	public ArrayList<Usuario> getAllUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		String sql = "select cpf, nome, fk_nome_cargo, email, telefone from usuario";
		
		Statement statement;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Usuario user = new Usuario();
				user.setCpf(resultSet.getString("cpf"));
				user.setNome(resultSet.getString("nome"));
				user.setCargo(resultSet.getString("fk_nome_cargo"));
				user.setEmail(resultSet.getString("email"));
				user.setTelefone(resultSet.getString("telefone"));
				usuarios.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
