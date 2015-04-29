package com.unbosque.dao;

import java.util.List;
import com.unbosque.entidad.Departamento;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addDepartamento(Departamento departamento) {
        getSessionFactory().getCurrentSession().save(departamento);

    }

    public void deleteDepartamento(Departamento departamento) {
        getSessionFactory().getCurrentSession().delete(departamento);
    }

    public void updateDepartamento(Departamento departamento) {
        getSessionFactory().getCurrentSession().update(departamento);
    }

    public Departamento getDepartamentoById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Departamento where id=?").setParameter(0, id)
                .list();
        return (Departamento) list.get(0);
    }

    public List<Departamento> getDepartamentos() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Departamento").list();
        return list;
    }

}
