package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Ciudad;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CiudadDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCiudad(Ciudad ciudad) {
        getSessionFactory().getCurrentSession().save(ciudad);

    }

    public void deleteCiudad(Ciudad ciudad) {
        getSessionFactory().getCurrentSession().delete(ciudad);
    }

    public void updateCiudad(Ciudad ciudad) {
        getSessionFactory().getCurrentSession().update(ciudad);
    }

    public Ciudad getCiudadById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Ciudad where id=?").setParameter(0, id)
                .list();
        return (Ciudad) list.get(0);
    }

    public List<Ciudad> getCiudads() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Ciudad").list();
        return list;
    }

}
