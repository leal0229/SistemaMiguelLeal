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

public class Mml_Controller_Carros   extends AbstractTableModel{
    
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
            return mmlCarros.getMmlIdCarros();
        } else if (columnIndex ==1) {
            return mmlCarros.getMmlModelo();
        } else if (columnIndex ==2) {
            return mmlCarros.getMmlPreco();
        } else if (columnIndex ==3) {
            return mmlCarros.getMmlAno();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "getMmlIdCarros";
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

