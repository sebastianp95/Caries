package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.ParametroDAO;
import com.unbosque.entidad.Parametro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ParametroService")
@Transactional(readOnly = true)
public class ParametroService {

    // CustomerDAO is injected...
    @Autowired
    ParametroDAO parametroDAO;

    @Transactional(readOnly = false)
    public void addParametro(Parametro parametro) {
        getParametroDAO().addParametro(parametro);
    }

    @Transactional(readOnly = false)
    public void deleteParametro(Parametro parametro) {
        getParametroDAO().deleteParametro(parametro);
    }

    @Transactional(readOnly = false)
    public void updateParametro(Parametro parametro) {
        getParametroDAO().updateParametro(parametro);
    }

    public Parametro getParametroById(int id) {
        return getParametroDAO().getParametroById(id);
    }

    public List<Parametro> getParametros() {
        return getParametroDAO().getParametros();
    }

    public ParametroDAO getParametroDAO() {
        return parametroDAO;
    }

    public void setParametroDAO(ParametroDAO parametroDAO) {
        this.parametroDAO = parametroDAO;
    }
}
