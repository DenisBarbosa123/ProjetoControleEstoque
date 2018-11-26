package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.univas.pcelab4.listener.CadastraUsuarioListener;
import br.edu.univas.pcelab4.dao.CargoDAO;
import br.edu.univas.pcelab4.dao.UserDAO;
import br.edu.univas.pcelab4.model.Cargo;
import br.edu.univas.pcelab4.model.Endereco;
import br.edu.univas.pcelab4.model.Usuario;
import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class AddUserController {
	private UserDAO dao;
	private Usuario usuario;
	private Endereco endereco;
	private CadastroUsuarioFrame frame;
	private CargoDAO daoCargo;
	
	public AddUserController() throws SQLException{
		dao = new UserDAO();
		daoCargo = new CargoDAO();
		frame = new CadastroUsuarioFrame();
		frame.setListener(new CadastraUsuarioListener() {
			
			@Override
			public void salvarUsuario() {
				cadastraUsuario();
			}

			@Override
			public void fecharTelaCadastroUsuario() {
				fecharTelaUsuario();
				
			}
		});
	}
	
	public void abrirTelaCadastroUsuario(){
		frame.setVisible(true);
		frame.atualizaCargoLista(daoCargo.getAllCargos());
	}
	public void fecharTelaUsuario(){
		frame.setVisible(false);
	}
	public void cadastraUsuario() {
		//System.out.println("cheguei ate aqui");
		usuario = new Usuario();
		endereco = new Endereco();
		if(frame.getCampoCpf().getText().length()==0 || frame.getCampoNome().getText().length()==0 || frame.getCampoEmail().getText().length()==0
		&&	frame.getCampoTelefone().getText().length()==0 && frame.getCampoUser().getText().length()==0 && frame.getCampoSenha().getText().length()==0
				&& frame.getCampoRua().getText().length()==0 && frame.getCampoNumero().getText().length() == 0 && frame.getCampoBairro().getText().length()==0 
					&& frame.getCampoCep().getText().length()==0){
			
			JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO - CAMPO NULO", "Erro", JOptionPane.ERROR_MESSAGE);
			
			
		}else{
			
			usuario.setCpf(frame.getCampoCpf().getText());
			usuario.setNome(frame.getCampoNome().getText());
			usuario.setEmail(frame.getCampoEmail().getText());
			usuario.setTelefone(frame.getCampoTelefone().getText());
			usuario.setUserName(frame.getCampoUser().getText());
			usuario.setPassword(frame.getCampoSenha().getText());
			usuario.setCargo(frame.getCampoCargo());
			endereco.setRua(frame.getCampoRua().getText());
			endereco.setNumero(frame.getCampoNumero().getText());
			endereco.setBairro(frame.getCampoBairro().getText());
			endereco.setCep(frame.getCampoCep().getText());
			
			boolean retornoMetodocadastro= dao.salvarUser(usuario);
			if(retornoMetodocadastro == true){
				//System.out.println(frame.getCampoNome().getText());
				JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}else{
				//this.abrirTelaCadastroUsuario();
				JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			dao.salvarEndereco(usuario,endereco);
			clearFields();
			
		}
		
		
		
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
