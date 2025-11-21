/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlDao;

import MmlBean.MmlCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
public class MmlClienteDao extends DaoAbstract {


    public MmlClienteDao() {
        
    }

    @Override
    public void insert(Object object) {
        MmlCliente cliente = (MmlCliente) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into cliente values("+cliente.getIdcliente()+", '"+cliente.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into mml_cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, cliente.getIdCliente());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getRg());
            pst.setString(4, cliente.getSexo());
            pst.setString(5, cliente.getAtivo());
            pst.setString(6, cliente.getCpf());
            pst.setDate(7, (Date) cliente.getDataCadastro());
            pst.setString(8, cliente.getTelefone());
            pst.setString(9, cliente.getCelular());
            pst.setDate(10,(Date) cliente.getDatanascimento());
            pst.setString(11, cliente.getEnderoco());
            pst.setString(12, cliente.getEmail());
            pst.setString(13, cliente.getCidade());
            pst.setString(14, cliente.getCep());
            pst.setString(15, cliente.getBairro());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        MmlCliente cliente = (MmlCliente) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                    "INSERT INTO mml_cliente ("
                    + "mml_idCliente, mml_nome, mml_rg, mml_sexo, mml_ativo, "
                    + "mml_cpf, mml_dataCadastro, mml_telefone, mml_celular, mml_datanascimento, "
                    + "mml_enderoco, mml_email, mml_cidade, mml_cep, mml_bairro"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            pst.setInt(0, cliente.getIdCliente());
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getRg());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getAtivo());
            pst.setString(5, cliente.getCpf());
            pst.setDate(6, null);
            pst.setString(7, cliente.getTelefone());
            pst.setString(8, cliente.getCelular());
            pst.setDate(9, null);
            pst.setString(10, cliente.getEnderoco());
            pst.setString(11, cliente.getEmail());
            pst.setString(12, cliente.getCidade());
            pst.setString(13, cliente.getCep());
            pst.setString(14, cliente.getBairro());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlUsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MmlCliente cliente = (MmlCliente) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from mml_cliente where mml_idCliente =?");
            pst.setInt(1, cliente.getIdCliente());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MmlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from mml_cliente where mml_idcliente = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                MmlCliente cliente = new MmlCliente();
                cliente.setIdCliente(rs.getInt("mml_idcliente"));
                cliente.setNome(rs.getString("mml_nome"));
                cliente.setRg(rs.getString("mml_rg"));
                cliente.setSexo(rs.getString("mml_sexo"));
                cliente.setAtivo(rs.getString("mml_ativo"));
                cliente.setCpf(rs.getString("mml_cpf"));
                cliente.dataCadastro(rs.getDate("mml_dataCadastro"));
                cliente.setTelefone(rs.getString("mml_telefone"));
                cliente.setCelular(rs.getString("mml_celular"));
                cliente.setDatanascimento(rs.getDate("mml_datanascimento"));
                cliente.setEnderoco(rs.getString("mml_enderoco"));
                cliente.setEmail(rs.getString("mml_email"));
                cliente.setCidade(rs.getString("mml_cidade"));
                cliente.setCep(rs.getString("mml_cep"));
                cliente.setBairro(rs.getString("mml_bairro"));
                

                return cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MmlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        List lista;
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from mml_cliente");
            
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                MmlCliente clientes = new MmlCliente();
                clientes.setIdCliente( rs.getInt("mml_idcliente") );
                clientes.setNome(rs.getString("mml_nome") );
                clientes.setRg(rs.getString("mml_rg") );
                clientes.setSexo(rs.getString("mml_sexo") );
                clientes.setCpf(rs.getString("mml_cpf") );
                clientes.setDataCadastro(rs.getDate("mml_dataCadastro") );
                clientes.setDatanascimento(rs.getDate("mml_datanascimento") );
                clientes.setTelefone(rs.getString("mml_telefone") );
                clientes.setCelular(rs.getString("mml_celular") );
                clientes.setEmail(rs.getString("mml_email") );
                clientes.setCidade(rs.getString("mml_cidade") );
                clientes.setCep(rs.getString("mml_cep") );
                clientes.setBairro(rs.getString("mml_bairro") );
                clientes.setAtivo(rs.getString("mml_ativo") );
                lista.add(clientes);
            } 
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        MmlCliente cliente = new MmlCliente();
        
        cliente.setIdCliente(6);
        cliente.setNome("marcos");
        cliente.setRg("1234567");
        cliente.setCpf("11884167403");
        cliente.setDatanascimento(null);
        cliente.setSexo("M");
        cliente.setTelefone("81");
        cliente.setCelular("88888");
        cliente.setEnderoco("Rua");
        cliente.setEmail("miguellealsurubim8@gmail");
        cliente.setCidade("po");
        cliente.setCep("po");
        cliente.setBairro("Centro");
        cliente.setAtivo("S");
        cliente.setDataCadastro(null);

        MmlClienteDao clienteDao = new MmlClienteDao();
        clienteDao.insert(cliente);
        System.out.println("executou com sucesso.");

    }

}
