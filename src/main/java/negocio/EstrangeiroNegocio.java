package main.java.negocio;

import main.java.entidades.Estrangeiro;
import main.java.repositorio.EstrangeiroRepositorio;

public class EstrangeiroNegocio {
	
	
	
	private EstrangeiroRepositorio repo;
	
	public EstrangeiroNegocio(EstrangeiroRepositorio rep) {
		this.repo = rep;
	}
	
	public boolean cadastrarUsuario(Estrangeiro u) {
		boolean ret = false;
		ret = this.repo.addUsuario(u);		
		return ret;
	}
	public String editarUsuario(Estrangeiro u, int idx) {
		Estrangeiro user = this.repo.get(idx);
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
	public String editarUsuario(Estrangeiro u, String senha) {
		if(u==null)
		{
			return "Não existe";
		}
		if(!u.getSenha().equals(senha))
		{
			return "Senha Errada, tente novamente!";
		}
		this.repo.editUsuario(u);
		return "Concluído com sucesso.";
	}
	public Estrangeiro getUsuario(int idx)
	{
		try {
			return this.repo.get(idx);
		}catch(Exception e)
		{
			return null;
		}
	}
	public Estrangeiro getUsuario(String passaporte)
	{
			return this.repo.get(passaporte);
	}

}
