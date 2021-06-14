package com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.consulta;

import java.util.List;

import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO;

public interface PersonaRepositorioConsulta {

	/**
	 * Permite consultar las personas.
	 * 
	 * @return Listado con nombre de la Persona, cantidad de visitas y nombre del
	 *         Planeta donde vive.
	 */
	List<PersonaInfoGeneralDTO> listar();

	/**
	 * Permite consultar una Persona por su número de identificación.
	 * 
	 * @param numeroIdentificacion de la Persona
	 * @return PersonaDTO
	 */
	PersonaDTO consultarPorNumeroIdentificacion(int numeroIdentificacion);
}
