package com.trycore.planetario.microservicio.infraestructura.planetas.controladores.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.planetas.consulta.ManejadorPersonasPorPlaneta;
import com.trycore.planetario.microservicio.aplicacion.planetas.consulta.ManejadorPlanetaConsulta;
import com.trycore.planetario.microservicio.aplicacion.planetas.consulta.ManejadorTopPlanetas;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.CantidadPersonasPorPlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.TopPlanetasDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/planetario/v1/planetas")
@Api(tags = "Planetas Consultas")
public class PlanetaControladorConsulta {

	@Autowired
	private ManejadorPersonasPorPlaneta manejadorPersonasPorPlaneta;

	@Autowired
	private ManejadorPlanetaConsulta manejadorPlanetaConsulta;

	@Autowired
	private ManejadorTopPlanetas manejadorTopPlanetas;

	@GetMapping
	@ApiOperation(value = "Listar", notes = "Servicio para listar todos los Planetas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Planetas encontrados correctamente"),
			@ApiResponse(code = 204, message = "No hay Planetas registrados") })
	public List<CantidadPersonasPorPlanetaDTO> listar() {
		return manejadorPersonasPorPlaneta.ejecutar();
	}

	@GetMapping("/{nombre}")
	@ApiOperation(value = "Consultar Planeta", notes = "Servicio para consultar un Planeta por su nombre")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Planeta encontrado correctamente"),
			@ApiResponse(code = 204, message = "El Planeta no está registrado") })
	public PlanetaDTO consultarPorNombre(@PathVariable String nombre) {
		return manejadorPlanetaConsulta.ejecutar(nombre);
	}

	@GetMapping("/top")
	@ApiOperation(value = "Listar Top", notes = "Servicio para listar el Top 3 de Planetas más visitados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Planetas encontrados correctamente"),
			@ApiResponse(code = 204, message = "No hay Planetas registrados") })
	public List<TopPlanetasDTO> listarTop() {
		return manejadorTopPlanetas.ejecutar();
	}
}
