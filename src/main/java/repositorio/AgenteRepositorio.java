package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.AgenteSaude;

public class AgenteRepositorio {
private List<AgenteSaude> usuarios;
	
	public AgenteRepositorio () {
		this.usuarios = new ArrayList<>();
	}
	
	public boolean addUsuario(AgenteSaude u) {
		
		return this.usuarios.add(u);
	}

}
