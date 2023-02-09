package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

public class VacinaRepositorio {
	private List<String> vacinas;
	public VacinaRepositorio() {
		this.vacinas = new ArrayList<>();
	}
	public List<String> getVacinas(String paraOnde)
	{
		return vacinas;
	}
}
