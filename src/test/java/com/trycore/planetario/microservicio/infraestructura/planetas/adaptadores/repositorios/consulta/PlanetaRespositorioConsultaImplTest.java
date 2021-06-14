package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.repositorios.consulta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionSinDatos;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.PlanetaRepositorioJPA;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.consulta.PlanetaRepositorioConsultaImpl;

public class PlanetaRespositorioConsultaImplTest {

	@Test
	public void lanzarExcepcionNoHayPlanetas() {
		PlanetaRepositorioJPA repositorioJPA = mock(PlanetaRepositorioJPA.class);
		PlanetaRepositorioConsultaImpl planetaRepositorio = new PlanetaRepositorioConsultaImpl(repositorioJPA);
		when(repositorioJPA.listarPersonasPorPlaneta()).thenReturn(Arrays.asList());

		Exception excepcion = assertThrows(ExcepcionSinDatos.class, () -> planetaRepositorio.listar());

		assertEquals("No hay Planetas registrados en el sistema", excepcion.getMessage());
	}

	@Test
	public void retornarListaPersonasTamanioUno() {
		CantidadPersonasPorPlanetaDTO dto = new CantidadPersonasPorPlanetaDTO("Tierra", 20);
		PlanetaRepositorioJPA repositorioJPA = mock(PlanetaRepositorioJPA.class);
		PlanetaRepositorioConsultaImpl personaRepositorio = new PlanetaRepositorioConsultaImpl(repositorioJPA);
		when(repositorioJPA.listarPersonasPorPlaneta()).thenReturn(Arrays.asList(dto));

		List<CantidadPersonasPorPlanetaDTO> listaResultado = personaRepositorio.listar();

		assertEquals(1, listaResultado.size());
		assertEquals("Tierra", listaResultado.get(0).getPlaneta());
		assertEquals(20, listaResultado.get(0).getCantidadPersonas());
	}
}
