package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.fabrica;

import org.springframework.stereotype.Component;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.infraestructura.planetas.entidades.PlanetaEntidad;

@Component
public class PlanetaFabricaInfraestructura {

	public PlanetaDTO mapearPlanetaEntidadAPlanetaDTO(PlanetaEntidad planeta) {
		return new PlanetaDTO(planeta.getNombre(), planeta.getPeriodoRotacion(), planeta.getDiametro(),
				planeta.getTerreno(), planeta.getClima(), planeta.getCantidadVisitas());
	}
}
