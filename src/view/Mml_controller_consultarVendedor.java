/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MmlVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Mml_controller_consultarVendedor extends AbstractTableModel {

    private List lstVendedor;

    public void setList(List lstVendedor) {
        this.lstVendedor = lstVendedor;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendedor.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlVendedor mmlVendedor = (MmlVendedor) lstVendedor.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlVendedor.getMmlIdVendedor();
        } else if (columnIndex ==1) {
            return mmlVendedor.getMmlNome();        
        } else if (columnIndex ==2) {
            return mmlVendedor.getMmlExpediente();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "expediente";
        }
        return "";
    }
}
