package com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trycore.planetario.microservicio.dominio.planetas.modelo.entidades.Planeta;
import com.trycore.planetario.microservicio.dominio.planetas.puertos.repositorios.comando.PlanetaRepositorioComando;
import com.trycore.planetario.microservicio.infraestructura.planetas.adaptadores.respositorios.PlanetaRepositorioJPA;

@Repository
public class PlanetaRepositorioComandoImpl implements PlanetaRepositorioComando {

	@Autowired
	private PlanetaRepositorioJPA planetaRepositorio;

	@Override
	public void actualizarVisitas(Planeta planeta) {
		planetaRepositorio.actualizarVisitas(planeta.getCantidadVisitas(), planeta.getNombre());
	}

}
