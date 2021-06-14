package com.trycore.planetario.microservicio.infraestructura.personas.controladores.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.personas.comando.ManejadorContadorVisitasPersona;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/planetario/v1/personas")
@Api(tags = "Personas Controlador")
public class PersonaControladorComando {

	@Autowired
	private ManejadorContadorVisitasPersona manejadorContadorVisitas;

	@PutMapping("/{numeroIdentificacion}/visitas")
	@ApiOperation(value = "Incrementar Visitas", notes = "Servicio para incrementar el contador de visitas tanto de una persona como del planeta donde vive, indicando el número de identificación de la Persona.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se incrementó en uno la cantidad de visitas de la persona y su planeta"),
			@ApiResponse(code = 204, message = "No existe la Persona") })
	public void incrementarVisitas(@PathVariable int numeroIdentificacion) {
		manejadorContadorVisitas.ejecutar(numeroIdentificacion);
	}
}
