package main.java.negocio;


import main.java.entidades.EntidadeGoverno;
import main.java.excecao.EntidadeException;
import main.java.repositorio.EntidadeRepositorio;

public class EntidadeNegocio {
	private EntidadeRepositorio entidadeRepositorio;
	public EntidadeNegocio(EntidadeRepositorio er) {
		this.entidadeRepositorio=er;
	}
	
	public String addUsuario(EntidadeGoverno eg) throws EntidadeException
	{
		if(eg.getMatricula().isEmpty()) throw new EntidadeException("Matricula não efetuada. Dados incompletos.");
		if(!entidadeRepositorio.addUsuario(eg)) throw new EntidadeException("Erro ao cadastrar. Matricula já existente.");
		return "Email de cadastro enviado.";
	}

}
