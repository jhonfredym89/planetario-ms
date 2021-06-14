package com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionSinDatos;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO;
import com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.consulta.PersonaRepositorioConsulta;
import com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.PersonaRepositorioJPA;
import com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.fabrica.PersonaFabricaInfraestructura;
import com.trycore.planetario.microservicio.infraestructura.personas.entidades.PersonaEntidad;

@Repository
public class PersonaRepositorioConsultaImpl implements PersonaRepositorioConsulta {

	private static final String NO_HAY_PERSONAS = "No hay Personas registradas en el sistema";
	private static final String NO_EXISTE_PERSONA = "La Persona con identificación %d no está registrada en el sistema";

	private PersonaRepositorioJPA personaRepositorio;
	private PersonaFabricaInfraestructura fabrica;

	@Autowired
	public PersonaRepositorioConsultaImpl(PersonaRepositorioJPA personaRepositorio,
			PersonaFabricaInfraestructura fabrica) {
		this.personaRepositorio = personaRepositorio;
		this.fabrica = fabrica;
	}

	@Override
	public List<PersonaInfoGeneralDTO> listar() {
		List<PersonaInfoGeneralDTO> lugaresViviendaPersonas = personaRepositorio.listarLugaresViviendaPersonas();

		if (lugaresViviendaPersonas.isEmpty()) {
			throw new ExcepcionSinDatos(NO_HAY_PERSONAS);
		}

		return lugaresViviendaPersonas;
	}

	@Override
	public PersonaDTO consultarPorNumeroIdentificacion(int numeroIdentificacion) {
		PersonaEntidad personaEntidad = personaRepositorio.findByNumeroIdentificacion(numeroIdentificacion);

		if (personaEntidad == null) {
			throw new ExcepcionSinDatos(String.format(NO_EXISTE_PERSONA, numeroIdentificacion));
		}

		return fabrica.mapearPersonaEntidadAPersonaDTO(personaEntidad);
	}

}
