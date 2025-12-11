/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MmlUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marlon
 */
public class MmlUsuariosDao extends DaoAbstract{

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
        Criteria criteria = session.createCriteria(MmlUsuarios.class);
        criteria.add(Restrictions.eq("idusuarios",codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public boolean login(String user, String pass) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlUsuarios.class);
        criteria.add(Restrictions.eq("mmlApelido", user));
        criteria.add(Restrictions.eq("mmlSenha", pass));

        List resultado = criteria.list();
        session.getTransaction().commit();

        return !resultado.isEmpty();
}
    
    
    public static void main(String[] args) {
        MmlUsuariosDao usuariosDAO = new MmlUsuariosDao();
        usuariosDAO.listAll();
        System.out.println("deu certo");
    }
    
}
