package com.unbosque.mbController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;

import com.unbosque.entidad.Departamento;
import com.unbosque.entidad.Ciudad;
import com.unbosque.entidad.Proyecto;
import com.unbosque.service.ProyectoService;

@ManagedBean(name = "proyectoMBController")
@SessionScoped
public class ProyectoManagedBean implements Serializable {

    private static final long serialVersionUID = -7809396168460749463L;

    // Spring Customer Service is injected...
    @ManagedProperty(value = "#{ProyectoService}")
    ProyectoService proyectoService;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}

	List<Proyecto> proyectoList;

    private Integer id;
	private String nombre;
	private String estado;
	private String departamento;
	private String ciudad;
   private List<Proyecto> Proyectos;
	
    public void addProyecto() {
        try {

            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage message = null;
            System.out.println(nombre);
            System.out.println(ciudad);
            System.out.println(departamento);

            
           Proyecto proyecto = new Proyecto();
           proyecto.setEstado('A');
           proyecto.setCiudad(getCiudad());
           proyecto.setDepto(getDepartamento());
           proyecto.setNombre(getNombre());
           
            getProyectoService().addProyecto(proyecto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Guardado exitosamente!"));

            reset();

        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
    public String deleteProyecto(Proyecto proyecto){
        try {
//            proyecto.setEstado("I");
            getProyectoService().updateProyecto(proyecto);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

    public void reset() {
        this.setId(0);
        this.setEstado("");
        this.setCiudad("");
        this.setDepartamento("");
        this.setNombre("");
    }

    public List<Proyecto> getProyectosList() {
        proyectoList = new ArrayList<Proyecto>();
        proyectoList.addAll(getProyectoService().getProyectos());
//        for (listaProyecto<>list= proyectoList) {
//			ciudad=getProyectoService().
//		}
        return proyectoList;
    }

    public List<String> getProyectosListNombre() {
    	ArrayList<String> pro = new ArrayList<String>();
        proyectoList = new ArrayList<Proyecto>();
        proyectoList.addAll(getProyectoService().getProyectos());
        for (int i = 0; i < proyectoList.size(); i++) {
        	pro.add(proyectoList.get(i).getNombre());
			
		}
        return pro;
    }
    
    public ProyectoService getProyectoService() {
        return proyectoService;
    }

    public void setProyectoService(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public List<Proyecto> getProyectos() {
		return Proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		Proyectos = proyectos;
	}

}