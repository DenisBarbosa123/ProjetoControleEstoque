package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.univas.pcelab4.view.AdministradorFrame;
import br.edu.univas.pcelab4.view.LoginFrame;
import br.edu.univas.pcelab4.listener.UsuarioLoginListener;
import br.edu.univas.pcelab4.dao.LoginDAO;
import br.edu.univas.pcelab4.dao.UserDAO;
import br.edu.univas.pcelab4.model.Usuario;

public class LoginController {

	private static String idUsuarioAtual;
	LoginFrame frameLogin;
	LoginDAO usuarioDAO;
	AdministradorController admController;
	EstoquistaController estoquistaController;
	GerenteController gerenteController;
	
	public LoginController() throws SQLException {
		admController= new AdministradorController();
		estoquistaController = new EstoquistaController();
		gerenteController = new GerenteController();
		try {
			usuarioDAO = new LoginDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Deu ruim");
		}
		frameLogin = new LoginFrame();
		frameLogin.setListenerLogar(new UsuarioLoginListener() {
			
			@Override
			public void LogarSistema() {
				// TODO Auto-generated method stub
				try {
					Logar();
				} catch (SQLException e) {
					System.out.println("Deu ruim no login");
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private void Logar() throws SQLException {
		Usuario usuario = new Usuario();
		ArrayList<Usuario> userModel = new ArrayList<>();
		
		usuario.setUserName(frameLogin.getJtfUser().getText());
		usuario.setPassword(frameLogin.getJtfPassword().getText());
		
		
		userModel.addAll(usuarioDAO.FazerLogin(usuario)); 
		idUsuarioAtual=userModel.get(0).getCpf();
		validaUsuário(userModel);
	}
	
	private void validaUsuário(ArrayList<Usuario> user) {
		// TODO Auto-generated method stub
		if (user.isEmpty()){
			JOptionPane.showMessageDialog(null, "Usuário nao encontrado, favor digite novamente");
			clearFields();
		}
		else{
			JOptionPane.showMessageDialog(null, "Usuário encontrado com sucesso");
			clearFields();
			frameLogin.setVisible(false);
			String cargoUsuario = user.get(0).getCargo();
			
			abrirTelaCorrespondente(cargoUsuario);
			
		}
	}

	private void clearFields() {
		// TODO Auto-generated method stub
		List<JTextField> fields = Arrays.asList(
				frameLogin.getJtfUser(),
				frameLogin.getJtfPassword());
		
		for (JTextField jTextField : fields) {
			clearField(jTextField);
		}
	}

	private void clearField(JTextField jTextField) {
		// TODO Auto-generated method stub
		jTextField.setText(null);
	}

	public void abrirTelaLogin(){
		frameLogin.setVisible(true);
	}
	
	public void fecharTelaLogin() {
		frameLogin.setVisible(false);
	}
	
	private void abrirTelaCorrespondente(String cargo){
		if(cargo.equals("Estoquista")){
			estoquistaController.abrirTelaEstoquista();
		}else if(cargo.equals("Administrador")){
			admController.abrirTelaAdm();
		}else if(cargo.equals("Gerente")) {
			gerenteController.abrirTelaGerente();
		}
	}

	public static String getCpfAtual(){
		return idUsuarioAtual;
	}
}
