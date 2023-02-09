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

import main.java.entidades.EntidadeGoverno;
import main.java.excecao.EntidadeException;
import main.java.negocio.EntidadeNegocio;
import main.java.repositorio.EntidadeRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarEntidade {

	@Mock
	EntidadeRepositorio er;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCase7_1() {//com sucesso
		EntidadeGoverno eg = new EntidadeGoverno();
		eg.setNome("Natalina");
		eg.setNomePai("Nicolau Noel");
		eg.setNomeMae("Simoni Belissima");
		eg.setGenero('F');
		eg.setAlocacao("UPA treno");
		eg.setEmailInstitucional("treno@papainoel.com");
		eg.setMatricula("251222");
		eg.setCargo("Auxiliar");
		String dataNasc="1995-01-01";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			eg.setDataNasc(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eg.setNacionalidade("Brasileira");
		eg.setEndereco("Rua noite de natal");
		eg.setnCasa(25);
		eg.setEmail("gnoma@gmail.com");
		eg.setSenha("112233G");
		EntidadeNegocio en = new EntidadeNegocio(er);
		when(er.addUsuario(eg)).thenReturn(true);
		try {
			assertEquals("Email de cadastro enviado.", en.addUsuario(eg));
			
		}catch(Throwable e) {
			assertEquals("Matricula não efetuada. Dados incompletos", e.getMessage());
		}	
		verify(er,times(1)).addUsuario(eg);
	}
	@Test(expected = EntidadeException.class)
	public void TestCase7_2() throws EntidadeException//Erro de dados incompletos
	{
		EntidadeGoverno eg = new EntidadeGoverno();
		eg.setNome("manoel filho");
		eg.setNomePai("manoela gomes");
		eg.setNomeMae("manoel gomes");
		eg.setGenero('M');
		eg.setAlocacao("Creche");
		eg.setEmailInstitucional("creche@cuidacuida.com");
		eg.setMatricula("");
		eg.setCargo("recreador");
		String dataNasc="1997-02-02";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			eg.setDataNasc(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eg.setNacionalidade("Brasileiro");
		eg.setEndereco("rua da infancia");
		eg.setnCasa(03);
		eg.setEmail("manoelzinho@gmail.com");
		eg.setSenha("Brincar01");
		EntidadeNegocio en = new EntidadeNegocio(er);
		assertEquals("Email de cadastro enviado.", en.addUsuario(eg));
	}
	
	@Test
	public void TestCase7_3() {//Erro de matricula já existente.
		EntidadeGoverno eg = new EntidadeGoverno();
		eg.setNome("Natalina");
		eg.setNomePai("Nicolau Noel");
		eg.setNomeMae("Simoni Belissima");
		eg.setGenero('F');
		eg.setAlocacao("UPA treno");
		eg.setEmailInstitucional("treno@papainoel.com");
		eg.setMatricula("251222");
		eg.setCargo("Auxiliar");
		String dataNasc="1995-01-01";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sf.parse(dataNasc);
			eg.setDataNasc(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eg.setNacionalidade("Brasileira");
		eg.setEndereco("Rua noite de natal");
		eg.setnCasa(25);
		eg.setEmail("gnoma@gmail.com");
		eg.setSenha("112233G");
		EntidadeNegocio en = new EntidadeNegocio(er);
		when(er.addUsuario(eg)).thenReturn(false);
		try {
			assertEquals("Email de cadastro enviado.", en.addUsuario(eg));
			
		}catch(EntidadeException e) {
			assertEquals("Erro ao cadastrar. Matricula já existente.", e.getMessage());
		}		
		verify(er,times(1)).addUsuario(eg);
	}

}
