package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;

import br.edu.univas.pcela4.listener.CadastraUsuarioListener;
import br.edu.univas.pcelab4.dao.UserDAO;
import br.edu.univas.pcelab4.model.Endereco;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class AddUserController {
	private UserDAO dao;
	private Usuario usuario;
	private Endereco endereco;
	private CadastroUsuarioFrame frame;
	
	public AddUserController() throws SQLException{
		dao = new UserDAO();
		frame = new CadastroUsuarioFrame();
		frame.setListener(new CadastraUsuarioListener() {
			
			@Override
			public void salvarUsuario() {
				
					cadastraUsuario();
			
			}

			
		});
	}
	
	private void cadastraUsuario() {
		System.out.println("cheguei ate aqui");
		usuario = new Usuario();
		endereco = new Endereco();
		usuario.setCpf(frame.getCampoCpf().getText());
		usuario.setNome(frame.getCampoNome().getText());
		usuario.setEmail(frame.getCampoEmail().getText());
		usuario.setTelefone(frame.getCampoTelefone().getText());
		usuario.setUserName(frame.getCampoUser().getText());
		usuario.setPassword(frame.getCampoSenha().getText());
		//usuario.setCargo(frame.getListaDeCargos());
		
		endereco.setRua(frame.getCampoRua().getText());
		endereco.setNumero(frame.getCampoNumero().getText());
		endereco.setBairro(frame.getCampoBairro().getText());
		endereco.setCep(frame.getCampoCep().getText());
		
		dao.salvarUser(usuario);
		dao.salvarEndereco(usuario,endereco);
		clearFields();
	}
	
	private void clearFields() {
		List<JTextField> fields = Arrays.asList(
				frame.getCampoCpf(),
				frame.getCampoNome(),
				frame.getCampoEmail(),
				frame.getCampoTelefone(),
				frame.getCampoUser(),
				frame.getCampoSenha(),
				frame.getCampoRua(),
				frame.getCampoNumero(),
				frame.getCampoBairro(),
				frame.getCampoCep());
		
		for(JTextField jTextField:fields){
			clearField(jTextField);
		}
		
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	
	
}
