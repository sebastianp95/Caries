package com.unbosque.service;

import java.util.List;

import com.unbosque.dao.AuditoriaDAO;
import com.unbosque.entidad.Auditoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AuditoriaService")
@Transactional(readOnly = true)
public class AuditoriaService {

    // CustomerDAO is injected...
    @Autowired
    AuditoriaDAO auditoriaDAO;

    @Transactional(readOnly = false)
    public void addAuditoria(Auditoria auditoria) {
        getAuditoriaDAO().addAuditoria(auditoria);
    }

    @Transactional(readOnly = false)
    public void deleteAuditoria(Auditoria auditoria) {
        getAuditoriaDAO().deleteAuditoria(auditoria);
    }

    @Transactional(readOnly = false)
    public void updateAuditoria(Auditoria auditoria) {
        getAuditoriaDAO().updateAuditoria(auditoria);
    }

    public Auditoria getAuditoriaById(int id) {
        return getAuditoriaDAO().getAuditoriaById(id);
    }

    public List<Auditoria> getAuditorias() {
        return getAuditoriaDAO().getAuditorias();
    }

    public AuditoriaDAO getAuditoriaDAO() {
        return auditoriaDAO;
    }

    public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
        this.auditoriaDAO = auditoriaDAO;
    }
}
