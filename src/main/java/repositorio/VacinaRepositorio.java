package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

public class VacinaRepositorio {
	private List<String> vacinas;
	private String vacina;
	
	public VacinaRepositorio() {
		this.vacinas = new ArrayList<>();
	}
	public List<String> getVacinas(String paraOnde)
	{
		return vacinas;
	}
	public String getVacina(String nome) {
		return vacina;
	}
}
