package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Donto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DontoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addDonto(Donto donto) {
        getSessionFactory().getCurrentSession().save(donto);

    }

    public void deleteDonto(Donto donto) {
        getSessionFactory().getCurrentSession().delete(donto);
    }

    public void updateDonto(Donto donto) {
        getSessionFactory().getCurrentSession().update(donto);
    }

    public Donto getDontoById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Donto where id=?").setParameter(0, id)
                .list();
        return (Donto) list.get(0);
    }

    public List<Donto> getDontos() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Donto").list();
        return list;
    }

}
