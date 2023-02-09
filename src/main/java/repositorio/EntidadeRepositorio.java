package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.EntidadeGoverno;

public class EntidadeRepositorio {
private List<EntidadeGoverno> usuarios;
	
	public EntidadeRepositorio () {
		this.usuarios = new ArrayList<>();
	}
	
	public boolean addUsuario(EntidadeGoverno u) {
		
		return this.usuarios.add(u);
	}

}
