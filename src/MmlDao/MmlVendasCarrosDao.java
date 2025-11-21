package MmlDao;

import MmlBean.MmlUsuarios;
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

public class MmlVendasCarrosDao extends DaoAbstract {

    Connection cnt;

    public MmlVendasCarrosDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_miguel_leal";
            String user = "miguel_leal";
            String pass = "miguel_leal";
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MmlVendasCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object object) {
        MmlVendasCarros vendaCarro = (MmlVendasCarros) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO mml_vendas_carros (mml_idVendasCarros, mml_idVenda, mml_idCarros, mml_tipo, mml_valorUnitario) VALUES (?, ?, ?, ?, ?)"
            );
            pst.setInt(1, vendaCarro.getIdVendasCarros());
            pst.setString(2, vendaCarro.getIdVenda());
            pst.setString(3, vendaCarro.getIdCarros());
            pst.setString(4, vendaCarro.getTipo());
            pst.setString(5, vendaCarro.getValorUnitario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MmlVendasCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        MmlVendasCarros vendaCarro = (MmlVendasCarros) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "UPDATE mml_vendas_carros SET mml_idVenda=?, mml_idCarros=?, mml_tipo=?, mml_valorUnitario=? WHERE mml_idVendasCarros=?"
            );
             pst.setInt(1, vendaCarro.getIdVendasCarros());
            pst.setString(2, vendaCarro.getIdVenda());
            pst.setString(3, vendaCarro.getIdCarros());
            pst.setString(4, vendaCarro.getTipo());
            //pst.setString(, vendaCarro.getValorUnitario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MmlVendasCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MmlVendasCarros vendas = (MmlVendasCarros) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "DELETE FROM mml_vendas_carros WHERE mml_idVendasCarros = ?"
            );
            pst.setInt(1, vendas.getIdVendasCarros());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MmlVendasCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "SELECT * FROM mml_vendas_carros WHERE mml_idVendasCarros = ?"
            );
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                MmlVendasCarros vendaCarro = new MmlVendasCarros();
                vendaCarro.setIdVendasCarros(rs.getInt("mml_idVendasCarros"));
                vendaCarro.setIdVenda(rs.getString("mml_idVenda"));
                vendaCarro.setIdCarros(rs.getString("mml_idCarros"));
                vendaCarro.setTipo(rs.getString("mml_tipo"));
                vendaCarro.setValorUnitario(rs.getString("mml_valorUnitario"));
                return vendaCarro;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MmlVendasCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
         List lista;
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from mml_usuarios");

            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                MmlVendasCarros vendasCarros = new MmlVendasCarros();
                vendasCarros.setIdVendasCarros(rs.getInt("mml_idVendasCarros"));
                vendasCarros.setIdVenda(rs.getString("mml_idVenda"));
                vendasCarros.setIdCarros(rs.getString("mml_idCarros"));
                vendasCarros.setTipo(rs.getString("mml_tipo"));
                vendasCarros.setValorUnitario(rs.getString("mml_valorUnitario"));
              
            }
        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        MmlVendasCarros vendaCarro = new MmlVendasCarros();
        vendaCarro.setIdVendasCarros(1);
        vendaCarro.setIdVenda("V001");
        vendaCarro.setIdCarros("C002");
        vendaCarro.setTipo("Venda Direta");
        vendaCarro.setValorUnitario("15000.00");

        MmlVendasCarrosDao vendasCarrosDao = new MmlVendasCarrosDao();
        vendasCarrosDao.insert(vendaCarro);
        System.out.println("executou com sucesso.");
    }
}
