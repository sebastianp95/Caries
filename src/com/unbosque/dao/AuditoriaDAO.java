package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Auditoria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuditoriaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAuditoria(Auditoria auditoria) {
        getSessionFactory().getCurrentSession().save(auditoria);

    }

    public void deleteAuditoria(Auditoria auditoria) {
        getSessionFactory().getCurrentSession().delete(auditoria);
    }

    public void updateAuditoria(Auditoria auditoria) {
        getSessionFactory().getCurrentSession().update(auditoria);
    }

    public Auditoria getAuditoriaById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Auditoria where id=?").setParameter(0, id)
                .list();
        return (Auditoria) list.get(0);
    }

    public List<Auditoria> getAuditorias() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Auditoria").list();
        return list;
    }

}
