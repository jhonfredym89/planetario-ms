package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.fabrica;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.infraestructura.planetas.entidades.PlanetaEntidad;

@Component
public class PlanetaFabricaInfraestructura {

	public PlanetaDTO mapearPlanetaEntidadAPlanetaDTO(PlanetaEntidad planeta) {
		List<String> personas = planeta.getPersonas().stream().map(persona -> persona.getNombre())
				.collect(Collectors.toList());

		return new PlanetaDTO(planeta.getNombre(), planeta.getPeriodoRotacion(), planeta.getDiametro(),
				planeta.getTerreno(), planeta.getClima(), planeta.getCantidadVisitas(), personas);
	}
}
