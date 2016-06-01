package model;

import java.sql.Date;

/**
 *
 * @author Ítalo
 */
public class VendaModel {

    private Integer codigoVenda;
    private Integer codigoVendedor;
    private Integer codigoCliente;
    private Date dataVenda;

    public static VendaModel CriaVenda() {
        return new VendaModel();
    }

    private VendaModel() {
    }

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Integer codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "VendaModel{" + "codigoVenda=" + codigoVenda + ", codigoVendedor=" + codigoVendedor + ", codigoCliente=" + codigoCliente + ", dataVenda=" + dataVenda + '}';
    }

}
