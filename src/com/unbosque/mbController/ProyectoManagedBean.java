package com.unbosque.mbController;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.springframework.dao.DataAccessException;

import com.unbosque.entidad.Departamento;
import com.unbosque.entidad.Ciudad;
import com.unbosque.entidad.Proyecto;
import com.unbosque.entidad.Usuario;
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
	
    private Integer id;
	private String nombre;
	private String estado;
	private String departamento;
	private String ciudad;
	List<Proyecto> proyectoList;
	List<String> pro;
	
    public void addProyecto() {
        try {

            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage message = null;
            

            
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
    public void modificarUsuario(Proyecto proyecto) throws IOException{
        try {
        	RequestContext context = RequestContext.getCurrentInstance();
   		 	FacesContext context1 = FacesContext.getCurrentInstance();

            FacesMessage msgs= null;

        	System.out.println(getCiudad());
        	System.out.println(getDepartamento());
        	System.out.println(getNombre());

        	
          //  proyectojurado.setDocenteId(getDocenteId());
            proyecto.setEstado(getEstado().charAt(0));
            proyecto.setCiudad(getCiudad());
            proyecto.setDepto(getDepartamento());
            proyecto.setNombre(getNombre());
          
            getProyectoService().updateProyecto(proyecto);
			context1.getExternalContext().redirect("ConsultaProyect.xhtml");	

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Guardado exitosamente!"));


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
    	pro = new ArrayList<String>();
        proyectoList = new ArrayList<Proyecto>();
        proyectoList.addAll(getProyectoService().getProyectos());
        for (int i = 0; i < proyectoList.size(); i++) {
        	pro.add(proyectoList.get(i).getNombre());
			
		}
        return pro;
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

	public Integer getId() {
		return id;
	}
	public List<String> getPro() {
		return pro;
	}
	public void setPro(List<String> pro) {
		this.pro = pro;
	}
	
}