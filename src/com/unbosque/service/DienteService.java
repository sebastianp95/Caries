package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.DienteDAO;
import com.unbosque.entidad.Diente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DienteService")
@Transactional(readOnly = true)
public class DienteService {

    // CustomerDAO is injected...
    @Autowired
    DienteDAO dienteDAO;

    @Transactional(readOnly = false)
    public void addDiente(Diente diente) {
        getDienteDAO().addDiente(diente);
    }

    @Transactional(readOnly = false)
    public void deleteDiente(Diente diente) {
        getDienteDAO().deleteDiente(diente);
    }

    @Transactional(readOnly = false)
    public void updateDiente(Diente diente) {
        getDienteDAO().updateDiente(diente);
    }

    public Diente getDienteById(int id) {
        return getDienteDAO().getDienteById(id);
    }

    public List<Diente> getDientes() {
        return getDienteDAO().getDientes();
    }

    public DienteDAO getDienteDAO() {
        return dienteDAO;
    }

    public void setDienteDAO(DienteDAO dienteDAO) {
        this.dienteDAO = dienteDAO;
    }
}
