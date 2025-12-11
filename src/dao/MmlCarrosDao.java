/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MmlCarros; 
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marlon
 */
public class MmlCarrosDao extends DaoAbstract{
    

    @Override
    public void insert(Object object) {
        session.beginTransaction(); 
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlCarros.class);
        criteria.add(Restrictions.eq("mml_idCarros", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listModelo(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlCarros.class);
        criteria.add(Restrictions.like("mmlModelo", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object listPreco(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlCarros.class);
        criteria.add(Restrictions.ge("mmlPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listModeloPreco(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlCarros.class);
        criteria.add(Restrictions.like("mmlModelo", "%" + nome + "%"));
        criteria.add(Restrictions.ge("mmlPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }


    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlCarros.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
}
