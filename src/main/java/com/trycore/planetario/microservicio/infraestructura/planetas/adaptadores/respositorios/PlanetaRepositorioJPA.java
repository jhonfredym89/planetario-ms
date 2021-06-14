package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.infraestructura.planetas.entidades.PlanetaEntidad;

public interface PlanetaRepositorioJPA extends JpaRepository<PlanetaEntidad, Integer> {

	@Query(value = "SELECT new com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO(pla.nombre, COUNT(per.id)) FROM PersonaEntidad per RIGHT JOIN per.planeta pla GROUP BY pla.nombre")
	List<CantidadPersonasPorPlanetaDTO> listarPersonasPorPlaneta();

	PlanetaEntidad findByNombre(String nombre);
}
