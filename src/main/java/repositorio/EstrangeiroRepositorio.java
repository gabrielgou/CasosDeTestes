package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.Estrangeiro;

public class EstrangeiroRepositorio{

	private List<Estrangeiro> usuarios;
	
	public EstrangeiroRepositorio () {
		this.usuarios = new ArrayList<>();
	}
	
	public boolean addUsuario(Estrangeiro u) {
		
		return this.usuarios.add(u);
	}
	public boolean editUsuario(Estrangeiro u, int idx) {
		this.usuarios.set(idx, u);
		return true;
	}
	public boolean editUsuario(Estrangeiro u) {
		this.usuarios.set(indexOfUsuario(u), u);
		return true;
	}
	public int indexOfUsuario(Estrangeiro u)
	{
		return this.usuarios.indexOf(u);
	}
	public Estrangeiro get(Estrangeiro u)
	{
		int i = this.indexOfUsuario(u);
		if(i<0)
			return null;
		return this.usuarios.get(i);
	}
	public Estrangeiro get(int idx)
	{
		return this.usuarios.get(idx);
	}
	public Estrangeiro get(String passaporte)
	{
		for(Estrangeiro u : usuarios)
		{
			if(u.getPassaporte().equals(passaporte))
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
	public List<Estrangeiro> readAll()
	{
		return this.usuarios;
	}
}
