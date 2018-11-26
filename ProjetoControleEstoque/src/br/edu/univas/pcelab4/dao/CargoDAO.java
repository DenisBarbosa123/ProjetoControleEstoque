package br.edu.univas.pcelab4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.pcelab4.model.Cargo;

public class CargoDAO {
	private Connection connection;
	
	public CargoDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public boolean salvarCargo(Cargo cargo){
		int index = 1;
		String sql = "insert into cargo (nome) values (?)";
		
		PreparedStatement statement;
			
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(index++, cargo.getNome());
			statement.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Cargo> getAllCargos(){
		ArrayList<Cargo> cargos = new ArrayList<>();
		
		String sql = "select * from cargo";
		
		try{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Cargo cargo = new Cargo();
				cargo.setNome(resultSet.getString("nome"));
				cargos.add(cargo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return cargos;
	}
}
