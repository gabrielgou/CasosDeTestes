package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.Cidadao;

public class RelatorioRepositorio {
	List<Cidadao> relatorioNVacinados;
	
	public RelatorioRepositorio() {
		this.relatorioNVacinados = new ArrayList<>();
	}

	public boolean addNV(Cidadao c) {
		this.relatorioNVacinados.add(c);
		return true;
	}
	
	public List<Cidadao> getNV(){
		return this.relatorioNVacinados;
	}
}
