package main.java.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import main.java.entidades.Cidadao;
import main.java.excecao.RelatorioException;
import main.java.repositorio.RelatorioRepositorio;

public class RelatorioNegocio {
	
	private RelatorioRepositorio repo;

	public RelatorioNegocio(RelatorioRepositorio repo) {
		this.repo = repo;
	}
	
	public boolean addNV(Cidadao u) {
		boolean ret = false;
		ret = this.repo.addNV(u);		
		return ret;
	}
	
	public List<Cidadao> getRelatorioNV() throws RelatorioException {
		List<Cidadao> relatorio = this.repo.getNV();
		if(relatorio.size() == 0) throw new RelatorioException("Não existem dados para gerar este relatório");
		return relatorio;
	}
	
	public void fill() {
		Cidadao u1 = new Cidadao();
		u1.setNome("Lucas");
		u1.setCpf("111.222.333-44");
		u1.setCep("12345-081");
		u1.setEndereco("Rua X");
		u1.setnCasa(01);
		u1.setBairro("Bairro Y");
		u1.setEmail("lucas@gmail.com");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse("1995-03-12");
			u1.setDataNascimento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		u1.setSenha("123");
		this.addNV(u1);

		Cidadao u2 = new Cidadao();
		u2.setNome("Lais");
		u2.setCpf("111.222.333-44");
		u2.setCep("12345-081");
		u2.setEndereco("Rua X");
		u2.setnCasa(01);
		u2.setBairro("Bairro Y");
		u2.setEmail("lais@gmail.com");
		try {
			Date date = sf.parse("1995-03-12");
			u2.setDataNascimento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		u2.setSenha("123");
		this.addNV(u2);
		
		Cidadao u3 = new Cidadao();
		u3.setNome("Isabela");
		u3.setCpf("111.222.333-44");
		u3.setCep("12345-081");
		u3.setEndereco("Rua X");
		u3.setnCasa(01);
		u3.setBairro("Bairro Y");
		u3.setEmail("isabela@gmail.com");
		try {
			Date date = sf.parse("1995-03-12");
			u3.setDataNascimento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		u3.setSenha("123");
		this.addNV(u3);
	}

}
