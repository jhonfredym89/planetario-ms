package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionSinDatos;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta.PlanetaRepositorioConsulta;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.PlanetaRepositorioJPA;

@Repository
public class PlanetaRepositorioConsultaImpl implements PlanetaRepositorioConsulta {

	private static final String NO_HAY_PLANETAS = "No hay Planetas registrados en el sistema";

	private PlanetaRepositorioJPA planetaRepositorio;

	@Autowired
	public PlanetaRepositorioConsultaImpl(PlanetaRepositorioJPA planetaRepositorio) {
		this.planetaRepositorio = planetaRepositorio;
	}

	@Override
	public List<CantidadPersonasPorPlanetaDTO> listar() {
		List<CantidadPersonasPorPlanetaDTO> personasPorPlaneta = planetaRepositorio.listarPersonasPorPlaneta();

		if (personasPorPlaneta.isEmpty()) {
			throw new ExcepcionSinDatos(NO_HAY_PLANETAS);
		}

		return personasPorPlaneta;
	}

}
