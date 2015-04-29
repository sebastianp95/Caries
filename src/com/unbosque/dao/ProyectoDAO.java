package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Proyecto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProyecto(Proyecto proyecto) {
        getSessionFactory().getCurrentSession().save(proyecto);

    }

    public void deleteProyecto(Proyecto proyecto) {
        getSessionFactory().getCurrentSession().delete(proyecto);
    }

    public void updateProyecto(Proyecto proyecto) {
        getSessionFactory().getCurrentSession().update(proyecto);
    }

    public Proyecto getProyectoById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Proyecto where id=?").setParameter(0, id)
                .list();
        return (Proyecto) list.get(0);
    }

    public List<Proyecto> getProyectos() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Proyecto").list();
        return list;
    }

}
