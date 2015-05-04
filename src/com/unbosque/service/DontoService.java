package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.DontoDAO;
import com.unbosque.entidad.Donto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DontoService")
@Transactional(readOnly = true)
public class DontoService {

    // CustomerDAO is injected...
    @Autowired
    DontoDAO dontoDAO;

    @Transactional(readOnly = false)
    public void addDonto(Donto donto) {
        getDontoDAO().addDonto(donto);
    }

    @Transactional(readOnly = false)
    public void deleteDonto(Donto donto) {
        getDontoDAO().deleteDonto(donto);
    }

    @Transactional(readOnly = false)
    public void updateDonto(Donto donto) {
        getDontoDAO().updateDonto(donto);
    }

    public Donto getDontoById(int id) {
        return getDontoDAO().getDontoById(id);
    }

    public List<Donto> getDontos() {
        return getDontoDAO().getDontos();
    }

    public DontoDAO getDontoDAO() {
        return dontoDAO;
    }

    public void setDontoDAO(DontoDAO dontoDAO) {
        this.dontoDAO = dontoDAO;
    }
}
