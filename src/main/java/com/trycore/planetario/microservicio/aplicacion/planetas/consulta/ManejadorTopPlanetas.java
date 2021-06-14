package com.trycore.planetario.microservicio.aplicacion.planetas.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.TopPlanetasDTO;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta.PlanetaRepositorioConsulta;

@Component
@Transactional(readOnly = true)
public class ManejadorTopPlanetas {

	@Autowired
	private PlanetaRepositorioConsulta planetaRepositorioConsulta;

	public List<TopPlanetasDTO> ejecutar() {
		return planetaRepositorioConsulta.listarTop();
	}
}
