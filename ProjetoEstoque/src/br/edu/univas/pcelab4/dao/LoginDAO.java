package br.edu.univas.pcelab4.dao;

import java.lang.reflect.Array;
import java.nio.channels.NetworkChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.swing.JOptionPane;

//import br.edu.univas.Trab.model.UsuarioModel;
import br.edu.univas.pcelab4.model.Usuario;

public class LoginDAO {

	private Connection connection;
	private ResultSet resultSet;
	
	public LoginDAO() throws SQLException {
		connection =  ConnectionUtil.getConnection();
	}
	
	
	public ArrayList<Usuario> FazerLogin(Usuario usuario) {

		ArrayList<Usuario> user = new ArrayList<>();
		String sql = "select * from usuario where login=? and senha=? ";
		try {
			PreparedStatement Ps = connection.prepareStatement(sql); 
			Ps.setObject(1, usuario.getUserName());
			Ps.setObject(2, usuario.getPassword());
			resultSet = Ps.executeQuery();
			
			while (resultSet.next()) {
				Usuario usermodel = new Usuario();
				usermodel.setNome(resultSet.getString("nome"));
				usermodel.setCpf(resultSet.getString("cpf"));
				usermodel.setTelefone(resultSet.getString("telefone"));
				usermodel.setEmail(resultSet.getString("email"));
				usermodel.setUserName(resultSet.getString("login"));
				usermodel.setPassword(resultSet.getString("senha"));
				usermodel.setCargo(resultSet.getString("fk_nome_cargo"));
				user.add(usermodel);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
}
