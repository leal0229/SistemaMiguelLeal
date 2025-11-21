/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlView;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import MmlBean. MmlVendas ;

/**
 *
 * @author u47443281803
 */
public class Mml_ControllerVendas extends AbstractTableModel{

    List lista;
    
    public void setList(List lista){
     this. lista = lista;   
    }
    
    public Object getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlVendas venda = (MmlVendas) lista.get(rowIndex);
        if (columnIndex == 0){
            return venda.getMml_jTxtIdVendas();
        }
        if (columnIndex == 1){
            return venda.getMml_jTxtIdClientes();
        }
        if (columnIndex == 2){
            return venda.getMml_jTxtValor();
        }
        if (columnIndex == 3){
            return venda.getMml_jFmtData();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Cliente";
        if (column == 2) return "Valor Total";
        if (column == 3) return "Data da Venda";
        return "";
    }
    
}
