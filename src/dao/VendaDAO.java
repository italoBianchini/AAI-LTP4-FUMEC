package dao;

import Exception.PersistenciaException;
import Exception.VendaException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ProdutoModel;
import model.VendaModel;

/**
 * A classe <b>VendaDAO</b> implementa os metodos de acesso ao banco
 * relacionados ao objeto <b>VendaModel</b>. Pacote dao.
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class VendaDAO implements GenericDAO<VendaModel> {

    private final String SQL_BASE = "SELECT codVenda, codVendedor, codCliente, dataVenda from Vendas ";

    @Override
    public boolean inserir(VendaModel vendaModel) throws PersistenciaException {
        boolean inseriuCorretamente = false;

        Connection connection;

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = "insert into Vendas (codVenda, codVendedor, codCliente, dataVenda)"
                    + "VALUES(?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, vendaModel.getCodigoVenda());
            statement.setInt(2, vendaModel.getCodigoVendedor());
            statement.setInt(3, vendaModel.getCodigoCliente());
            statement.setDate(4, vendaModel.getDataVenda());

            statement.execute();
            connection.close();

            inseriuCorretamente = true;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

    @Override
    public VendaModel recuperarPorId(int codigoVenda) throws PersistenciaException {
        Connection connection;
        VendaModel vendaModel = VendaModel.CriaVenda();

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE codVenda = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoVenda);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                vendaModel.setCodigoVenda(codigoVenda);
                vendaModel.setCodigoVendedor(resultSet.getInt("codVendedor"));
                vendaModel.setCodigoCliente(resultSet.getInt("codCliente"));
                vendaModel.setDataVenda(resultSet.getDate("dataVenda"));

            } else {
                vendaModel = null;
            }
            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendaModel;
    }

    @Override
    public boolean delete(int codigoVenda) throws PersistenciaException {
        Connection connection;
        boolean excluiuCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "DELETE FROM Vendas WHERE codVenda = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoVenda);

            statement.executeUpdate();

            excluiuCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return excluiuCorretamente;
    }

    @Override
    public boolean alterar(VendaModel vendaModel) throws PersistenciaException {
        Connection connection;
        boolean alterouCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "UPDATE vendas SET codVendedor = ? , codCliente = ?, dataVenda = ?"
                    + " WHERE codVenda = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, vendaModel.getCodigoVendedor());
            statement.setInt(2, vendaModel.getCodigoCliente());
            statement.setDate(3, vendaModel.getDataVenda());
            statement.setInt(4, vendaModel.getCodigoVenda());

            statement.executeUpdate();
            alterouCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        return alterouCorretamente;
    }

    @Override
    public ArrayList recuperarPorNome(String nome) throws PersistenciaException {
        Connection connection;
        ArrayList<VendaModel> listaVendas = new ArrayList<>();
        VendaModel vendaModel = VendaModel.CriaVenda();

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            //TODO Corrigir SQL
            String sql = SQL_BASE + "WHERE produto LIKE ? ORDER BY produto";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + nome + "%");
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                while (resultSet.next()) {
                    vendaModel.setCodigoVenda(resultSet.getInt("codVenda"));
                    vendaModel.setCodigoVendedor(resultSet.getInt("codVendedor"));
                    vendaModel.setCodigoCliente(resultSet.getInt("codCliente"));
                    vendaModel.setDataVenda(resultSet.getDate("datVenda"));

                    listaVendas.add(vendaModel);
                }

            } else {
                listaVendas = null;
                throw new VendaException("Nenhuma Venda Encontrada");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaVendas;
    }

}
