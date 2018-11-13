package br.edu.univas.pcelab4.controller;

import br.edu.univas.pcela4.listener.CadastraCargoListener;
import br.edu.univas.pcela4.listener.exibirTelaCadastroCargo;
import br.edu.univas.pcelab4.dao.CargoDAO;
import br.edu.univas.pcelab4.model.Cargo;
import br.edu.univas.pcelab4.view.CadastroCargoFrame;

public class AddCargoController {
	CadastroCargoFrame frame;
	CargoDAO dao;
	Cargo cargo;
	exibirTelaCadastroCargo listener;
	
	public AddCargoController() {
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
		cargo = new Cargo();
		
		
	}
}
