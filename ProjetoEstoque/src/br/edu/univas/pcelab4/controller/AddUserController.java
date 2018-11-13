package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
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

			@Override
			public void fecharTelaCadastroUsuario() {
				fecharTelaUsuario();
				
			}
		});
	}
	
	public void abrirTelaCadastroUsuario(){
		frame.setVisible(true);
	}
	public void fecharTelaUsuario(){
		frame.setVisible(false);
	}
	public void cadastraUsuario() {
		//System.out.println("cheguei ate aqui");
		usuario = new Usuario();
		endereco = new Endereco();
		if(frame.getCampoCpf()==null || frame.getCampoNome()==null || frame.getCampoEmail()==null
			||	frame.getCampoTelefone()==null || frame.getCampoUser()==null || frame.getCampoSenha()==null
				|| frame.getCampoRua()==null || frame.getCampoNumero() == null || frame.getCampoBairro()==null || frame.getCampoCep()==null){
			JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			
			
		}else{
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
			
			boolean retornoMetodocadastro= dao.salvarUser(usuario);
			if(retornoMetodocadastro == true){
				JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}else{
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
