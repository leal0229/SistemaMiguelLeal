/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MmlVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marlon
 */
public class MmlVendasDao extends DaoAbstract {

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
        Criteria criteria = session.createCriteria(MmlVendas.class);
        criteria.add(Restrictions.eq("", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listIdVendas(int idVendas) {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(MmlVendas.class);
       criteria.add(Restrictions.eq("mmlIdVendas", idVendas)); 
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
   }

   public Object listValor(double valor) {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(MmlVendas.class);
       criteria.add(Restrictions.eq("mmlValor", valor)); 
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
   }

   public Object listIdVendasValor(int idVendas, double valor) {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(MmlVendas.class);
       criteria.add(Restrictions.eq("mmlIdVendas", idVendas));
       criteria.add(Restrictions.eq("mmlValor", valor));
       List lista = criteria.list();
       session.getTransaction().commit();
       return lista;
   }
   

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        MmlVendasDao mmlVendasDao = new MmlVendasDao();
        mmlVendasDao.listAll();
    }
}