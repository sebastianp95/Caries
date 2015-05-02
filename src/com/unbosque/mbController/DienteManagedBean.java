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





import com.unbosque.entidad.Diente;
import com.unbosque.service.DienteService;

@ManagedBean(name = "dienteMBController")
@ViewScoped
public class DienteManagedBean implements Serializable {

	private static final long serialVersionUID = -833450576444506528L;

		// Spring Customer Service is injected...
		@ManagedProperty(value = "#{DienteService}")
		DienteService dienteService;






		List<Diente> dienteList;

		private int id;
		private Integer darriba1;
		private Integer dabajo1;
		private Integer dcentro1;
		private Integer dizquierda1;
		private Integer dderecha1;
	
		
		public void addDiente() {
			try {
				FacesContext context = FacesContext.getCurrentInstance();

			
				FacesMessage message = null;
				
				Diente diente = new Diente();
		
				diente.setDarriba1(getDarriba1());
				diente.setDabajo1(getDabajo1());
				diente.setDcentro1(getDcentro1());
				diente.setDizquierda1(getDizquierda1());
				diente.setDderecha1(getDderecha1());

	         	
	         	
				   getDienteService().addDiente(diente);
		            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
		                    "Registro agregado exitosamente.");

				
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

		}
		
		public String deleteDiente(Diente diente) {
			try {
			//	Diente.setEstado("I");
				getDienteService().updateDiente(diente);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			return null;

		}
		
	    public void reset() {
	    	
	    	
			this.setDarriba1(0);
			this.setDabajo1(0);
			this.setDcentro1(0);
			this.setDizquierda1(0);
			this.setDderecha1(0);

	    	
	    	      
	    }

		 
		 public void modificarDiente(Diente diente){
		        try {
		        	RequestContext context = RequestContext.getCurrentInstance();
		            FacesMessage msgs= null;
		        	
					diente.setDarriba1(getDarriba1());
					diente.setDabajo1(getDabajo1());
					diente.setDcentro1(getDcentro1());
					diente.setDizquierda1(getDizquierda1());
					diente.setDderecha1(getDderecha1());

		          
		            getDienteService().updateDiente(diente);
		            msgs = new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo",
		                    "Registro agregado exitosamente.");

		        } catch (DataAccessException e) {
		            e.printStackTrace();
		        }
		        
		    }



		public List<Diente> getDientesList() {
			dienteList = new ArrayList<Diente>();
			dienteList.addAll(getDienteService().getDientes());
			
			
			return dienteList;
			
		}


		public DienteService getDienteService() {
			return dienteService;
		}



		public void setDienteService(DienteService dienteService) {
			this.dienteService = dienteService;
		}



		public List<Diente> getDienteList() {
			return dienteList;
		}

		public void setDienteList(List<Diente> dienteList) {
			this.dienteList = dienteList;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Integer getDarriba1() {
			return darriba1;
		}

		public void setDarriba1(Integer darriba1) {
			this.darriba1 = darriba1;
		}

		public Integer getDabajo1() {
			return dabajo1;
		}

		public void setDabajo1(Integer dabajo1) {
			this.dabajo1 = dabajo1;
		}

		public Integer getDcentro1() {
			return dcentro1;
		}

		public void setDcentro1(Integer dcentro1) {
			this.dcentro1 = dcentro1;
		}

		public Integer getDizquierda1() {
			return dizquierda1;
		}

		public void setDizquierda1(Integer dizquierda1) {
			this.dizquierda1 = dizquierda1;
		}

		public Integer getDderecha1() {
			return dderecha1;
		}

		public void setDderecha1(Integer dderecha1) {
			this.dderecha1 = dderecha1;
		}



	}
