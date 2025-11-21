/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlDao;

import MmlBean.MmlVendas;
import MmlBean.MmlVendasCarros;
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
public class MmlVendasDao extends DaoAbstract {


    public MmlVendasDao() {
        
    }

    @Override
    public void insert(Object object) {
    MmlVendas vendas = (MmlVendas) object;
    try {
        PreparedStatement pst = cnt.prepareStatement("insert into mml_vendas values(?,?,?,?,?)");
        pst.setInt(1, vendas.getMml_jTxtIdVendas());
        pst.setString(2, vendas.getMml_jTxtIdClientes());
        pst.setDate(3, null);
        pst.setString(4, vendas.getMml_jTxtValor());
        pst.setString(5, vendas.getMml_jTxtFormasdePagamento());
        pst.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MmlVendasDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    @Override
    public void update(Object object) {
    MmlVendas vendas = (MmlVendas) object;
    try {
        PreparedStatement pst = cnt.prepareStatement("update mml_vendasDao set mml_idClintes=?, mml_data=?, mml_valor=?, mml_formasDePagamento=?,  where mml_idVendas=?");
        pst.setInt(1, vendas.getMml_jTxtIdVendas());
        pst.setString(2, vendas.getMml_jTxtIdClientes());
        pst.setString(3, vendas.getMml_jTxtValor());
        pst.setString(4, vendas.getMml_jTxtFormasdePagamento());
        pst.setDate(5, null);
        pst.executeUpdate();

    } catch (SQLException ex) {
        Logger.getLogger(MmlVendasDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    @Override
    public void delete(Object object) {
        MmlVendas vendas = (MmlVendas) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from mml_vendas where mml_idVendas =?");
            pst.setInt(1, vendas.getMml_jTxtIdVendas());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
    PreparedStatement pst;
    try {
        pst = cnt.prepareStatement("select * from mml_vendas where mml_idVendas = ?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            MmlVendas vendas = new MmlVendas();
            vendas.setMml_jTxtIdVendas(rs.getInt("mml_idVendas"));
            vendas.setMml_jTxtIdClientes(rs.getString("mml_idClientes"));
            vendas.setMml_jFmtData(rs.getDate("mml_data"));
            vendas.setMml_jTxtValor(rs.getString("mml_valor"));
            vendas.setMml_jTxtFormasdePagamento(rs.getString("mml_formasDePagamento"));
            
             return vendas;
        }
    } catch (SQLException ex) {
        Logger.getLogger(MmlVendas.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

    @Override
    public Object listAll() {
           List lista;
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from mml_vendas");

            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
               MmlVendas vendas = new MmlVendas();
            vendas.setMml_jTxtIdVendas(rs.getInt("mml_idVendas"));
            vendas.setMml_jTxtIdClientes(rs.getString("mml_idClientes"));
            vendas.setMml_jFmtData(rs.getDate(null));
            vendas.setMml_jTxtValor(rs.getString("mml_valor"));
            vendas.setMml_jTxtFormasdePagamento(rs.getString("mml_formasDePagamento"));
            
              
            }
        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public static void main(String[] args) {
        MmlVendas vendas = new MmlVendas();
        vendas.setMml_jTxtIdVendas(5);
        vendas.setMml_jTxtIdClientes("6"); 
         vendas.setMml_jFmtData(null); 
        vendas.setMml_jTxtValor("55.55"); 
        vendas.setMml_jTxtFormasdePagamento("aaa"); 
       

        MmlVendasDao vendasDao = new MmlVendasDao();
        vendasDao.insert(vendas);
        System.out.println("executou com sucesso.");
    }
}
