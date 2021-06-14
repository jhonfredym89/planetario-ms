package com.trycore.planetario.microservicio.aplicacion.personas.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trycore.planetario.comun.aplicacion.manejadores.ManejadorComando;
import com.trycore.planetario.microservicio.aplicacion.personas.fabrica.PersonaFabricaAplicacion;
import com.trycore.planetario.microservicio.aplicacion.planetas.comando.ManejadorContadorVisitasPlaneta;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;
import com.trycore.planetario.microservicio.dominio.personas.modelo.entidades.Persona;
import com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.comando.PersonaRepositorioComando;
import com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.consulta.PersonaRepositorioConsulta;

@Component
public class ManejadorContadorVisitasPersona implements ManejadorComando<Integer> {

	@Autowired
	private PersonaRepositorioConsulta repositorioConsulta;

	@Autowired
	private PersonaRepositorioComando repositorioComando;

	@Autowired
	private PersonaFabricaAplicacion fabrica;

	@Autowired
	private ManejadorContadorVisitasPlaneta manejadorContadorVisitasPlaneta;

	@Override
	public void ejecutar(Integer comando) {
		PersonaDTO personaDTO = repositorioConsulta.consultarPorNumeroIdentificacion(comando);
		Persona persona = fabrica.mapearPersonaDTOAPersona(personaDTO);
		persona.sumarVisitas();
		repositorioComando.actualizarVisitas(persona);
		manejadorContadorVisitasPlaneta.ejecutar(personaDTO.getPlaneta());
	}

}
