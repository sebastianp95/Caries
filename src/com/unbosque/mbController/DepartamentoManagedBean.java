package com.unbosque.mbController;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.OneToMany;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;

import com.unbosque.entidad.Proyecto;
import com.unbosque.entidad.Departamento;
import com.unbosque.entidad.Usuario;
import com.unbosque.service.DepartamentoService;

@ManagedBean(name = "departamentoMBController")
@SessionScoped
public class DepartamentoManagedBean implements Serializable {

    private static final long serialVersionUID = -7809396168460749463L;

    // Spring Customer Service is injected...
    @ManagedProperty(value = "#{DepartamentoService}")
    DepartamentoService departamentoService;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}

	List<Departamento> departamentoList;

	private Integer id;
	private String nombre;
	private String estado;
	private List<Proyecto> proyectos;

    public void addDepartamento() {
        try {

            Departamento departamento = new Departamento();
            departamento.setNombre(getNombre());
            departamento.setEstado('A');
            getDepartamentoService().addDepartamento(departamento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Guardado exitosamente!"));

            reset();

        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
    public String deleteDepartamento(Departamento departamento){
        try {
            departamento.setEstado('I');
            getDepartamentoService().updateDepartamento(departamento);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

    public void reset() {
        this.setId(0);
        this.setNombre("");
        this.setEstado("");
    }
	 public void modificarDepartamento(Departamento departamento){
	        try {
	        	RequestContext context = RequestContext.getCurrentInstance();
	            FacesMessage msgs= null;
	        	
	            departamento.setNombre(getNombre());
	            departamento.setEstado(getEstado().charAt(0));
	            
	                 
	           
	           
	            getDepartamentoService().updateDepartamento(departamento);
	            msgs = new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo",
	                    "Registro agregado exitosamente.");

	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }
	        
	    }



	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Titulo","Cancelar");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

    
    public List<Departamento> getDepartamentosList() {
        departamentoList = new ArrayList<Departamento>();
        departamentoList.addAll(getDepartamentoService().getDepartamentos());
        return departamentoList;
    }
    
    public List<String> getDepartamentosNombre() {
        departamentoList = new ArrayList<Departamento>();
        List<String> dep = new ArrayList<String>();
        departamentoList.addAll(getDepartamentoService().getDepartamentos());
        for (int i = 0; i < departamentoList.size(); i++) {
        	dep.add(departamentoList.get(i).getNombre());
		}
        return dep;
    }

    public DepartamentoService getDepartamentoService() {
        return departamentoService;
    }

    public void setDepartamentoService(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
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
	public List<Departamento> getDepartamentoList() {
		return departamentoList;
	}
	public void setDepartamentoList(List<Departamento> departamentoList) {
		this.departamentoList = departamentoList;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}