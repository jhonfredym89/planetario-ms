package com.trycore.planetario.microservicio.aplicacion.personas.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trycore.planetario.microservicio.aplicacion.personas.fabrica.PersonaFabricaAplicacion;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.entidades.Persona;
import com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.consulta.PersonaRepositorioConsulta;

@Service
@Transactional(readOnly = true)
public class ManejadorConsultaPersona {

	@Autowired
	private PersonaRepositorioConsulta personaRepositorioConsulta;

	@Autowired
	private PersonaFabricaAplicacion fabrica;

	public PersonaDTO ejecutar(int numeroIdentificacion) {
		PersonaDTO personaDTO = personaRepositorioConsulta.consultarPorNumeroIdentificacion(numeroIdentificacion);
		Persona persona = fabrica.mapearPersonaDTOAPersona(personaDTO);
		persona.calcularEdad();
		return fabrica.mapearPersonaAPersonaDTO(persona);
	}
}
