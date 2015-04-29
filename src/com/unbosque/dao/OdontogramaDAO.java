package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Odontograma;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OdontogramaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addOdontograma(Odontograma odontograma) {
        getSessionFactory().getCurrentSession().save(odontograma);

    }

    public void deleteOdontograma(Odontograma odontograma) {
        getSessionFactory().getCurrentSession().delete(odontograma);
    }

    public void updateOdontograma(Odontograma odontograma) {
        getSessionFactory().getCurrentSession().update(odontograma);
    }

    public Odontograma getOdontogramaById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Odontograma where id=?").setParameter(0, id)
                .list();
        return (Odontograma) list.get(0);
    }

    public List<Odontograma> getOdontogramas() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Odontograma").list();
        return list;
    }

}
