/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlDao;

import MmlBean.MmlUsuarios;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class MmlUsuariosDao extends DaoAbstract {


    public MmlUsuariosDao() {
        
    }

    @Override
    public void insert(Object object) {
        MmlUsuarios usuarios = (MmlUsuarios) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into mml_usuarios values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.setString(2, usuarios.getNome());
            pst.setString(3, usuarios.getApelido());
            pst.setString(4, usuarios.getCpf());
            pst.setString(5, usuarios.getSenha());//senha
            pst.setInt(6, usuarios.getNivel());
            pst.setDate(7, (java.sql.Date) usuarios.getDataNascimento());//usuarios.getDataNascimento()    
            pst.setString(8, usuarios.getAtivo());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlUsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        MmlUsuarios usuarios = (MmlUsuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update mml_usuarios set mml_nome=?, mml_apelido=?, mml_cpf=?, mml_senha=?, mml_nivel=?,mml_dataNas, mml_ativo, where mml_idUsusario=?");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.setString(2, usuarios.getNome());
            pst.setString(3, usuarios.getApelido());
            pst.setString(4, usuarios.getCpf());
            pst.setString(5, usuarios.getSenha());//senha
            pst.setInt(6, usuarios.getNivel());
            pst.setDate(7, (java.sql.Date) usuarios.getDataNascimento() );//usuarios.getDataNascimento()    
            pst.setString(8, usuarios.getAtivo());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlUsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MmlUsuarios usuarios = (MmlUsuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from mml_usuarios where mml_idUsusario =?");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlUsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from mml_usuarios where mml_idUsusario =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                MmlUsuarios usuarios = new MmlUsuarios();
                usuarios.setIdusuarios(rs.getInt("mml_idUsusario"));
                usuarios.setNome(rs.getString("mml_nome"));
                usuarios.setApelido(rs.getString("mml_apelido"));
                usuarios.setCpf(rs.getString("mml_cpf"));
                usuarios.setSenha(rs.getString("mml_senha"));
                usuarios.setNivel(rs.getInt("mml_nivel"));
                usuarios.setDataNascimento(rs.getDate("mml_dataNas"));
                usuarios.setAtivo(rs.getString("mml_ativo"));

                return usuarios;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MmlUsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
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
                MmlUsuarios usuarios = new MmlUsuarios();
                usuarios.setIdusuarios(rs.getInt("mml_idUsusario"));
                usuarios.setNome(rs.getString("mml_nome"));
                usuarios.setApelido(rs.getString("mml_apelido"));
                usuarios.setCpf(rs.getString("mml_cpf"));
                usuarios.setDataNascimento(rs.getDate("mml_dataNas"));
                usuarios.setSenha(rs.getString("mml_senha"));
                usuarios.setNivel(rs.getInt("mml_nivel"));
                usuarios.setAtivo(rs.getString("mml_ativo"));
                lista.add(usuarios);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        MmlUsuarios usuarios = new MmlUsuarios();
        usuarios.setIdusuarios(3);
        usuarios.setNome("marcos");
        usuarios.setApelido("mpv");
        usuarios.setCpf("456.546.879-87");
        usuarios.setDataNascimento(null);
        usuarios.setSenha("123");
        usuarios.setNivel(1);
        usuarios.setAtivo("S");
        MmlUsuariosDao usuariosDao = new MmlUsuariosDao();
        usuariosDao.insert(usuarios);
        System.out.println("executou com sucesso.");
    }

}
