package com.trycore.planetario.microservicio.infraestructura.planetas.controladores.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.planetas.consulta.ManejadorPersonasPorPlaneta;
import com.trycore.planetario.microservicio.aplicacion.planetas.consulta.ManejadorPlanetaConsulta;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;

@RestController
@RequestMapping("/planetario/v1/planetas")
public class PlanetaControladorConsulta {

	@Autowired
	private ManejadorPersonasPorPlaneta manejadorPersonasPorPlaneta;

	@Autowired
	private ManejadorPlanetaConsulta manejadorPlanetaConsulta;

	@GetMapping
	public List<CantidadPersonasPorPlanetaDTO> listar() {
		return manejadorPersonasPorPlaneta.ejecutar();
	}

	@GetMapping("/{nombre}")
	public PlanetaDTO consultarPorNombre(@PathVariable String nombre) {
		return manejadorPlanetaConsulta.ejecutar(nombre);
	}
}
