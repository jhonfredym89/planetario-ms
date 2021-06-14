package com.trycore.planetario.microservicio.aplicacion.planetas.fabrica;

import org.springframework.stereotype.Component;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades.Planeta;

@Component
public class PlanetaFabricaAplicacion {

	public Planeta mapearDTOAPlaneta(PlanetaDTO planetaDTO) {
		return new Planeta(planetaDTO.getNombre(), planetaDTO.getPeriodoRotacion(), planetaDTO.getDiametro(),
				planetaDTO.getTerreno(), planetaDTO.getClima(), planetaDTO.getCantidadVisitas());
	}
}
