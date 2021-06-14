package com.trycore.planetario.microservicio.infraestructura.planetas.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trycore.planetario.microservicio.infraestructura.personas.entidades.PersonaEntidad;

@Entity
@Table(name = "planetas")
public class PlanetaEntidad implements Serializable {

	private static final long serialVersionUID = 3083498352750955902L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false)
	private String nombre;

	@Column(name = "periodo_rotacion", nullable = false)
	private float periodoRotacion;

	@Column(nullable = false)
	private int diametro;

	@Column(nullable = false)
	private String terreno;

	private String clima;

	@Column(name = "cantidad_visitas")
	private Integer cantidadVisitas;

	@OneToMany(mappedBy = "planeta", fetch = FetchType.LAZY)
	private List<PersonaEntidad> personas;

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPeriodoRotacion() {
		return periodoRotacion;
	}

	public int getDiametro() {
		return diametro;
	}

	public String getTerreno() {
		return terreno;
	}

	public String getClima() {
		return clima;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}

	public List<PersonaEntidad> getPersonas() {
		return personas;
	}
}
