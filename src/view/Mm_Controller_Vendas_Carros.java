/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MmlVendasCarros;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class Mm_Controller_Vendas_Carros extends AbstractTableModel {

    private List lstMmlVendasCarros;

    public void setList(List lstMmlVendasCarros) {
        this.lstMmlVendasCarros = lstMmlVendasCarros;
        this.fireTableDataChanged();
    }
    
    public Object getBean(int rowIndex) {
        return (MmlVendasCarros) lstMmlVendasCarros.get(rowIndex);
        
    }
    
    public void addBean (MmlVendasCarros vendasCarros){
        this.lstMmlVendasCarros.add(vendasCarros);
        this.fireTableDataChanged();
    }
    
    public void removeBean (int rowIndex){
        this.lstMmlVendasCarros.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstMmlVendasCarros.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlVendasCarros vendasCarros = (MmlVendasCarros) lstMmlVendasCarros.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendasCarros.getMmlIdVendasCarros();
        } else if (columnIndex ==1) {
            return vendasCarros.getMmlCarros();        
        } else if (columnIndex ==2) {
            return vendasCarros.getMmlQuantidade();
        } else if (columnIndex ==3) {
            return vendasCarros.getMmlValorUnitario();
        } else if (columnIndex ==4) {
            return vendasCarros.getMmlQuantidade() * vendasCarros.getMmlValorUnitario();
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
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        }  else if ( columnIndex == 4) {
            return "Total";
        }
        return "";
    }
    
}
