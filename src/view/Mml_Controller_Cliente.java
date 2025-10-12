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
import bean.MmlCarros;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mml_Controller_Cliente   extends AbstractTableModel{
    
    private List lstCarros;

    public void setList(List lstcarros) {
        this.lstCarros = lstcarros;
    }

    public MmlCarros getBean(int rowIndex) {
        return (MmlCarros) lstCarros.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstCarros.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlCarros mmlCarros = (MmlCarros) lstCarros.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlCarros.getDjIdUsuarios();
        } else if (columnIndex ==1) {
            return mmlCarros.getDjNome();
        } else if (columnIndex ==2) {
            return mmlCarros.getDjApelido();
        } else if (columnIndex ==3) {
            return mmlCarros.getDjCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "";
        } else if ( columnIndex == 1) {
            return "";
        } else if ( columnIndex == 2) {
            return "";
        } else if ( columnIndex == 3) {
            return "";
        } 
        return "";
    }
}

