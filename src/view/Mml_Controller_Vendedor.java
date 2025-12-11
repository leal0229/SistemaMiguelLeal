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
import bean.MmlVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mml_Controller_Vendedor   extends AbstractTableModel{
    
    private List lstVendedor;

    public void setList(List lstcarros) {
        this.lstVendedor = lstcarros;
    }

    public MmlVendedor getBean(int rowIndex) {
        return (MmlVendedor) lstVendedor.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendedor.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlVendedor mmlVendedor = (MmlVendedor) lstVendedor.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlVendedor.getMmlIdVendedor();
        } else if (columnIndex ==1) {
            return mmlVendedor.getMmlNome();
        } else if (columnIndex ==2) {
            return mmlVendedor.getMmlCredencial();
        } else if (columnIndex ==3) {
            return mmlVendedor.getMmlExpediente();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "getMmlIdVendedor";
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

