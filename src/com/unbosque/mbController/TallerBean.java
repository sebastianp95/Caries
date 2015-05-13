package com.unbosque.mbController;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tallerMBController")
@ViewScoped
public class TallerBean implements Serializable {
	private static final long serialVersionUID = -833450576444506528L;
    final String world = "Hello World!";

	 private String nombre;
	 private String sexo;
	 private List<String> info;	 
	 private String tipo;
	 private String b;
	
	 
	 public String enviar() throws IOException{
		 
System.out.println(info.size());

System.out.println(nombre);
		if(info.size()==1){
			return "Resultado1.xhtml"+ "?faces-redirect=true&nombre=" + nombre;
		}
		if(info.size()==2){
			setTipo(info.get(0));
			setB(info.get(1));
			return "Resultado2.xhtml"+ "?faces-redirect=true&nombre=" + nombre;
    		
		}
		return null;

	 }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public List<String> getInfo() {
		return info;
	}


	public void setInfo(List<String> info) {
		this.info = info;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getB() {
		return b;
	}


	public void setB(String b) {
		this.b = b;
	}


	public String getWorld() {
		return world;
	}


	 
	 
}

