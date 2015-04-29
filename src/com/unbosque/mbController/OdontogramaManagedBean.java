package com.unbosque.mbController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;




import com.unbosque.entidad.Odontograma;
import com.unbosque.service.OdontogramaService;

@ManagedBean(name = "odontogramaMBController")
@ViewScoped
public class OdontogramaManagedBean implements Serializable {

	private static final long serialVersionUID = -833450576444506528L;

		// Spring Customer Service is injected...
		@ManagedProperty(value = "#{OdontogramaService}")
		OdontogramaService odontogramaService;






		List<Odontograma> odontogramaList;

		private Integer id;

		private Integer idDiente;

		private Integer idPaciente;

		private Integer idPropiedad;
	
		
		public void addOdontograma() {
			try {
				FacesContext context = FacesContext.getCurrentInstance();

			
				FacesMessage message = null;
				
				Odontograma odontograma = new Odontograma();
		
				odontograma.setId(1);
				odontograma.setIdPaciente(getIdPaciente());
	         	odontograma.setIdDiente(getIdDiente());
	         	odontograma.setIdPropiedad(getIdPropiedad());
				
				
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

		}
		
		public String deleteOdontograma(Odontograma odontograma) {
			try {
			//	odontograma.setEstado("I");
				getOdontogramaService().updateOdontograma(odontograma);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			return null;

		}
		
	    public void reset() {
	    	
	    	
			this.setIdPaciente(0);
         	this.setIdDiente(0);
         	this.setIdPropiedad(0);
	    	
	    	      
	    }

		 
		 public void modificarOdontograma(Odontograma odontograma){
		        try {
		        	RequestContext context = RequestContext.getCurrentInstance();
		            FacesMessage msgs= null;
		        	
		        	odontograma.setIdPaciente(getIdPaciente());
		         	odontograma.setIdDiente(getIdDiente());
		         	odontograma.setIdPropiedad(getIdPropiedad());
					
		          
		            getOdontogramaService().updateOdontograma(odontograma);
		            msgs = new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo",
		                    "Registro agregado exitosamente.");

		        } catch (DataAccessException e) {
		            e.printStackTrace();
		        }
		        
		    }



		public List<Odontograma> getOdontogramasList() {
			odontogramaList = new ArrayList<Odontograma>();
			odontogramaList.addAll(getOdontogramaService().getOdontogramas());
			
			
			return odontogramaList;
			
		}


		public OdontogramaService getOdontogramaService() {
			return odontogramaService;
		}



		public void setOdontogramaService(OdontogramaService odontogramaService) {
			this.odontogramaService = odontogramaService;
		}



		public List<Odontograma> getOdontogramaList() {
			return odontogramaList;
		}

		public void setOdontogramaList(List<Odontograma> odontogramaList) {
			this.odontogramaList = odontogramaList;
		}

		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getIdDiente() {
			return idDiente;
		}

		public void setIdDiente(Integer idDiente) {
			this.idDiente = idDiente;
		}

		public Integer getIdPaciente() {
			return idPaciente;
		}

		public void setIdPaciente(Integer idPaciente) {
			this.idPaciente = idPaciente;
		}

		public Integer getIdPropiedad() {
			return idPropiedad;
		}

		public void setIdPropiedad(Integer idPropiedad) {
			this.idPropiedad = idPropiedad;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}



	}
