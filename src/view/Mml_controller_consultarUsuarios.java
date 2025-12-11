/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MmlUsuarios;
import bean.MmlVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Mml_controller_consultarUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstusuarios) {
        this.lstUsuarios = lstusuarios;
    }

    public MmlUsuarios getBean(int rowIndex) {
        return (MmlUsuarios) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();

    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlUsuarios mmlUsuarios = (MmlUsuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlUsuarios.getMmlIdUsusario();
        } else if (columnIndex ==1) {
            return mmlUsuarios.getMmlNome();
        } else if (columnIndex ==2) {
            return mmlUsuarios.getMmlCpf();
        
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código do Usuarios";
        } else if ( columnIndex == 1) {
            return "Nome";
        } else if ( columnIndex == 2) {
            return "Cpf";
        } else if ( columnIndex == 3) {
        }
        return "";
    }
}

