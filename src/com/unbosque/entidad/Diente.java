package com.unbosque.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the diente database table.
 * 
 */
@Entity
@NamedQuery(name="Diente.findAll", query="SELECT d FROM Diente d")
public class Diente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	private Integer id;

	private String nombre;

	public Diente() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}