package com.trycore.planetario.microservicio.infraestructura.personas.controladores.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.personas.comando.ManejadorContadorVisitasPersona;

@RestController
@RequestMapping("/planetario/v1/personas")
public class PersonaControladorComando {

	@Autowired
	private ManejadorContadorVisitasPersona manejadorContadorVisitas;

	@PutMapping("/{numeroIdentificacion}/visitas")
	public void incrementarVisitas(@PathVariable int numeroIdentificacion) {
		manejadorContadorVisitas.ejecutar(numeroIdentificacion);
	}
}
