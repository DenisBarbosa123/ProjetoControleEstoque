package br.edu.univas.pcelab4.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.univas.pcelab4.dao.CargoDAO;
import br.edu.univas.pcelab4.listener.CadastraCargoListener;
import br.edu.univas.pcelab4.model.Cargo;
import br.edu.univas.pcelab4.view.CadastroCargoFrame;
//import br.edu.univas.pcelab4.view.CadastroUsuarioFrame;

public class AddCargoController {
	CadastroCargoFrame frame;
	CargoDAO dao;
	Cargo cargo;
	//CadastroUsuarioFrame frameUsuario;
	
	public AddCargoController() throws SQLException {
		frame = new CadastroCargoFrame();
		dao = new CargoDAO();
		frame.setListener(new CadastraCargoListener() {
			
			@Override
			public void salvarCargo() {
				CadastraCargo();
				
				
			}

			@Override
			public void sairTelaCargo() {
				fecharTelaCadastroCargo();
				
			}

			
		});
	}
	
	public void abrirTelaCadastroCargo(){
		frame.setVisible(true);
	}
	public void fecharTelaCadastroCargo(){
		frame.setVisible(false);
	}
	private void CadastraCargo() {
		if(frame.getCampoCargo().getText().length()==0){
			JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO - CAMPO NULO", "Erro", JOptionPane.ERROR_MESSAGE);
		}else{
			cargo = new Cargo();
			cargo.setNome(frame.getCampoCargo().getText());
			if(dao.salvarCargo(cargo)==true){
				JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"CADASTRO ABORTADO", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
}
