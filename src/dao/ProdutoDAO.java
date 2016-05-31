package dao;

import Exception.PersistenciaException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

            String sql = "INSERT INTO tabProdutos (codProduto, produto, codUnidade, preco, dataPreco"
                    + "VALUES(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, produtoModel.getCodigoProduto());
            statement.setString(2,produtoModel.getNomeProduto());
            statement.setInt(3, produtoModel.getCodUnidade());
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
    public Object recuperarPorId(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(ProdutoModel obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList recuperarPorNome(String nome) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
