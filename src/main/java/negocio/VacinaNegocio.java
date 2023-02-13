package main.java.negocio;

import java.util.List;

import main.java.repositorio.VacinaRepositorio;

public class VacinaNegocio{
	private VacinaRepositorio vacinaRepositorio;
	
	public VacinaNegocio(VacinaRepositorio vr) {
		this.vacinaRepositorio = vr;
		
	}
	
	public List<String> buscaVacina(String deOnde, String paraOnde) throws Throwable
	{
		if(deOnde.isEmpty() || paraOnde.isEmpty())
			throw new Throwable("Preencha todos os campos.");
		List<String> list = vacinaRepositorio.getVacinas(paraOnde);
		if(list==null)
			throw new Throwable("Sem vacinas obrigatórias.");
		return list;
	}
	
	public String buscaVacina(String nome) {
		return vacinaRepositorio.getVacina(nome);
	}
}
