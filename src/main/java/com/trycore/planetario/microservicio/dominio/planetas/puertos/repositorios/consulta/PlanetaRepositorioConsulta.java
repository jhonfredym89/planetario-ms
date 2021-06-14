package com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta;

import java.util.List;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.TopPlanetasDTO;

public interface PlanetaRepositorioConsulta {
	/**
	 * Permite consultar los planetas y el número de personas que lo habitan.
	 * 
	 * @return Listado con nombre del planeta y cantidad de personas.
	 */
	List<CantidadPersonasPorPlanetaDTO> listar();

	/**
	 * Permite consultar un Planeta por su nombre
	 * 
	 * @param nombre del planeta a consultar.
	 * @return PlanetaDTO
	 */
	PlanetaDTO consultarPorNombre(String nombre);

	/**
	 * Permite consultar el top tres de los Planetas más visitados.
	 * 
	 * @return Listado con nombre del planeta y cantidad de visitas.
	 */
	List<TopPlanetasDTO> listarTop();
}
