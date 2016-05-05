package dao;

import Exception.PersistenciaException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.ClienteModel;

/**
 * A classe <b>ClienteDAO</b> implementa os metodos de acesso ao banco
 * relacionados ao objeto <b>ClienteModel</b>.
 * Pacote dao.
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class ClienteDAO implements GenericDAO<ClienteModel> {

    @Override
    public boolean Inserir(ClienteModel clienteModel) throws PersistenciaException {

        boolean inseriuCorretamente = false;

        Connection connection;

        try {

            connection = Conexao.getInstance().getConnection();

            String sql = "INSERT INTO Clientes (codCliente, Nome, Endereco, Bairro, Cidade, Uf, Cep, Telefone, E_mail, data_Cad_Cliente)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, clienteModel.getCodigoCliente());
            statement.setString(2, clienteModel.getNome());
            statement.setString(3, clienteModel.getEndereco());
            statement.setString(4, clienteModel.getBairro());
            statement.setString(5, clienteModel.getCidade());
            statement.setString(6, clienteModel.getUf());
            statement.setString(7, clienteModel.getCep());
            statement.setString(8, clienteModel.getTelefone());
            statement.setString(9, clienteModel.getEmail());
            statement.setDate(10, clienteModel.getDataDeCadastro());

            statement.execute();
            connection.close();

            inseriuCorretamente = true;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

}


