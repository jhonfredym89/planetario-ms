package com.trycore.planetario.microservicio.aplicacion.personas.fabrica;

import org.springframework.stereotype.Component;

import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.entidades.Persona;

@Component
public class PersonaFabricaAplicacion {
	
	public Persona mapearPersonaDTOAPersona(PersonaDTO personaDTO) {
		return new Persona(personaDTO.getNumeroIdentificacion(), personaDTO.getNombre(),
				personaDTO.getFechaNacimiento(), personaDTO.getGenero(), personaDTO.getEstatura(), personaDTO.getPeso(),
				personaDTO.getCantidadVisitas(), personaDTO.getPlaneta());
	}

	public PersonaDTO mapearPersonaAPersonaDTO(Persona persona) {
		return new PersonaDTO(persona.getNumeroIdentificacion(), persona.getNombre(), persona.getFechaNacimiento(),
				persona.getEdad(), persona.getGenero(), persona.getEstaturaEnMetros(), persona.getPesoEnKilogramos(),
				persona.getCantidadVisitas(), persona.getPlaneta());
	}
}
