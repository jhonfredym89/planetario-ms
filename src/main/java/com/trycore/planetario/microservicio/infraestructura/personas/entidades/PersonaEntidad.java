package com.trycore.planetario.microservicio.infraestructura.personas.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.trycore.planetario.microservicio.infraestructura.planetas.entidades.PlanetaEntidad;

@Entity
@Table(name = "personas")
public class PersonaEntidad implements Serializable {

	private static final long serialVersionUID = -997610595317154577L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "numero_identificacion", unique = true, nullable = false)
	private int numeroIdentificacion;

	@Column(nullable = false)
	private String nombre;

	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(nullable = false, length = 1)
	private String genero;

	@Column(name = "estatura_en_metros")
	private Float estaturaEnMetros;

	@Column(name = "peso_en_kilogramos")
	private Float pesoEnKilogramos;

	@Column(name = "cantidad_visitas")
	private Integer cantidadVisitas;

	@ManyToOne(fetch = FetchType.LAZY)
	private PlanetaEntidad planeta;

	public Integer getId() {
		return id;
	}

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public Float getEstaturaEnMetros() {
		return estaturaEnMetros;
	}

	public Float getPesoEnKilogramos() {
		return pesoEnKilogramos;
	}

	public Integer getCantidadVisitas() {
		return cantidadVisitas;
	}

	public PlanetaEntidad getPlaneta() {
		return planeta;
	}
}
