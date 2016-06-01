package dao;

import Exception.PersistenciaException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ItemModel;

/**
 *
 * @author Ítalo
 */
public class ItemDAO implements GenericDAO<ItemModel> {

    private final String SQL_BASE = "SELECT cod_item, codVenda, codProduto, quantidade, valor from Itens ";
    
    @Override
    public boolean inserir(ItemModel itemModel) throws PersistenciaException {
        boolean inseriuCorretamente = false;

        Connection connection;

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = "insert into Itens (cod_item, codVenda, codProduto, quantidade, valor)"
                    + "VALUES(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, itemModel.getCodigoItem());
            statement.setInt(2, itemModel.getCodigoVenda());
            statement.setInt(3, itemModel.getCodigoProduto());
            statement.setInt(4, itemModel.getQuantidade());
            statement.setDouble(5, itemModel.getValor());
            

            statement.execute();
            connection.close();

            inseriuCorretamente = true;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

    @Override
    public ItemModel recuperarPorId(int codigoItem) throws PersistenciaException {
        Connection connection;
        ItemModel itemModel = ItemModel.CriaItem();

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE cod_item = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoItem);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                itemModel.setCodigoItem(codigoItem);
                itemModel.setCodigoVenda(resultSet.getInt("codVenda"));
                itemModel.setCodigoProduto(resultSet.getInt("codProduto"));
                itemModel.setQuantidade(resultSet.getInt("quantidade"));
                itemModel.setValor(resultSet.getDouble("valor"));
                
            } else {
                itemModel = null;
            }
            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return itemModel;
        
    }

  
    @Override
    public boolean delete(int codigoItem) throws PersistenciaException {
        Connection connection;
        boolean excluiuCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "DELETE FROM itens WHERE cod_item = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoItem);

            statement.executeUpdate();

            excluiuCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return excluiuCorretamente;
    }

    @Override
    public boolean alterar(ItemModel itemModel) throws PersistenciaException {
        Connection connection;
        boolean alterouCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "UPDATE itens SET codVenda = ? , codProduto = ?, quantidade = ?, valor = ?"
                    + " WHERE cod_item = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, itemModel.getCodigoVenda());
            statement.setInt(2, itemModel.getCodigoProduto());
            statement.setInt(3, itemModel.getQuantidade());
            statement.setDouble(4, itemModel.getValor());
            statement.setInt(5, itemModel.getCodigoItem());
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    
    
}
