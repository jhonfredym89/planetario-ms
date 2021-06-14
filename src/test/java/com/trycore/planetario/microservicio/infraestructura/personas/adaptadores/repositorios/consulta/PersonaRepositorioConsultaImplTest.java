package com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.consulta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionSinDatos;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO;
import com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.PersonaRepositorioJPA;
import com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.fabrica.PersonaFabricaInfraestructura;
import com.trycore.planetario.microservicio.infraestructura.personas.entidades.PersonaEntidad;

public class PersonaRepositorioConsultaImplTest {

	@Test
	public void lanzarExcepcionNoHayPersonas() {
		PersonaRepositorioJPA repositorioJPA = mock(PersonaRepositorioJPA.class);
		PersonaFabricaInfraestructura fabrica = mock(PersonaFabricaInfraestructura.class);
		PersonaRepositorioConsultaImpl personaRepositorio = new PersonaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.listarLugaresViviendaPersonas()).thenReturn(Arrays.asList());

		Exception excepcion = assertThrows(ExcepcionSinDatos.class, () -> personaRepositorio.listar());

		assertEquals("No hay Personas registradas en el sistema", excepcion.getMessage());
	}

	@Test
	public void retornarListaPersonasTamanioUno() {
		PersonaInfoGeneralDTO dto = new PersonaInfoGeneralDTO(123, "Jhon", 0, "Tierra");
		PersonaRepositorioJPA repositorioJPA = mock(PersonaRepositorioJPA.class);
		PersonaFabricaInfraestructura fabrica = mock(PersonaFabricaInfraestructura.class);
		PersonaRepositorioConsultaImpl personaRepositorio = new PersonaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.listarLugaresViviendaPersonas()).thenReturn(Arrays.asList(dto));

		List<PersonaInfoGeneralDTO> listaResultado = personaRepositorio.listar();

		assertEquals(1, listaResultado.size());
		assertEquals(123, listaResultado.get(0).getNumeroIdentificacion());
		assertEquals("Jhon", listaResultado.get(0).getPersona());
		assertEquals(0, listaResultado.get(0).getCantidadVisitas());
		assertEquals("Tierra", listaResultado.get(0).getPlaneta());
	}

	@Test
	public void lanzarExcepcionPersonaNoExiste() {
		PersonaRepositorioJPA repositorioJPA = mock(PersonaRepositorioJPA.class);
		PersonaFabricaInfraestructura fabrica = mock(PersonaFabricaInfraestructura.class);
		PersonaRepositorioConsultaImpl personaRepositorio = new PersonaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.findByNumeroIdentificacion(123)).thenReturn(null);

		Exception excepcion = assertThrows(ExcepcionSinDatos.class,
				() -> personaRepositorio.consultarPorNumeroIdentificacion(123));

		assertEquals("La Persona con identificación 123 no está registrada en el sistema", excepcion.getMessage());
	}

	@Test
	public void retornarPersonaDTO() {
		PersonaEntidad personaEntidad = new PersonaEntidad();
		PersonaDTO personaDTO = new PersonaDTO(123, "Jhon", null, null, null, null, null, null);
		PersonaRepositorioJPA repositorioJPA = mock(PersonaRepositorioJPA.class);
		PersonaFabricaInfraestructura fabrica = mock(PersonaFabricaInfraestructura.class);
		PersonaRepositorioConsultaImpl personaRepositorio = new PersonaRepositorioConsultaImpl(repositorioJPA, fabrica);
		when(repositorioJPA.findByNumeroIdentificacion(123)).thenReturn(personaEntidad);
		when(fabrica.mapearPersonaEntidadAPersonaDTO(personaEntidad)).thenReturn(personaDTO);

		PersonaDTO personaRespuesta = personaRepositorio.consultarPorNumeroIdentificacion(123);

		assertEquals(123, personaRespuesta.getNumeroIdentificacion());
		assertEquals("Jhon", personaRespuesta.getNombre());
		assertNull(personaRespuesta.getFechaNacimiento());

	}
}
