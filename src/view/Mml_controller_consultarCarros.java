/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MmlCarros;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Mml_controller_consultarCarros extends AbstractTableModel {

    private List lstCarros;

    public void setList(List lstCarros) {
        this.lstCarros = lstCarros;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstCarros.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlCarros produtos = (MmlCarros) lstCarros.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getMmlIdCarros();
        } else if (columnIndex ==1) {
            return produtos.getMmlModelo();        
        } else if (columnIndex ==2) {
            return produtos.getMmlPreco();
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
            return "preço";
        }
        return "";
    }
}
