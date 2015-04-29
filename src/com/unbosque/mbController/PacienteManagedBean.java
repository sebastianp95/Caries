package com.unbosque.mbController;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;







import com.unbosque.entidad.Paciente;
import com.unbosque.service.PacienteService;

@ManagedBean(name = "pacienteMBController")
@ViewScoped
public class PacienteManagedBean implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -833450576444506528L;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{PacienteService}")
	PacienteService pacienteService;






	List<Paciente> pacienteList;

	
	private Integer id;
	
	private String nombresApellidos;
	
	private String correo;

	private String estado;
	
	private Integer idProyecto;

	private Integer identificacion;

	private String telefono;
	
	private Email mail;
	
	
	public void addPaciente() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			
			FacesMessage message = null;
			
			Paciente paciente = new Paciente();
				
			paciente.setNombresApellidos(getNombresApellidos());
			paciente.setCorreo(getCorreo());
			paciente.setIdProyecto(getIdProyecto());
			paciente.setIdentificacion(getIdentificacion());
			paciente.setTelefono(getTelefono().toString());
			paciente.setEstado("A");  
			
			   getPacienteService().addPaciente(paciente);
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
	                    "Registro agregado exitosamente.");

			enviaMail(getCorreo(),getNombresApellidos(),getEstado());



		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}
	
	public void enviaMail(String mail,String paciente,String contrasena){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		
        String clave = "bosqueproyectocaries"; 
        Email e = new Email("proyectocaries@gmail.com",clave,mail,"Proyecto Caries","paciente: "+paciente+"   Estado: "+contrasena);
        if (e.sendMail()){
            
            FacesMessage msg = new FacesMessage(".","El email se envio correctamente");
        }else{
           
            context.addMessage(null, new FacesMessage(".", "El email no se envio correctamente") );
        }
    }
	
	
	public String deletePaciente(Paciente paciente) {
		try {
			paciente.setEstado("I");
			getPacienteService().updatePaciente(paciente);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return null;

	}
	
    public void reset() {
    	
		this.setNombresApellidos("");
		this.setCorreo("");
		this.setIdProyecto(0);
		this.setIdentificacion(0);
		this.setTelefono("");
		this.setEstado("");  
    	
    	      
    }

	 
	 public void modificarPaciente(Paciente paciente){
	        try {
	        	RequestContext context = RequestContext.getCurrentInstance();
	            FacesMessage msgs= null;
	        	

				paciente.setNombresApellidos(getNombresApellidos());
				paciente.setCorreo(getCorreo());
				paciente.setIdProyecto(getIdProyecto());
				paciente.setIdentificacion(getIdentificacion());
				paciente.setTelefono(getTelefono());
				paciente.setEstado("A");  
	          
	            getPacienteService().updatePaciente(paciente);
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


	public List<Paciente> getPacientesList() {
		pacienteList = new ArrayList<Paciente>();
		pacienteList.addAll(getPacienteService().getPacientes());
		
		
		return pacienteList;
		
	}
	 
	 
	 public void  logOut() throws IOException{
			 FacesContext context=FacesContext.getCurrentInstance();
			   context.getExternalContext().redirect("Login.xhtml");		 
			   }
		 

	public PacienteService getPacienteService() {
		return pacienteService;
	}





	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}





	public List<Paciente> getPacienteList() {
		return pacienteList;
	}

	

	public void setPacienteList(List<Paciente> pacienteList) {
		this.pacienteList = pacienteList;
	}
	
	

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


}