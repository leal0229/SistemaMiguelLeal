/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlDao;

import MmlBean.MmlCarros;
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
public class MmlCarrosDao extends DaoAbstract {


    public MmlCarrosDao() {
        
    }

    @Override
    public void insert(Object object) {
        MmlCarros carros = (MmlCarros) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("insert into mml_carros values(?,?,?,?,?,?,?)");
            pst.setInt(1, carros.getIdCarros());
            pst.setString(2, carros.getModelo());
            pst.setString(3, carros.getMarca());
            pst.setString(4, carros.getCor());
            pst.setDate(5, null); 
            pst.setString(6, carros.getPreco());
            pst.setString(7, carros.getPrecoVenda());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public void update(Object object) {
        MmlCarros carros = (MmlCarros) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update mml_carros set mml_modelo=?, mml_marca=?, mml_cor=?, mml_ano=?, mml_preco=?, mml_precoVenda=? where mml_idCarros=?");
            pst.setInt(1, carros.getIdCarros());
            pst.setString(2, carros.getModelo());
            pst.setString(3, carros.getMarca());
            pst.setString(4, carros.getCor());
            pst.setDate(4, null); 
            pst.setString(5, carros.getPreco());
            pst.setString(6, carros.getPrecoVenda());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MmlCarros carros = (MmlCarros) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from mml_carros where mml_idCarros =?");
            pst.setInt(1, carros.getIdCarros());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
    PreparedStatement pst;
    try {
        pst = cnt.prepareStatement("select * from mml_carros where mml_idcarros =?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next() == true) {
          MmlCarros carros = new MmlCarros();
    carros.setIdCarros(rs.getInt("mml_idcarros"));
    carros.setModelo(rs.getString("mml_modelo"));
    carros.setMarca(rs.getString("mml_marca"));
    carros.setCor(rs.getString("mml_cor"));
    carros.setAno(rs.getString("mml_ano"));
    carros.setPreco(rs.getString("mml_preco"));
    carros.setPrecoVenda(rs.getString("mml_precovenda"));

            return carros;
        } 
    } catch (SQLException ex) {
        Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

    @Override
    public Object listAll() {
        List lista;
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from mml_carros");
            
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                MmlCarros carros = new MmlCarros();
                carros.setIdCarros( rs.getInt("mml_idcarros") );
                carros.setModelo(rs.getString("mml_modelo") );
                carros.setMarca(rs.getString("mml_marca") );
                carros.setCor(rs.getString("mml_cor") );
                carros.setAno(rs.getString("mml_ano") );
                carros.setPreco(rs.getString("mml_preco") );
                carros.setPrecoVenda(rs.getString("mml_precovenda") );
                lista.add(carros);
            } 
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        MmlCarros carros = new MmlCarros();
        carros.setIdCarros(33);
        carros.setModelo("");
        carros.setMarca("");
        carros.setCor("");
        carros.setAno(null);
        carros.setPreco("99.7");
        carros.setPrecoVenda("79.9");
        MmlCarrosDao carrosDao = new MmlCarrosDao();
        carrosDao.insert(carros);
        System.out.println("executou com sucesso.");
    }


}
