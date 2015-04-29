package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Diente;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DienteDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addDiente(Diente diente) {
        getSessionFactory().getCurrentSession().save(diente);

    }

    public void deleteDiente(Diente diente) {
        getSessionFactory().getCurrentSession().delete(diente);
    }

    public void updateDiente(Diente diente) {
        getSessionFactory().getCurrentSession().update(diente);
    }

    public Diente getDienteById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Diente where id=?").setParameter(0, id)
                .list();
        return (Diente) list.get(0);
    }

    public List<Diente> getDientes() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Diente").list();
        return list;
    }

}
