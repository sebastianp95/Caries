package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.PropiedadDiente;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PropiedadDienteDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPropiedadDiente(PropiedadDiente propiedadDiente) {
        getSessionFactory().getCurrentSession().save(propiedadDiente);

    }

    public void deletePropiedadDiente(PropiedadDiente propiedadDiente) {
        getSessionFactory().getCurrentSession().delete(propiedadDiente);
    }

    public void updatePropiedadDiente(PropiedadDiente propiedadDiente) {
        getSessionFactory().getCurrentSession().update(propiedadDiente);
    }

    public PropiedadDiente getPropiedadDienteById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from PropiedadDiente where id=?").setParameter(0, id)
                .list();
        return (PropiedadDiente) list.get(0);
    }

    public List<PropiedadDiente> getPropiedadDientes() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from PropiedadDiente").list();
        return list;
    }

}
