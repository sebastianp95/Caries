package com.unbosque.entidad;

// Generated May 1, 2015 9:14:54 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Odontograma generated by hbm2java
 */
@Entity
@Table(name = "odontograma", schema = "public")
public class Odontograma implements java.io.Serializable {

	private int id;
	private int idPaciente;
	private int idDiente;
	private int idPropiedad;

	public Odontograma() {
	}

	public Odontograma(int id, int idPaciente, int idDiente, int idPropiedad) {
		this.id = id;
		this.idPaciente = idPaciente;
		this.idDiente = idDiente;
		this.idPropiedad = idPropiedad;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "id_paciente", nullable = false)
	public int getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Column(name = "id_diente", nullable = false)
	public int getIdDiente() {
		return this.idDiente;
	}

	public void setIdDiente(int idDiente) {
		this.idDiente = idDiente;
	}

	@Column(name = "id_propiedad", nullable = false)
	public int getIdPropiedad() {
		return this.idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

}
