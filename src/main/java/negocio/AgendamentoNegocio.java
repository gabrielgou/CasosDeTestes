package main.java.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.entidades.Agendamento;
import main.java.entidades.Cidadao;
import main.java.repositorio.AgendamentoRepositorio;

public class AgendamentoNegocio {

	AgendamentoRepositorio agendamentoRepositorio;

	public AgendamentoNegocio(AgendamentoRepositorio agendamentoRepositorio) {
		this.agendamentoRepositorio = agendamentoRepositorio;
	}

	public boolean agendar(Agendamento ag) {
		String[] vacina = ag.getVacinaNome().split(";");
		String a = vacina[1];
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sf.parse(a);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if(date.after(ag.getDataAgendamento())) return false;
		
		if(agendamentoRepositorio.get(ag.getCidadao().getNome(), ag.getDataAgendamento()) != null) {
			return false;
		}
		
		return agendamentoRepositorio.cadastrar(ag);
	}
	
	public void fill() {
		Agendamento ag1 = new Agendamento();

		Cidadao c1 = new Cidadao();
		c1.setNome("Carlos");
		c1.setCpf("12312312312");
		c1.setCep("12312-081");
		c1.setEndereco("Teste");
		c1.setnCasa(123);
		c1.setBairro("Bairro X");
		c1.setEmail("carlos@teste.com");
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = sf1.parse("2001-03-05");
			c1.setDataNascimento(date1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c1.setSenha("123");

		Date date1 = null;

		try {
			date1 = sf1.parse("2023-02-11");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		ag1.setCidadao(c1);
		ag1.setVacinaNome("Pfizer");
		ag1.setDataAgendamento(date1);
		
		this.agendamentoRepositorio.cadastrar(ag1);
	}

}
