package main.teste;

import static org.junit.Assert.assertEquals;
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

import main.java.excecao.PostoException;
import main.java.negocio.PostoNegocio;
import main.java.repositorio.PostoRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class VisualizarPostosProximos {
	
	@Mock
	PostoRepositorio pr;
	
	final List<String> resp = new ArrayList<>();
	
	@Before
	public void setUp() {
		resp.add("Posto 1");
		resp.add("Posto 2");
	}

	@After
	public void tearDown() {
		resp.clear();
	}
	
	@Test
	public void TestCase11_1() {
		when(pr.getPostos()).thenReturn(resp);
		PostoNegocio pn = new PostoNegocio(pr);
		try {
			List<String> postos = pn.buscaPostos(true);
			assertTrue(postos.contains("Posto 1"));
			assertTrue(postos.contains("Posto 2"));
		} catch (Throwable e) {
			assertEquals("É precisso permitir a localização", e.getMessage());
		}
	}
	
	@Test(expected = PostoException.class)
	public void TestCase11_2() throws PostoException {
		PostoNegocio pn = new PostoNegocio(pr);
		List<String> postos = pn.buscaPostos(false);
		assertTrue(postos.contains("Posto 1"));
		assertTrue(postos.contains("Posto 2"));
	}
	
}
