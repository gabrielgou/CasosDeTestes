package main.java.negocio;

import java.util.List;

import main.java.excecao.PostoException;
import main.java.repositorio.PostoRepositorio;

public class PostoNegocio {
	private PostoRepositorio postoRepositorio;
	
	public PostoNegocio(PostoRepositorio pr) {
		this.postoRepositorio = pr;
	}
	
	public List<String> buscaPostos(boolean b) throws PostoException{
		if(b == false) throw new PostoException("É precisso permitir a localização");
		return postoRepositorio.getPostos();
	}
}
