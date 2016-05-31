package dao;

import Exception.PersistenciaException;
import Exception.ProdutoException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ProdutoModel;

/**
 * A classe <b>ProdutoDAO</b> implementa os metodos de acesso ao banco
 * relacionados ao objeto <b>ProdutoModel</b>. Pacote dao.
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class ProdutoDAO implements GenericDAO<ProdutoModel> {

    private final String SQL_BASE = "SELECT codProduto, produto, codUnidade, preco, dataPreco from tabProdutos ";

    @Override
    public boolean inserir(ProdutoModel produtoModel) throws PersistenciaException {
        boolean inseriuCorretamente = false;

        Connection connection;

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = "insert into tabprodutos (codProduto,produto, codUnidade, PRECO, DATAPRECO)"
                    + "VALUES(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, produtoModel.getCodigoProduto());
            statement.setString(2, produtoModel.getNomeProduto());
            statement.setInt(3, produtoModel.getCodigoUnidade());
            statement.setDouble(4, produtoModel.getPrecoProduto());
            statement.setDate(5, produtoModel.getDataPreco());

            statement.execute();
            connection.close();

            inseriuCorretamente = true;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;

    }

    @Override
    public ProdutoModel recuperarPorId(int idProduto) throws PersistenciaException {
        Connection connection;
        ProdutoModel produtoModel = ProdutoModel.CriarProdutoVazio();

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE codProduto = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, idProduto);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                produtoModel.setCodigoProduto(idProduto);
                produtoModel.setNomeProduto(resultSet.getString("Nome"));
                produtoModel.setCodigoUnidade(resultSet.getInt("codUnidade"));
                produtoModel.setPrecoProduto(resultSet.getDouble("preco"));
                produtoModel.setDataPreco(resultSet.getDate("dataPreco"));

            } else {
                produtoModel = null;
            }
            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return produtoModel;

    }

    @Override
    public boolean delete(int codigoProduto) throws PersistenciaException {
        Connection connection;
        boolean excluiuCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "DELETE FROM tabProdutos WHERE codProduto = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoProduto);

            statement.executeUpdate();

            excluiuCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return excluiuCorretamente;
    }

    @Override
    public boolean alterar(ProdutoModel produtoModel) throws PersistenciaException {
        Connection connection;
        boolean alterouCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "UPDATE tabProdutos SET codProduto = ? , nome = ?, codUnidade = ?, preco = ?, dataPreco = ?"
                    + " WHERE codProduto = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, produtoModel.getNomeProduto());
            statement.setInt(2, produtoModel.getCodigoUnidade());
            statement.setDouble(3, produtoModel.getPrecoProduto());
            statement.setDate(4, produtoModel.getDataPreco());

            statement.executeUpdate();
            alterouCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        return alterouCorretamente;
    }

    @Override
    public ArrayList recuperarPorNome(String nomeInformado) throws PersistenciaException {
        Connection connection;
        ArrayList<ProdutoModel> listaProdutos = new ArrayList<>();
        ProdutoModel produtoModel = ProdutoModel.CriarProdutoVazio();

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE produto LIKE ? ORDER BY produto";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%" + nomeInformado + "%");
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                while (resultSet.next()) {
                    produtoModel.setCodigoProduto(resultSet.getInt("codProduto"));
                    produtoModel.setNomeProduto(resultSet.getString("Produto"));
                    produtoModel.setCodigoUnidade(resultSet.getInt("codUnidade"));
                    produtoModel.setPrecoProduto(resultSet.getDouble("preco"));
                    produtoModel.setDataPreco(resultSet.getDate("dataPreco"));
                    
                    listaProdutos.add(produtoModel);
                }

            } else {
                listaProdutos = null;
                throw new ProdutoException("Nenhum Cliente encontrado");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaProdutos;
    }
}
