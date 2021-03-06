package model;

import java.sql.Date;

/**
 *Classe responsavel pelos atributos do modelo <b>Produto</b>
 * Pacote Model
 * @author Ítalo
 * @since Maio, 2016
 * @version 1.0
 */

public class ProdutoModel {

    private Integer codigoProduto;
    private String nomeProduto;
    private Integer codigoUnidade;
    private double precoProduto;
    private Date dataPreco;

    public static ProdutoModel CriarProdutoVazio() {
        return new ProdutoModel();
    }

    private ProdutoModel() {

    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(Integer codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Date getDataPreco() {
        return dataPreco;
    }

    public void setDataPreco(Date dataPreco) {
        this.dataPreco = dataPreco;
    }

    @Override
    public String toString() {
        return "ProdutoModel{" + "codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", codigoUnidade=" + codigoUnidade + ", precoProduto=" + precoProduto + ", dataPreco=" + dataPreco + '}';
    }
}
