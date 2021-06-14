package com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO;
import com.trycore.planetario.microservicio.infraestructura.personas.entidades.PersonaEntidad;


public interface PersonaRepositorioJPA extends JpaRepository<PersonaEntidad, Integer> {

	@Query(value = "SELECT new com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO(per.numeroIdentificacion, per.nombre, per.cantidadVisitas, pla.nombre) FROM PersonaEntidad per INNER JOIN per.planeta pla")
	List<PersonaInfoGeneralDTO> listarLugaresViviendaPersonas();

	PersonaEntidad findByNumeroIdentificacion(int numeroIdentificacion);

	@Modifying
	@Query(value = "UPDATE personas SET cantidad_visitas = :cantidad WHERE numero_identificacion = :numero", nativeQuery = true)
	void actualizarVisitas(@Param("cantidad") int cantidad, @Param("numero") int numero);
}
