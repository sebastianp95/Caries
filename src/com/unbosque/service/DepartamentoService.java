package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.DepartamentoDAO;
import com.unbosque.entidad.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DepartamentoService")
@Transactional(readOnly = true)
public class DepartamentoService {

    // CustomerDAO is injected...
    @Autowired
    DepartamentoDAO departamentoDAO;

    @Transactional(readOnly = false)
    public void addDepartamento(Departamento departamento) {
        getDepartamentoDAO().addDepartamento(departamento);
    }

    @Transactional(readOnly = false)
    public void deleteDepartamento(Departamento departamento) {
        getDepartamentoDAO().deleteDepartamento(departamento);
    }

    @Transactional(readOnly = false)
    public void updateDepartamento(Departamento departamento) {
        getDepartamentoDAO().updateDepartamento(departamento);
    }

    public Departamento getDepartamentoById(int id) {
        return getDepartamentoDAO().getDepartamentoById(id);
    }

    public List<Departamento> getDepartamentos() {
        return getDepartamentoDAO().getDepartamentos();
    }

    public DepartamentoDAO getDepartamentoDAO() {
        return departamentoDAO;
    }

    public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }
}
