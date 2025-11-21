/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlDao;

import MmlBean.MmlVendasCarros;
import MmlBean.MmlVendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class MmlVendedorDao extends DaoAbstract {


    public MmlVendedorDao() {
        
    }

    @Override
    public void insert(Object object) {
    MmlVendedor vendedor = (MmlVendedor) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("insert into mml_vendedor values(?,?,?,?,?,?,?)");
            pst.setInt(1, vendedor.getIdVendedor());
            pst.setString(2, vendedor.getNome());
            pst.setString(3, vendedor.getCredencial());
            pst.setString(4, vendedor.getExpediente());
            
            pst.setString(5, vendedor.getAtivo());
            pst.setString(6, vendedor.getCpf());
            pst.setDate(7, null); // vendedor.getDatanascimento()
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MmlVendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    
    public void update(Object object) {
    MmlVendedor vendedor = (MmlVendedor) object;
    try {
        PreparedStatement pst = cnt.prepareStatement("update mml_vendedor set mml_nome=?, mml_credencial=?, mml_expediente=?, mml_datanascimento=?, mml_ativo=?, mml_cpf=? where mml_idvendedor=?");
        pst.setInt(1, vendedor.getIdVendedor());
        pst.setString(1, vendedor.getNome());
        pst.setString(2, vendedor.getCredencial());
        pst.setString(3, vendedor.getExpediente());
        pst.setString(5, vendedor.getAtivo());
        pst.setString(6, vendedor.getCpf());
        pst.setDate(7, null); // vendedor.getDatanascimento()
        pst.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MmlVendedorDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void delete(Object object) {
        MmlVendedor vendedor = (MmlVendedor) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from mml_vendedor where mml_idVendedor =?");
            pst.setInt(1, vendedor.getIdVendedor());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlVendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from mml_vendedor where mml_idVendedor = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                MmlVendedor vendedor = new MmlVendedor();
                vendedor.setIdVendedor(rs.getInt("mml_idvendedor"));
                vendedor.setNome(rs.getString("mml_nome"));
                vendedor.setCredencial(rs.getString("mml_credencial"));
                vendedor.setExpediente(rs.getString("mml_expediente"));
                
                vendedor.setAtivo(rs.getString("mml_ativo"));
                vendedor.setCpf(rs.getString("mml_cpf"));
                vendedor.setDatanascimento(rs.getDate("mml_data_nascimente"));
                return vendedor;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MmlVendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}


    @Override
    public Object listAll() {
           List lista;
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from mml_vendedor");

            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                MmlVendedor vendedor = new MmlVendedor();
                vendedor.setIdVendedor(rs.getInt("mml_idvendedor"));
                vendedor.setNome(rs.getString("mml_nome"));
                vendedor.setCredencial(rs.getString("mml_credencial"));
                vendedor.setExpediente(rs.getString("mml_expediente"));
                vendedor.setAtivo(rs.getString("mml_ativo"));
                vendedor.setCpf(rs.getString("mml_cpf"));
                vendedor.setDatanascimento(rs.getDate("mml_data_nascimente"));
                 lista.add(vendedor);
              
              
            }
        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public static void main(String[] args) {
        MmlVendedor vendedor = new MmlVendedor();
        vendedor.setIdVendedor(2);
        vendedor.setNome("aa");
        vendedor.setCredencial("1111111111");
        vendedor.setExpediente("a");
        vendedor.setAtivo("a");
        vendedor.setCpf("aaaa");
        vendedor.setDatanascimento(null);
        MmlVendedorDao vendedorDao = new MmlVendedorDao();
        vendedorDao.insert(vendedor);
        System.out.println("executou com sucesso.");
}


}
