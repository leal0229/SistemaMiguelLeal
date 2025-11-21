/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public abstract class DaoAbstract {
        protected Connection cnt;


    public DaoAbstract() {
    try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://127.0.0.1:3306/db_miguel_leal";
            user = "root";
            pass = "";
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MmlCarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int id    );
    public abstract Object listAll();
    

}
