package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marlom
 */
import bean.MmlUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mml_Controller_Usuarios   extends AbstractTableModel{
    
    private List lstUsuarios;

    public void setList(List lstcarros) {
        this.lstUsuarios = lstcarros;
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlUsuarios mmlUsuarios = (MmlUsuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlUsuarios.getMmlIdUsusario();
        } else if (columnIndex ==1) {
            return mmlUsuarios.getMmlNome();
        } else if (columnIndex ==2) {
            return mmlUsuarios.getMmlApelido();
        } else if (columnIndex ==3) {
            return mmlUsuarios.getMmlCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "getMmlIdUsuarios";
        } else if ( columnIndex == 1) {
            return "getMmlModelo";
        } else if ( columnIndex == 2) {
            return "getMmlPreco";
        } else if ( columnIndex == 3) {
            return "getMmlAno";
        } 
        return "";
    }
}

