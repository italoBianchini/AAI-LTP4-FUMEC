package bo;

import Exception.BusinessException;
import Exception.PersistenciaException;
import dao.ClienteDAO;
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

    ClienteDAO clienteDAO = new ClienteDAO();

    public boolean inserirCliente(ClienteModel clienteModel) throws BusinessException, PersistenciaException {
        boolean inseriuCorretamente = false;

        try {
            if (clienteValido(clienteModel)) {
                inseriuCorretamente = clienteDAO.inserir(clienteModel);

            } else {
                throw new BusinessException("Cliente Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

    public ClienteModel recuperarClientePorId(int codigoCliente) throws BusinessException, PersistenciaException {
        ClienteModel clienteModel;

        try {
            if (codigoValido(codigoCliente)) {
                clienteModel = clienteDAO.recuperarPorId(codigoCliente);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return clienteModel;
    }

    public boolean deletarCliente(int codigoCliente) throws BusinessException, PersistenciaException {
        ClienteModel clienteModel;
        Boolean deletouCorretamente = false;

        try {
            clienteModel = clienteDAO.recuperarPorId(codigoCliente);

            if (clienteModel != null) {
                deletouCorretamente = clienteDAO.delete(codigoCliente);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return deletouCorretamente;
    }

    public boolean alterarCliente(ClienteModel clienteAlterado) throws BusinessException, PersistenciaException {
        ClienteModel clienteOriginal;
        boolean alterouCorretamente = false;

        try {
            clienteOriginal = clienteDAO.recuperarPorId(clienteAlterado.getCodigoCliente());

            if (!clienteOriginal.equals(clienteAlterado)) {
                alterouCorretamente = clienteDAO.alterar(clienteAlterado);
            } else {
                throw new BusinessException("Não existem alterações");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return alterouCorretamente;
    }

    public boolean clienteValido(ClienteModel clienteModel) throws PersistenciaException {
        boolean clienteNaoCadastrado;

        try {
            clienteNaoCadastrado = clienteAindaNaoCadastrado(clienteModel.getCodigoCliente());
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return atributosValidos(clienteModel) && clienteNaoCadastrado;
    }

    public boolean clienteAindaNaoCadastrado(int codigoCliente) throws PersistenciaException {
        ClienteModel clienteModel;

        try {
            clienteModel = clienteDAO.recuperarPorId(codigoCliente);

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return clienteModel == null;
    }

    public boolean atributosValidos(ClienteModel clienteModel) {

        return codigoValido(clienteModel.getCodigoCliente())
                && nomeValido(clienteModel.getNome())
                && enderecoValido(clienteModel.getEndereco())
                && bairroValido(clienteModel.getBairro())
                && cidadeValido(clienteModel.getCidade())
                && ufValido(clienteModel.getUf())
                && cepValido(clienteModel.getCep())
                && dataValido(clienteModel.getDataDeCadastro());
    }

    public boolean codigoValido(int codigo) {
        return codigo > 0;
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

    //TODO: verificar na web maneira de se fazer isso 
    public boolean dataValido(Date data) {
        return true;
    }
}
