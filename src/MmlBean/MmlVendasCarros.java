/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MmlBean;

/**
 *
 * @author clari
 */
public class MmlVendasCarros {
    private int idVendasCarros;
    private String idVenda;
    private String idCarros;
    private int quantidade;
    private double valorUnitario;

    public int getIdVendasCarros() {
        return idVendasCarros;
    }

    public void setIdVendasCarros(int idVendasCarros) {
        this.idVendasCarros = idVendasCarros;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public String getIdCarros() {
        return idCarros;
    }

    public void setIdCarros(String idCarros) {
        this.idCarros = idCarros;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int tipo) {
        this.quantidade = tipo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
}
