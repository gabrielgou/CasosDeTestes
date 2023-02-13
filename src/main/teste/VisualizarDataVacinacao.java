package main.teste;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.negocio.AppNotificacaoNegocio;
import main.java.negocio.VacinaNegocio;
import main.java.repositorio.NotificaoRepositorio;
import main.java.repositorio.VacinaRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class VisualizarDataVacinacao {
	
	@Mock
	NotificaoRepositorio ar;
	
	@Mock
	VacinaRepositorio vr;
	
	final List<String> resp = new ArrayList<>();
	String rep = "";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void TestCase10_1() {
		rep = "Vacina 1";
		when(vr.getVacina("Vacina 1")).thenReturn(rep);
		VacinaNegocio vn = new VacinaNegocio(vr);
		String vacina = vn.buscaVacina(rep);
		assertTrue(vacina.equals("Vacina 1"));
	}
	
	@Test
	public void TestCase10_2() {
		resp.add("Notificação da Vacina APP");
		when(ar.getNotificacoesApp()).thenReturn(resp);
		AppNotificacaoNegocio an = new AppNotificacaoNegocio(ar);
		List<String> postos = an.buscaNotificacoesApp();
		assertTrue(postos.contains("Notificação da Vacina APP"));
	}
	
	@Test
	public void TestCase10_3() {
		resp.add("Notificação da Vacina Email");
		when(ar.getNotificacoesEmail()).thenReturn(resp);
		AppNotificacaoNegocio an = new AppNotificacaoNegocio(ar);
		List<String> postos = an.buscaNotificacoesEmail();
		assertTrue(postos.contains("Notificação da Vacina Email"));
	}
}
