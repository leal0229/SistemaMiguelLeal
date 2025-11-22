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
import bean.MmlCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Mml_Controller_Cliente   extends AbstractTableModel{
    
    private List lstCliente;

    public void setList(List lstCliente) {
        this.lstCliente = lstCliente;
    }

    public MmlCliente getBean(int rowIndex) {
        return (MmlCliente) lstCliente.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstCliente.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MmlCliente mmlCliente = (MmlCliente) lstCliente.get( rowIndex);
        if ( columnIndex == 0 ){
            return mmlCliente.getMmlIdCliente();
        } else if (columnIndex ==1) {
            return mmlCliente.getMmlNome();
        } else if (columnIndex ==2) {
            return mmlCliente.getMmlRg();
        } else if (columnIndex ==3) {
            return mmlCliente.getMmlCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "nome";
        } else if ( columnIndex == 2) {
            return "rg";
        } else if ( columnIndex == 3) {
            return "cpf";
        } 
        return "";
    }
   
}

