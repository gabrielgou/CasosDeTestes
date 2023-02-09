package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.Cidadao;

public class CidadaoRepositorio{

	private List<Cidadao> usuarios;
	
	public CidadaoRepositorio () {
		this.usuarios = new ArrayList<>();
	}
	
	public boolean addUsuario(Cidadao u) {
		
		return this.usuarios.add(u);
	}
	public boolean editUsuario(Cidadao u, int idx) {
		this.usuarios.set(idx, u);
		return true;
	}
	public boolean editUsuario(Cidadao u) {
		this.usuarios.set(indexOfUsuario(u), u);
		return true;
	}
	public int indexOfUsuario(Cidadao u)
	{
		return this.usuarios.indexOf(u);
	}
	public Cidadao get(Cidadao u)
	{
		int i = this.indexOfUsuario(u);
		if(i<0)
			return null;
		return this.usuarios.get(i);
	}
	public Cidadao get(int idx)
	{
		return this.usuarios.get(idx);
	}
	public Cidadao get(String cpf)
	{
		for(Cidadao u : usuarios)
		{
			if(u.getCpf().equals(cpf))
			{
				return u;
			}
		}
		return null;
	}
	public void clear()
	{
		this.usuarios.clear();
	}
	public int size()
	{
		return this.usuarios.size();
	}
	public List<Cidadao> readAll()
	{
		return this.usuarios;
	}
}
