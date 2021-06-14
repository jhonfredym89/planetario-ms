package com.trycore.planetario.microservicio.aplicacion.planetas.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycore.planetario.comun.aplicacion.manejadores.ManejadorComando;
import com.trycore.planetario.microservicio.aplicacion.planetas.fabrica.PlanetaFabricaAplicacion;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.dtos.PlanetaDTO;
import com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades.Planeta;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.comando.PlanetaRepositorioComando;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.consulta.PlanetaRepositorioConsulta;

@Service
public class ManejadorContadorVisitasPlaneta implements ManejadorComando<String> {

	@Autowired
	private PlanetaRepositorioConsulta repositorioConsulta;

	@Autowired
	private PlanetaFabricaAplicacion fabrica;

	@Autowired
	private PlanetaRepositorioComando repositorio;

	@Override
	public void ejecutar(String comando) {
		PlanetaDTO planetaDTO = repositorioConsulta.consultarPorNombre(comando);
		Planeta planeta = fabrica.mapearDTOAPlaneta(planetaDTO);
		planeta.sumarVisitas();
		repositorio.actualizarVisitas(planeta);
	}

}
