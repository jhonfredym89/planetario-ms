package com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.comando;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades.Planeta;

public interface PlanetaRepositorioComando {

	/**
	 * Permite actualizar la cantidad de visitas que ha recibido un Planeta
	 * 
	 * @param planeta
	 */
	void actualizarVisitas(Planeta planeta);
}
