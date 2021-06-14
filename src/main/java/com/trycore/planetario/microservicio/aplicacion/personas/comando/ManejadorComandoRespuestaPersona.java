package com.trycore.planetario.microservicio.aplicacion.personas.comando;

import org.springframework.stereotype.Service;

import com.trycore.planetario.comun.aplicacion.manejadores.ManejadorComandoRespuesta;
import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaDTO;

@Service
public class ManejadorComandoRespuestaPersona implements ManejadorComandoRespuesta<PersonaDTO, Integer> {

	@Override
	public Integer ejecutar(PersonaDTO comando) {
		// TODO Auto-generated method stub
		return null;
	}

}
