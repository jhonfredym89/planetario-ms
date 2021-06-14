package com.trycore.planetario.microservicio.infraestructura.personas.controladores.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.personas.consulta.ManejadorConsultaPersona;
import com.trycore.planetario.microservicio.aplicacion.personas.consulta.ManejadorInfoGeneralPersona;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/planetario/v1/personas")
@Api(tags = "Personas Consulta")
public class PersonaControladorConsulta {

	@Autowired
	private ManejadorInfoGeneralPersona manejadorLugarViviendaPersona;

	@Autowired
	private ManejadorConsultaPersona manejadorConsultaPersona;

	@GetMapping
	@ApiOperation(value = "Listar", notes = "Servicio para listar todas las Personas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Personas encontradas correctamente"),
			@ApiResponse(code = 204, message = "No hay Personas registradas") })
	public List<PersonaInfoGeneralDTO> listar() {
		return manejadorLugarViviendaPersona.ejecutar();
	}

	@GetMapping("/{numeroIdentificacion}")
	@ApiOperation(value = "Consultar Persona", notes = "Servicio para consultar una Persona por su identificación")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona encontrada correctamente"),
			@ApiResponse(code = 204, message = "La Persona no está registrada") })
	private PersonaDTO consultarPorNumeroIdentificacion(@PathVariable int numeroIdentificacion) {
		return manejadorConsultaPersona.ejecutar(numeroIdentificacion);
	}
}
