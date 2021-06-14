package com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.comando;

import com.trycore.planetario.microservicio.dominio.personas.modelo.entidades.Persona;

public interface PersonaRepositorioComando {

	/**
	 * Permite actualizar la cantidad de visitas que ha recibido una Persona.
	 * 
	 * @param persona
	 */
	void actualizarVisitas(Persona persona);
}
