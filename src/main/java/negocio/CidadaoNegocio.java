package main.java.negocio;

import main.java.entidades.Cidadao;
import main.java.repositorio.CidadaoRepositorio;

public class CidadaoNegocio {
	
	
	
	private CidadaoRepositorio repo;
	
	public CidadaoNegocio(CidadaoRepositorio rep) {
		this.repo = rep;
	}
	
	public boolean cadastrarUsuario(Cidadao u) {
		boolean ret = false;
		ret = this.repo.addUsuario(u);		
		return ret;
	}
	public String editarUsuario(Cidadao u, int idx) {
		Cidadao user = this.repo.get(idx);
		if(user==null)
		{
			return "Não existe";
		}
		if(!user.getSenha().equals(u.getSenha()) && u.getSenha()!=null)
		{
			return "Senha Errada";
		}
		this.repo.editUsuario(u, idx);
		return "Concluido";
	}
	public String editarUsuario(Cidadao u, String senha) {
		if(u==null)
		{
			return "Não existe";
		}
		if(!u.getSenha().equals(senha))
		{
			return "Senha Errada, tente novamente!";
		}
		this.repo.editUsuario(u);
		return "Modificações realizadas com sucesso.";
	}
	public Cidadao getUsuario(int idx)
	{
		try {
			return this.repo.get(idx);
		}catch(Exception e)
		{
			return null;
		}
	}
	public Cidadao getUsuario(String cpf)
	{
			return this.repo.get(cpf);
	}

}
