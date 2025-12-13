package dao;

import bean.MmlVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class MmlVendedorDao extends DaoAbstract {

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
        Criteria criteria = session.createCriteria(MmlVendedor.class);
        criteria.add(Restrictions.eq("mmlCodigo", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlVendedor.class);
        criteria.add(Restrictions.like("mmlNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listExpediente(String valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlVendedor.class);
        criteria.add(Restrictions.ge("mmlExpediente", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNomeExpediente(String nome, String valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlVendedor.class);
        criteria.add(Restrictions.like("mmlNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("mmlExpediente", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MmlVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        MmlVendedorDao mmlVendedorDao = new MmlVendedorDao();
        mmlVendedorDao.listAll();
    }
}
