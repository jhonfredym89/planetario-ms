package com.trycore.planetario.microservicio.infraestructura.planetas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
}
