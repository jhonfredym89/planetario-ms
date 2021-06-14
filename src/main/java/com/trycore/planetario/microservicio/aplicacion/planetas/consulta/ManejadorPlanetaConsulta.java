package com.trycore.planetario.microservicio.aplicacion.planetas.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta.PlanetaRepositorioConsulta;

@Service
@Transactional(readOnly = true)
public class ManejadorPlanetaConsulta {

	@Autowired
	private PlanetaRepositorioConsulta planetaRepositorioConsulta;

	public PlanetaDTO ejecutar(String nombre) {
		return planetaRepositorioConsulta.consultarPorNombre(nombre);
	}
}
