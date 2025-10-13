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
import bean.MmlVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mml_Controller_Vendas   extends AbstractTableModel{
    
    private List lstVendas;

    public void setList(List lstcarros) {
        this.lstVendas = lstcarros;
    }

    public MmlVendas getBean(int rowIndex) {
        return (MmlVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlVendas mmlVendas = (MmlVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlVendas.getMmlIdVendas();
        } else if (columnIndex ==1) {
            return mmlVendas.getMmlCliente();
        } else if (columnIndex ==2) {
            return mmlVendas.getMmlVendedor();
        } else if (columnIndex ==3) {
            return mmlVendas.getMmlData();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "getMmlIdVendas";
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

