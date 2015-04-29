package com.unbosque.entidad;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the odontograma database table.
 * 
 */
@Entity
@Table(name="odontograma")
@NamedQuery(name="Odontograma.findAll", query="SELECT o FROM Odontograma o")
public class Odontograma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="id_diente")
	private Integer idDiente;

	@Column(name="id_paciente")
	private Integer idPaciente;

	@Column(name="id_propiedad")
	private Integer idPropiedad;

	public Odontograma() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdDiente() {
		return this.idDiente;
	}

	public void setIdDiente(Integer idDiente) {
		this.idDiente = idDiente;
	}

	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdPropiedad() {
		return this.idPropiedad;
	}

	public void setIdPropiedad(Integer idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

}