package model;

import java.sql.Date;

/**
 * A classe <b>Vendedor</b> é responsável pelos atributos do modelo vendedores.
 * Pacote Model
 *
 * @author Ítalo
 * @since Maio, 2016
 * @version 1.0
 */
public class VendedorModel {

    private Integer codigoVendedor;
    private String NomeVendedor;
    private Date dataCadVendedor;

    public static VendedorModel CriaVendedorVazio() {
        return new VendedorModel();
    }

    private VendedorModel() {

    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Integer codVendedor) {
        this.codigoVendedor = codVendedor;
    }

    public String getNomeVendedor() {
        return NomeVendedor;
    }

    public void setNomeVendedor(String vendedor) {
        this.NomeVendedor = vendedor;
    }

    public Date getDataCadVendedor() {
        return dataCadVendedor;
    }

    public void setDataCadVendedor(Date dataCadVendedor) {
        this.dataCadVendedor = dataCadVendedor;
    }

    @Override
    public String toString() {
        return "VendedorModel{" + "codVendedor=" + codigoVendedor + ", NomeVendedor=" + NomeVendedor + ", dataCadVendedor=" + dataCadVendedor + '}';
    }

    
}
