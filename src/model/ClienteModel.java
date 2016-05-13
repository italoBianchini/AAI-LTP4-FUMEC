package model;

import java.sql.Date;
import java.util.Objects;

/**
 * A classe <b>ClienteModel</b> é responsável pelos atributos e formatações do
 * objeto <b>Cliente.</b>
 * Pacote: Model
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class ClienteModel {

    public static ClienteModel CriarClienteVazio() {
        return new ClienteModel();
    }

    public static ClienteModel CriarClienteIncompleto(Integer codigoCliente, String nome, String endereco, String bairro, String cidade, String uf, String cep, Date dataDeCadastro) {
        return new ClienteModel(codigoCliente, nome, endereco, bairro, cidade, uf, cep, dataDeCadastro);
    }

    public static ClienteModel CriarClienteCompleto(Integer codigoCliente, String nome, String endereco, String bairro, String cidade, String uf, String cep, String telefone, String email, Date dataDeCadastro) {
        return new ClienteModel(codigoCliente, nome, endereco, bairro, cidade, uf, cep, telefone, email, dataDeCadastro);
    }

    private Integer codigoCliente;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefone;
    private String email;
    private Date dataDeCadastro;

    private ClienteModel() {

    }


    private ClienteModel(Integer codigoCliente, String nome, String endereco, String bairro, String cidade, String uf, String cep, Date dataDeCadastro) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = null;
        this.email = null;
        this.dataDeCadastro = dataDeCadastro;
    }


    private ClienteModel(Integer codigoCliente, String nome, String endereco, String bairro, String cidade, String uf, String cep, String telefone, String email, Date dataDeCadastro) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public String toString() {
        return "ClienteModel{" + "codigoCliente=" + codigoCliente + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone=" + telefone + ", email=" + email + ", dataDeCadastro=" + dataDeCadastro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteModel other = (ClienteModel) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.codigoCliente, other.codigoCliente)) {
            return false;
        }
        if (!Objects.equals(this.dataDeCadastro, other.dataDeCadastro)) {
            return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    
    
    

}
