package com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trycore.planetario.microservicio.dominio.personas.modelo.entidades.Persona;
import com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.comando.PersonaRepositorioComando;
import com.trycore.planetario.microservicio.infraestructura.personas.adaptadores.repositorios.PersonaRepositorioJPA;

@Repository
public class PersonaRepositorioComandoImpl implements PersonaRepositorioComando {

	@Autowired
	private PersonaRepositorioJPA personaRepositorio;

	@Override
	public void actualizarVisitas(Persona persona) {
		personaRepositorio.actualizarVisitas(persona.getCantidadVisitas(), persona.getNumeroIdentificacion());
	}

}
