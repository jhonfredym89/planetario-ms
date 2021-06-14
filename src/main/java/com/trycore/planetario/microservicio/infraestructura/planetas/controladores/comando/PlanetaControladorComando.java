package com.trycore.planetario.microservicio.infraestructura.planetas.controladores.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetario.microservicio.aplicacion.planetas.comando.ManejadorContadorVisitasPlaneta;

@RestController
@RequestMapping("/planetario/v1/planetas")
public class PlanetaControladorComando {

	@Autowired
	private ManejadorContadorVisitasPlaneta manejadorContadorVisitas;

	@PutMapping("/{nombre}/visitas")
	public void incrementarVisitas(@PathVariable String nombre) {
		manejadorContadorVisitas.ejecutar(nombre);
	}
}
