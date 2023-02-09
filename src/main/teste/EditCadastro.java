package main.teste;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.entidades.Estrangeiro;
import main.java.entidades.Cidadao;
import main.java.negocio.EstrangeiroNegocio;
import main.java.negocio.CidadaoNegocio;
import main.java.repositorio.EstrangeiroRepositorio;
import main.java.repositorio.CidadaoRepositorio;

public class EditCadastro {

	CidadaoRepositorio ur = new CidadaoRepositorio();	
	CidadaoNegocio un = new CidadaoNegocio(ur);
	EstrangeiroRepositorio er = new EstrangeiroRepositorio();
	EstrangeiroNegocio en = new EstrangeiroNegocio(er);
	
	@Before
	public void setUp() throws Exception {
		
		Cidadao user = new Cidadao();
		user.setNome("Matheus Nogueira");
		user.setCpf("111.222.333-44");
		user.setCep("12345-081");
		user.setEndereco("Rua Marques do pombal");
		user.setnCasa(02);
		user.setBairro("Santo Amaro");
		user.setEmail("matheus.nogueira@gmail.com");
		String dataNasc="1995-03-12";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			user.setDataNascimento(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.setSenha("N0gu31r4");
		un.cadastrarUsuario(user);
		
		Cidadao user1 = new Cidadao();
		user1.setNome("Dona Rose");
		user1.setCpf("11122233344");
		user1.setCep("21321-00");
		user1.setEndereco("Rua Lourenço Bezerra");
		user1.setnCasa(05);
		user1.setBairro("Coqueiral");
		user1.setEmail("rosemary.brito@live.com");
		dataNasc="1944-05-05";
		try {
			Date date = sf.parse(dataNasc);
			user1.setDataNascimento(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user1.setSenha("Rose123");
		un.cadastrarUsuario(user1);
		assertTrue(ur.size()==2);
		
		Estrangeiro est = new Estrangeiro();
		est.setNome("James Bond");
		est.setNacionalidade("Inglês");
		est.setPassaporte("123123");
		est.setNomeMae("Elizabeth Marie");
		est.setNomePai("Joseph Bond");
		dataNasc="1957-05-02";
		try {
			Date date = sf.parse(dataNasc);
			est.setDataNasc(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		est.setAeroportoOrigem("Manchester");
		est.setAeroportoDestino("Acre");
		List<String> estados = new ArrayList<>();
		estados.add("Pernambuco");
		estados.add("São Paulo");
		estados.add("Rio de Janeiro");
		est.setEstadosVisitados(estados);
		est.setDataChegada(null);
		est.setGenero('M');
		est.setEmail("jamesbond@bol.com");
		est.setSenha("#S3cr3t4g3nt");
		en.cadastrarUsuario(est);
	}
	@After
	public void tearDown() throws Exception{
		ur.clear();
		er.clear();
	}

	@Test
	public void TestCase5_1() {
		Cidadao u = un.getUsuario("111.222.333-44");	
		assertNotNull(u);
		u.setCep("54250-310");
		u.setBairro("Av oito");
		u.setnCasa(123);
		u.setBairro("Curado IV");
		String senha = "N0gu31r4";
		String editou = un.editarUsuario(u, senha);
		assertEquals("Modificações realizadas com sucesso.", editou);
	}
	@Test
	public void TestCase5_2()//Seguindo como o testCase
	{
		Cidadao u = un.getUsuario("11122233344");
		assertNotNull(u);
		String senha ="naoSei";
		String editou = un.editarUsuario(u, senha);
		assertEquals("Senha Errada, tente novamente!",editou);
		
	}
	@Test
	public void TestCase5_3()
	{
		Estrangeiro e = en.getUsuario("123123");
		assertNotNull(e);
		e.getEstadosVisitados().add("Goias");
		e.getEstadosVisitados().add("Rio Grande Do Sul");
		e.setAeroportoDestino("Santa Catarina");
		e.setAeroportoOrigem("Acre");
		String senha = "#S3cr3t4g3nt";
		String editou = en.editarUsuario(e, senha);
		assertEquals("Concluído com sucesso.", editou);
		
	}
}
