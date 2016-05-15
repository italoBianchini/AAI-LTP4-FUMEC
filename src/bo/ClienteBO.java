package bo;

import java.sql.Date;
import model.ClienteModel;

/**
 * Classe responsável pelas regras de negócio do objecto <b>ClienteModel</b>
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class ClienteBO {

    public boolean clienteValido(ClienteModel clienteModel) {

        return nomeValido(clienteModel.getNome())
                && enderecoValido(clienteModel.getEndereco())
                && bairroValido(clienteModel.getBairro())
                && cidadeValido(clienteModel.getCidade())
                && ufValido(clienteModel.getUf())
                && cepValido(clienteModel.getCep())
                && telefoneValido(clienteModel.getTelefone())
                && emailValido(clienteModel.getEmail())
                && dataValido(clienteModel.getDataDeCadastro());
    }

    public boolean nomeValido(String nome) {
        return !nome.isEmpty();
    }

    public boolean enderecoValido(String endereco) {
        return !endereco.isEmpty();
    }

    public boolean bairroValido(String bairro) {
        return !bairro.isEmpty();
    }

    public boolean cidadeValido(String cidade) {
        return !cidade.isEmpty();
    }

    public boolean ufValido(String uf) {
        return !uf.isEmpty();
    }

    public boolean cepValido(String cep) {
        return !cep.isEmpty();
    }

    public boolean telefoneValido(String telefone) {
        return !telefone.isEmpty();
    }

    public boolean emailValido(String email) {
        return !email.isEmpty();
    }

    //TODO: verificar na web maneira de se fazer isso 
    public boolean dataValido(Date data) {
        return true;
    }
}
