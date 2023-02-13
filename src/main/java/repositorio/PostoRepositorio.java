package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

public class PostoRepositorio {
	private List<String> postos;
	
	public PostoRepositorio() {
		this.postos = new ArrayList<>();
	}

	public List<String> getPostos() {
		return postos;
	}

}
