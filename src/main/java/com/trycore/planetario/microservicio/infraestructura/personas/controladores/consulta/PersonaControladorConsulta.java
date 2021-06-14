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

@RestController
@RequestMapping("/planetario/v1/personas")
public class PersonaControladorConsulta {

	@Autowired
	private ManejadorInfoGeneralPersona manejadorLugarViviendaPersona;

	@Autowired
	private ManejadorConsultaPersona manejadorConsultaPersona;

	@GetMapping
	public List<PersonaInfoGeneralDTO> listar() {
		return manejadorLugarViviendaPersona.ejecutar();
	}

	@GetMapping("/{numeroIdentificacion}")
	private PersonaDTO consultarPorNumeroIdentificacion(@PathVariable int numeroIdentificacion) {
		return manejadorConsultaPersona.ejecutar(numeroIdentificacion);
	}
}
