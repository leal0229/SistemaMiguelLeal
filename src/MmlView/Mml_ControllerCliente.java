/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlView;

import MmlBean.MmlCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marlom
 */
public class Mml_ControllerCliente extends AbstractTableModel{

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
        MmlCliente carros = (MmlCliente) lista.get(rowIndex);
        if (columnIndex == 0){
            return carros.getIdCliente();
        }
        if (columnIndex == 1){
            return carros.getNome();
        }
        if (columnIndex == 2){
            return carros.getRg();
        }
        if (columnIndex == 3){
            return carros.getSexo();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Rg";
        if (column == 3) return "Data da última compra";
        return "";
    }
    
}
