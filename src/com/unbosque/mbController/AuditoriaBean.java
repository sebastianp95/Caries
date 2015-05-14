package com.unbosque.mbController;

import java.io.Serializable;
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
import com.unbosque.entidad.Auditoria;
import com.unbosque.entidad.Usuario;
import com.unbosque.service.AuditoriaService;

@ManagedBean(name = "auditoriaMBController")
@SessionScoped
public class AuditoriaBean implements Serializable {

    private static final long serialVersionUID = -7809396168460749463L;

    // Spring Customer Service is injected...
    @ManagedProperty(value = "#{AuditoriaService}")
    AuditoriaService auditoriaService;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	List<Auditoria> auditoriaList;




    
    public List<Auditoria> getAuditoriasList() {
        auditoriaList = new ArrayList<Auditoria>();
        auditoriaList.addAll(getAuditoriaService().getAuditorias());
        return auditoriaList;
    }
    

    public AuditoriaService getAuditoriaService() {
        return auditoriaService;
    }

    public void setAuditoriaService(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }
   

	public List<Auditoria> getAuditoriaList() {
		return auditoriaList;
	}
	public void setAuditoriaList(List<Auditoria> auditoriaList) {
		this.auditoriaList = auditoriaList;
	}


}