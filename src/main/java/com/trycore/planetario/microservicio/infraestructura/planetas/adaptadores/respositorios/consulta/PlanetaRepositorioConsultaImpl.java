package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trycore.planetario.comun.infraestructura.excepciones.ExcepcionSinDatos;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta.PlanetaRepositorioConsulta;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.PlanetaRepositorioJPA;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.fabrica.PlanetaFabricaInfraestructura;
import com.trycore.planetario.microservicio.infraestructura.planetas.entidades.PlanetaEntidad;

@Repository
public class PlanetaRepositorioConsultaImpl implements PlanetaRepositorioConsulta {

	private static final String NO_HAY_PLANETAS = "No hay Planetas registrados en el sistema";
	private static final String NO_EXISTE_PLANETA = "El Planeta %s no est� registrado en el sistema";

	private PlanetaRepositorioJPA planetaRepositorio;
	private PlanetaFabricaInfraestructura fabrica;

	@Autowired
	public PlanetaRepositorioConsultaImpl(PlanetaRepositorioJPA planetaRepositorio,
			PlanetaFabricaInfraestructura fabrica) {
		this.planetaRepositorio = planetaRepositorio;
		this.fabrica = fabrica;
	}

	@Override
	public List<CantidadPersonasPorPlanetaDTO> listar() {
		List<CantidadPersonasPorPlanetaDTO> personasPorPlaneta = planetaRepositorio.listarPersonasPorPlaneta();

		if (personasPorPlaneta.isEmpty()) {
			throw new ExcepcionSinDatos(NO_HAY_PLANETAS);
		}

		return personasPorPlaneta;
	}

	@Override
	public PlanetaDTO consultarPorNombre(String nombre) {
		PlanetaEntidad planetaEntidad = planetaRepositorio.findByNombre(nombre);

		if (planetaEntidad == null) {
			throw new ExcepcionSinDatos(String.format(NO_EXISTE_PLANETA, nombre));
		}

		return fabrica.mapearPlanetaEntidadAPlanetaDTO(planetaEntidad);
	}

}
