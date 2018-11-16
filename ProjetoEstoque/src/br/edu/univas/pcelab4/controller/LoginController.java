package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.edu.univas.pcelab4.view.LoginFrame;
import br.edu.univas.pcela4.listener.UsuarioLoginListener;
import br.edu.univas.pcelab4.dao.LoginDAO;
import br.edu.univas.pcelab4.dao.UserDAO;
import br.edu.univas.pcelab4.model.Usuario;

public class LoginController {

	LoginFrame frameLogin;
	LoginDAO usuarioDAO;
	//TelaIncialFrame frameinicio = new TelaIncialFrame();
	
	public LoginController() {
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
		
		userModel = usuarioDAO.FazerLogin(usuario);
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
			JOptionPane.showMessageDialog(null, user.get(0).getCargo());
			//frameinicio.setVisible(true);
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

	public void AbrirTelaLogin(){
		frameLogin.setVisible(true);
	}
	
	public void fecharTelaLogin() {
		frameLogin.setVisible(false);
	}
	
}
