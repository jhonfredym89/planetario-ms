package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.repositorios.consulta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionSinDatos;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.PlanetaRepositorioJPA;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.consulta.PlanetaRepositorioConsultaImpl;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.fabrica.PlanetaFabricaInfraestructura;
import com.trycore.planetario.microservicio.infraestructura.planetas.entidades.PlanetaEntidad;

public class PlanetaRespositorioConsultaImplTest {

	@Test
	public void lanzarExcepcionNoHayPlanetas() {
		PlanetaRepositorioJPA repositorioJPA = mock(PlanetaRepositorioJPA.class);
		PlanetaFabricaInfraestructura fabrica = mock(PlanetaFabricaInfraestructura.class);
		PlanetaRepositorioConsultaImpl planetaRepositorio = new PlanetaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.listarPersonasPorPlaneta()).thenReturn(Arrays.asList());

		Exception excepcion = assertThrows(ExcepcionSinDatos.class, () -> planetaRepositorio.listar());

		assertEquals("No hay Planetas registrados en el sistema", excepcion.getMessage());
	}

	@Test
	public void retornarListaPersonasTamanioUno() {
		CantidadPersonasPorPlanetaDTO dto = new CantidadPersonasPorPlanetaDTO("Tierra", 20);
		PlanetaRepositorioJPA repositorioJPA = mock(PlanetaRepositorioJPA.class);
		PlanetaFabricaInfraestructura fabrica = mock(PlanetaFabricaInfraestructura.class);
		PlanetaRepositorioConsultaImpl personaRepositorio = new PlanetaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.listarPersonasPorPlaneta()).thenReturn(Arrays.asList(dto));

		List<CantidadPersonasPorPlanetaDTO> listaResultado = personaRepositorio.listar();

		assertEquals(1, listaResultado.size());
		assertEquals("Tierra", listaResultado.get(0).getPlaneta());
		assertEquals(20, listaResultado.get(0).getCantidadPersonas());
	}

	@Test
	public void lanzarExcepcionPlanetaNoExiste() {
		PlanetaRepositorioJPA repositorioJPA = mock(PlanetaRepositorioJPA.class);
		PlanetaFabricaInfraestructura fabrica = mock(PlanetaFabricaInfraestructura.class);
		PlanetaRepositorioConsultaImpl personaRepositorio = new PlanetaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.findByNombre("Tierra")).thenReturn(null);

		Exception excepcion = assertThrows(ExcepcionSinDatos.class,
				() -> personaRepositorio.consultarPorNombre("Tierra"));

		assertEquals("El Planeta Tierra no está registrado en el sistema", excepcion.getMessage());
	}

	@Test
	public void retornarPlanetaDTO() {
		PlanetaEntidad planetaEntidad = new PlanetaEntidad();
		List<String> personas = Arrays.asList("Jhon", "Paola");
		PlanetaDTO personaDTO = new PlanetaDTO("Tierra", 1.3F, 123, null, null, null, personas);
		PlanetaRepositorioJPA repositorioJPA = mock(PlanetaRepositorioJPA.class);
		PlanetaFabricaInfraestructura fabrica = mock(PlanetaFabricaInfraestructura.class);
		PlanetaRepositorioConsultaImpl personaRepositorio = new PlanetaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.findByNombre("Tierra")).thenReturn(planetaEntidad);
		when(fabrica.mapearPlanetaEntidadAPlanetaDTO(planetaEntidad)).thenReturn(personaDTO);

		PlanetaDTO planetaRespuesta = personaRepositorio.consultarPorNombre("Tierra");

		assertEquals("Tierra", planetaRespuesta.getNombre());
		assertNull(planetaRespuesta.getClima());
		assertEquals(2, personaDTO.getPersonas().size());

	}
}
