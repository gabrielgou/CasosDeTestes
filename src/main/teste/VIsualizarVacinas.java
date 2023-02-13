package main.teste;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.negocio.VacinaNegocio;
import main.java.repositorio.VacinaRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class VIsualizarVacinas {
	@Mock
	VacinaRepositorio vr;
	
	final List<String> resp = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
	
		resp.add("Covid");
		resp.add("Febre Amarela");
	}

	@After
	public void tearDown() throws Exception {
		resp.clear();
	}

	@Test
	public void TestCase6_1(){
		String deOnde ="Pernambuco";
		String paraOnde="Acre";
		when(vr.getVacinas(paraOnde)).thenReturn(resp);
		VacinaNegocio vn = new VacinaNegocio(vr);
		try {
			List<String> vacinas = vn.buscaVacina(deOnde, paraOnde);
			assertTrue(vacinas.contains("Covid"));
			assertTrue(vacinas.contains("Febre Amarela"));
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			assertEquals("Preencha todos os campos.", e.getMessage());
		}
		verify(vr, times(1)).getVacinas(paraOnde);
	}
	@Test
	public void TestCase6_2()
	{
		String deOnde ="Pernambuco";
		String paraOnde="";
		VacinaNegocio vn = new VacinaNegocio(vr);
		
		try {
			List<String> vacinas = vn.buscaVacina(deOnde, paraOnde);
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			assertEquals("Preencha todos os campos.", e.getMessage());
		}
		verify(vr, times(0)).getVacinas(paraOnde);
	}
	@Test
	public void TestCase6_3(){
		String deOnde ="Pernambuco";
		String paraOnde="São Paulo";
		when(vr.getVacinas(paraOnde)).thenReturn(null);
		VacinaNegocio vn = new VacinaNegocio(vr);
		try {
			List<String> vacinas = vn.buscaVacina(deOnde, paraOnde);
			assertNotNull(vacinas);
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			assertEquals("Sem vacinas obrigatórias.", e.getMessage());
		}
		verify(vr, times(1)).getVacinas(paraOnde);
	}

}
