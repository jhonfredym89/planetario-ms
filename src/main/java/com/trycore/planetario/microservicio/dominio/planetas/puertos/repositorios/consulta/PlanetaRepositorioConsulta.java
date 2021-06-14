package com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta;

import java.util.List;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;

public interface PlanetaRepositorioConsulta {
	/**
	 * Permite consultar los planetas y el número de personas que lo habitan.
	 * 
	 * @return Listado con nombre del planeta y cantidad de personas.
	 */
	List<CantidadPersonasPorPlanetaDTO> listar();
}
