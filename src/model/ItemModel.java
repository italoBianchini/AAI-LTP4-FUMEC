package model;

/**
 *
 * @author Ítalo
 */
public class ItemModel {
    
    private Integer codigoItem;
    private Integer codigoVenda;
    private Integer codigoProduto;
    private Integer quantidade;
    private double valor;

    public static ItemModel CriaItem() {
        return new ItemModel();
    }
    
    private ItemModel() {
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ItemModel{" + "codigoItem=" + codigoItem + ", codigoVenda=" + codigoVenda + ", codigoProduto=" + codigoProduto + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }
}
