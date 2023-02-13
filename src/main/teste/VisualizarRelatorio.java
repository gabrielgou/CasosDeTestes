package main.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.entidades.Cidadao;
import main.java.excecao.RelatorioException;
import main.java.negocio.RelatorioNegocio;
import main.java.repositorio.RelatorioRepositorio;

public class VisualizarRelatorio {

	RelatorioRepositorio rr = new RelatorioRepositorio();
	RelatorioNegocio rn = new RelatorioNegocio(rr);

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCase9_1() throws RelatorioException {
		rn.fill();
		List<Cidadao> relatorio = rn.getRelatorioNV();
		assertEquals(3, relatorio.size());
	}
	
	@Test
	public void TestCase9_2() {
		try {
			List<Cidadao> relatorio = rn.getRelatorioNV();
			assertEquals(3, relatorio.size());
		} catch (RelatorioException e) {
			assertEquals("Não existem dados para gerar este relatório", e.getMessage());
		}
	}
}
