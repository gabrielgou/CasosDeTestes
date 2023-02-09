package main.teste;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.entidades.AgenteSaude;
import main.java.entidades.Endereco;
import main.java.negocio.AgenteNegocio;
import main.java.repositorio.AgenteRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarAgenteSaude {
	
	@Mock
	AgenteRepositorio agenteRepositorio;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCase8_1() {
		AgenteSaude as = new AgenteSaude();
		as.setNome("Zuleide Silva");
		as.setNomeMae("Joana marques da silva");
		as.setNomePai("Rogerio Correia Silva");
		as.setMatricula("2324256");
		as.setNomeUBS("Upinha do ibura");
		as.setuArea("ibura");
		String dataNasc="1993-08-22";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			as.setDataNascimento(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		as.setNacionalidade("Brasileira");
		as.setGenero("Outro");
		as.setCpf("12345678900");
		as.setEmail("zuzu.silva@live.com");
		as.setSenha("@Zuleide24");
		Endereco endereco = new Endereco();
		endereco.setNome("av jardim paulista");
		endereco.setnCasa(112);
		endereco.setBairro("Jardim fragoso");
		endereco.setComplemento("");
		endereco.setCidade("Olinda");
		endereco.setEstado("Pernambuco");
		as.setEndereco(endereco);
		AgenteNegocio an = new AgenteNegocio(agenteRepositorio);
		when(agenteRepositorio.addUsuario(as)).thenReturn(true);
		try {
			assertEquals("Email de cadastro enviado.",an.addUsuario(as));
		}catch(Throwable e)
		{
			assertEquals("Matricula não efetuada. Dados incompletos.", e.getMessage());
		}
		verify(agenteRepositorio,times(1)).addUsuario(as);
	}
	@Test
	public void TestCase8_2() {
		AgenteSaude as = new AgenteSaude();
		as.setNome("Gabriel de Jesus");
		as.setNomeMae("Marieta Severo");
		as.setNomePai("Lucas de Jesus");
		as.setMatricula("2231231");
		as.setNomeUBS("Upa Torrões");
		as.setuArea("Torrões");
		String dataNasc="1987-08-02";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			as.setDataNascimento(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		as.setNacionalidade("Brasileira");
		as.setGenero("M");
		as.setCpf("123123123124");
		as.setEmail("jesus.gabriel@live.com");
		as.setSenha("C@mis@09");
		Endereco endereco = new Endereco();
		endereco.setNome("");
		endereco.setnCasa(0);
		endereco.setBairro("");
		endereco.setComplemento("");
		endereco.setCidade("Recife");
		endereco.setEstado("Pernambuco");
		as.setEndereco(endereco);
		AgenteNegocio an = new AgenteNegocio(agenteRepositorio);
		try {
			assertEquals("Email de cadastro enviado.",an.addUsuario(as));
		}catch(Throwable e)
		{
			assertEquals("Matricula não efetuada. Dados incompletos.", e.getMessage());
		}
		verify(agenteRepositorio,times(0)).addUsuario(as);
	}
	
	@Test
	public void TestCase8_3() {
		AgenteSaude as = new AgenteSaude();
		as.setNome("Josefa Poliane");
		as.setNomeMae("Tereza Cristina");
		as.setNomePai("Odilon souza");
		as.setMatricula("1132322");
		as.setNomeUBS("Hospital da Restauração");
		as.setuArea("Espinheiro");
		String dataNasc="1972-07-02";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			as.setDataNascimento(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		as.setNacionalidade("Brasileira");
		as.setGenero("F");
		as.setCpf("123123123124");
		as.setEmail("jefinha.polly@live.com");
		as.setSenha("#P0lly02");
		Endereco endereco = new Endereco();
		endereco.setNome("Av Governador Agamenon Magalhães");
		endereco.setnCasa(1045);
		endereco.setBairro("Cavaleiro");
		endereco.setComplemento("");
		endereco.setCidade("Jaboatão Dos Guararapes");
		endereco.setEstado("Pernambuco");
		as.setEndereco(endereco);
		AgenteNegocio an = new AgenteNegocio(agenteRepositorio);
		when(agenteRepositorio.addUsuario(as)).thenReturn(false);
		try {
			assertEquals("Email de cadastro enviado.",an.addUsuario(as));
		}catch(Throwable e)
		{
			assertEquals("Erro ao cadastrar. Usuário com cpf já cadastrado.", e.getMessage());
		}
		verify(agenteRepositorio,times(1)).addUsuario(as);
	}

}
