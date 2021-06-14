package com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.fabrica;

import org.springframework.stereotype.Component;

import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.infraestructura.personas.entidades.PersonaEntidad;

@Component
public class PersonaFabricaInfraestructura {

	public PersonaDTO mapearPersonaEntidadAPersonaDTO(PersonaEntidad persona) {
		return new PersonaDTO(persona.getNumeroIdentificacion(), persona.getNombre(), persona.getFechaNacimiento(),
				persona.getGenero(), persona.getEstaturaEnMetros(), persona.getPesoEnKilogramos(),
				persona.getCantidadVisitas(), persona.getPlaneta().getNombre());
	}
}
