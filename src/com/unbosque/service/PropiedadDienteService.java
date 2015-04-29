package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.PropiedadDienteDAO;
import com.unbosque.entidad.PropiedadDiente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PropiedadDienteService")
@Transactional(readOnly = true)
public class PropiedadDienteService {

    // CustomerDAO is injected...
    @Autowired
    PropiedadDienteDAO propiedadDienteDAO;

    @Transactional(readOnly = false)
    public void addPropiedadDiente(PropiedadDiente propiedadDiente) {
        getPropiedadDienteDAO().addPropiedadDiente(propiedadDiente);
    }

    @Transactional(readOnly = false)
    public void deletePropiedadDiente(PropiedadDiente propiedadDiente) {
        getPropiedadDienteDAO().deletePropiedadDiente(propiedadDiente);
    }

    @Transactional(readOnly = false)
    public void updatePropiedadDiente(PropiedadDiente propiedadDiente) {
        getPropiedadDienteDAO().updatePropiedadDiente(propiedadDiente);
    }

    public PropiedadDiente getPropiedadDienteById(int id) {
        return getPropiedadDienteDAO().getPropiedadDienteById(id);
    }

    public List<PropiedadDiente> getPropiedadDientes() {
        return getPropiedadDienteDAO().getPropiedadDientes();
    }

    public PropiedadDienteDAO getPropiedadDienteDAO() {
        return propiedadDienteDAO;
    }

    public void setPropiedadDienteDAO(PropiedadDienteDAO propiedadDienteDAO) {
        this.propiedadDienteDAO = propiedadDienteDAO;
    }
}
