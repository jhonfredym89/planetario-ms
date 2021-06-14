package com.trycore.planetario.microservicio.aplicacion.personas.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trycore.planetario.microservicio.dominio.personas.modelo.dtos.PersonaInfoGeneralDTO;
import com.trycore.planetario.microservicio.dominio.personas.puertos.repositorios.consulta.PersonaRepositorioConsulta;

@Service
@Transactional(readOnly = true)
public class ManejadorInfoGeneralPersona {

	@Autowired
	private PersonaRepositorioConsulta personaRepositorioConsulta;

	public List<PersonaInfoGeneralDTO> ejecutar() {
		return personaRepositorioConsulta.listar();
	}
}
