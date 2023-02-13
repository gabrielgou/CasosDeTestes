package main.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.entidades.Agendamento;
import main.java.entidades.Cidadao;
import main.java.negocio.AgendamentoNegocio;
import main.java.repositorio.AgendamentoRepositorio;

public class AgendarVacinacao {
	
	AgendamentoRepositorio ar = new AgendamentoRepositorio();
	AgendamentoNegocio an = new AgendamentoNegocio(ar);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void TestCase12_1() {
		Agendamento ag = new Agendamento();
		
		Cidadao c = new Cidadao();
		c.setNome("Carlos");
		c.setCpf("12312312312");
		c.setCep("12312-081");
		c.setEndereco("Teste");
		c.setnCasa(123);
		c.setBairro("Bairro X");
		c.setEmail("carlos@teste.com");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse("2001-03-05");
			c.setDataNascimento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c.setSenha("123");
		
		Date date = null;
		
		try {
			date = sf.parse("2023-02-11");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		ag.setCidadao(c);
		ag.setVacinaNome("Pfizer;2023-02-10");
		ag.setDataAgendamento(date);
		
		assertTrue(an.agendar(ag));
	}
	
	@Test
	public void TestCase12_2() {
		an.fill();
		
		Agendamento ag = new Agendamento();
		
		Cidadao c = new Cidadao();
		c.setNome("Carlos");
		c.setCpf("12312312312");
		c.setCep("12312-081");
		c.setEndereco("Teste");
		c.setnCasa(123);
		c.setBairro("Bairro X");
		c.setEmail("carlos@teste.com");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf2.parse("2001-03-05");
			c.setDataNascimento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c.setSenha("123");
		
		Date date = null;
		
		try {
			date = sf2.parse("2023-02-11");
			ag.setDataAgendamento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		ag.setCidadao(c);
		ag.setVacinaNome("Pfizer;2023-02-10");
		ag.setDataAgendamento(date);
		
		assertFalse(an.agendar(ag));
	}
	
	@Test
	public void TestCase12_3() {
		Agendamento ag = new Agendamento();
		
		Cidadao c = new Cidadao();
		c.setNome("Carlos");
		c.setCpf("12312312312");
		c.setCep("12312-081");
		c.setEndereco("Teste");
		c.setnCasa(123);
		c.setBairro("Bairro X");
		c.setEmail("carlos@teste.com");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf2.parse("2001-03-05");
			c.setDataNascimento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c.setSenha("123");
		
		Date date = null;
		
		try {
			date = sf2.parse("2023-02-11");
			ag.setDataAgendamento(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		ag.setCidadao(c);
		ag.setVacinaNome("Pfizer;2023-02-12");
		ag.setDataAgendamento(date);
		
		assertFalse(an.agendar(ag));
	}
}
