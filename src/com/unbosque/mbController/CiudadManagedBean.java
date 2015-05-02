package com.unbosque.mbController;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.OneToMany;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;

import com.unbosque.entidad.Departamento;
import com.unbosque.entidad.Proyecto;
import com.unbosque.entidad.Ciudad;
import com.unbosque.service.CiudadService;

@ManagedBean(name = "ciudadMBController")
@SessionScoped
public class CiudadManagedBean implements Serializable {

    private static final long serialVersionUID = -7809396168460749463L;

    // Spring Customer Service is injected...
    @ManagedProperty(value = "#{CiudadService}")

    
    CiudadService ciudadService;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}

	List<Ciudad> ciudadList;
	List<String> ciu;
	List<String> ciuno;
	private Integer id;
	private String nombre;
	private String estado;
	private String departamento="ko";
	private List<Proyecto> proyectos;

    public void addCiudad() {
        try {

            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage message = null;

            Ciudad ciudad = new Ciudad();
            ciudad.setNombre(getNombre());
            ciudad.setEstado('A');
            ciudad.setDepto(getDepartamento());
            getCiudadService().addCiudad(ciudad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Guardado exitosamente!"));

            reset();

        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
    public String deleteCiudad(Ciudad ciudad){
        try {
            ciudad.setEstado('I');
            getCiudadService().updateCiudad(ciudad);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

    public void reset() {
        this.setId(0);
        this.setNombre("");
        this.setEstado("");
        this.setDepartamento("");
    }

    public void modificarCiudad(Ciudad ciudad){
        try {
        	RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage msgs= null;
        	
            ciudad.setNombre(getNombre());
            ciudad.setDepto(getDepartamento());
            ciudad.setEstado(getEstado().charAt(0));
            
                 
           
           
            getCiudadService().updateCiudad(ciudad);
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


    public List<Ciudad> getCiudadsList() {
        ciudadList = new ArrayList<Ciudad>();
        ciudadList.addAll(getCiudadService().getCiudads());
        return ciudadList;
    }
    
    public void getCiudadsLista(ComponentSystemEvent a) {
        ciudadList = new ArrayList<Ciudad>();
        ciudadList.addAll(getCiudadService().getCiudads());
    }
    
    public List<String> getCiudadsListNombre() {
    ciuno = new ArrayList<String>();
        ciudadList = new ArrayList<Ciudad>();
        ciudadList.addAll(getCiudadService().getCiudads());
        for (int i = 0; i < ciudadList.size(); i++) {
			ciuno.add(ciudadList.get(i).getNombre());
		}
		Collections.sort(ciuno);
        return ciuno;
    }
    
    
    public void getCiudadDep(ValueChangeEvent e) {
    	departamento=e.getNewValue().toString();
    	ciu = new ArrayList<String>();
        ciudadList = new ArrayList<Ciudad>();
        ciudadList.addAll(getCiudadService().getCiudads());
    	try {
    		
            for (int i = 0; i < ciudadList.size(); i++) {
            	System.out.println(departamento);
            	System.out.println(ciudadList.get(i).getDepto());
            	if(departamento.equals(ciudadList.get(i).getDepto())){
            	ciu.add(ciudadList.get(i).getNombre());
            	}
    		}for (int i = 0; i < ciu.size(); i++) {
    			System.out.println(ciu.get(i));
				
			}
		} catch (Exception b) {
			// TODO: handle exception
		}
    	
  }
    
    
//   public Integer idDep(){
//		DepartamentoManagedBean dep = new 	DepartamentoManagedBean();
//		
//   for (int i = 0; i < dep.getDepartamentosList().size(); i++) {
//	   if(departamento.equals(dep.getDepartamentosList().get(i).getNombre())){
//		   return dep.getDepartamentosList().get(i).getId();
//	   }
//	
//}
//	   
//	return id;
//	   
//   }

    public CiudadService getCiudadService() {
        return ciudadService;
    }

    public void setCiudadService(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
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
	public List<Ciudad> getCiudadList() {
		return ciudadList;
	}
	public void setCiudadList(List<Ciudad> ciudadList) {
		this.ciudadList = ciudadList;
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
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public List<String> getCiu() {
		return ciu;
	}
	public void setCiu(List<String> ciu) {
		this.ciu = ciu;
	}
	public List<String> getCiuno() {
		return ciuno;
	}
	public void setCiuno(List<String> ciuno) {
		this.ciuno = ciuno;
	}
	

	
}