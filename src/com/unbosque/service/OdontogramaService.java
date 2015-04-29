package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.OdontogramaDAO;
import com.unbosque.entidad.Odontograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("OdontogramaService")
@Transactional(readOnly = true)
public class OdontogramaService {

    // CustomerDAO is injected...
    @Autowired
    OdontogramaDAO odontogramaDAO;

    @Transactional(readOnly = false)
    public void addOdontograma(Odontograma odontograma) {
        getOdontogramaDAO().addOdontograma(odontograma);
    }

    @Transactional(readOnly = false)
    public void deleteOdontograma(Odontograma odontograma) {
        getOdontogramaDAO().deleteOdontograma(odontograma);
    }

    @Transactional(readOnly = false)
    public void updateOdontograma(Odontograma odontograma) {
        getOdontogramaDAO().updateOdontograma(odontograma);
    }

    public Odontograma getOdontogramaById(int id) {
        return getOdontogramaDAO().getOdontogramaById(id);
    }

    public List<Odontograma> getOdontogramas() {
        return getOdontogramaDAO().getOdontogramas();
    }

    public OdontogramaDAO getOdontogramaDAO() {
        return odontogramaDAO;
    }

    public void setOdontogramaDAO(OdontogramaDAO odontogramaDAO) {
        this.odontogramaDAO = odontogramaDAO;
    }
}
