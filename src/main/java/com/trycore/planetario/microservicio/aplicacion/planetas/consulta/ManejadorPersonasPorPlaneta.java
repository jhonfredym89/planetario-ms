package com.trycore.planetario.microservicio.aplicacion.planetas.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta.PlanetaRepositorioConsulta;

@Service
@Transactional(readOnly = true)
public class ManejadorPersonasPorPlaneta {

	@Autowired
	private PlanetaRepositorioConsulta planetaRepositorioConsulta;

	public List<CantidadPersonasPorPlanetaDTO> ejecutar() {
		return planetaRepositorioConsulta.listar();
	}

}
