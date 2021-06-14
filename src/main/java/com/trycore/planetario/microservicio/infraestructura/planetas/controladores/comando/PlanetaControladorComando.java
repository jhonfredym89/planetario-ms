package com.trycore.planetario.microservicio.infraestructura.planetas.controladores.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.planetas.comando.ManejadorContadorVisitasPlaneta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/planetario/v1/planetas")
@Api(tags = "Planetas Comando")
public class PlanetaControladorComando {

	@Autowired
	private ManejadorContadorVisitasPlaneta manejadorContadorVisitas;

	@PutMapping("/{nombre}/visitas")
	@ApiOperation(value = "Incrementar Visitas", notes = "Servicio para incrementar el contador de visitas de un Planeta, indicando su nombre.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se incrementó en uno la cantidad de visitas del Planeta"),
			@ApiResponse(code = 204, message = "No existe el Planeta") })
	public void incrementarVisitas(@PathVariable String nombre) {
		manejadorContadorVisitas.ejecutar(nombre);
	}
}
