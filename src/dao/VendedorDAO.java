package dao;

import Exception.ClienteExcption;
import Exception.PersistenciaException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.VendedorModel;

/**
 * A classe <b>VendedorDAO</b> implementa os metodos de acesso ao banco
 * relacionados ao objeto <b>VendedorModel</b>. Pacote dao.
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class VendedorDAO implements GenericDAO<VendedorModel> {

     private final String SQL_BASE = "SELECT  cod_vendedor, nome_vendedor, data_cad_vendedor FROM Vendedores";
   
     @Override
    public boolean inserir(VendedorModel vendedorModel) throws PersistenciaException {

        boolean inseriuCorretamente = false;

        Connection connection;

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = "INSERT INTO Vendedores (cod_vendedor, nome_vendedor, data_cad_vendedor ) VALUES(?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, vendedorModel.getCodigoVendedor());
            statement.setString(2, vendedorModel.getNomeVendedor());
            statement.setDate(3, vendedorModel.getDataCadVendedor());

            statement.execute();
            connection.close();

            inseriuCorretamente = true;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;

    }

    @Override
    public VendedorModel recuperarPorId(int codigoVendedor) throws PersistenciaException {

        Connection connection;
        VendedorModel vendedorModel = VendedorModel.CriaVendedorVazio();

        try {
            connection = Conexao.getInstance().getConnection();

            String sql =  SQL_BASE + " WHERE cod_vendedor = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoVendedor);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                vendedorModel.setCodigoVendedor(codigoVendedor);
                vendedorModel.setNomeVendedor(resultSet.getString("nome_vendedor"));
                vendedorModel.setDataCadVendedor(resultSet.getDate("data_cad_vendedor"));
                
            } else {
                vendedorModel = null;
            }
            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendedorModel;
    }

    @Override
    public boolean delete(int codigoVendedor) throws PersistenciaException {
        Connection connection;
        boolean excluiuCorretamente = false;

        try {

            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "DELETE FROM Vendedores WHERE cod_Vendedor = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoVendedor);

            statement.executeUpdate();

            excluiuCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return excluiuCorretamente;
    }

    @Override
    public boolean alterar(VendedorModel vendedorModel) throws PersistenciaException {
        Connection connection;
        boolean alterouCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "UPDATE Vendedores SET nome_vendedor = ? , data_cad_vendedor = ?  WHERE cod_Vendedor = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vendedorModel.getNomeVendedor());
            statement.setDate(2, vendedorModel.getDataCadVendedor());
            statement.setInt(3, vendedorModel.getCodigoVendedor());

            statement.executeUpdate();
            alterouCorretamente = true;

            connection.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new PersistenciaException(e.getMessage());

        }
        return alterouCorretamente;
    }

    @Override
    public ArrayList recuperarPorNome(String nomeInformado) throws PersistenciaException {
         Connection connection;
        ArrayList<VendedorModel> listaVendedores = new ArrayList<>();
        VendedorModel vendedorModel = VendedorModel.CriaVendedorVazio();

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE nome_vendedor LIKE ? ORDER BY nome_vendedor";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%" + nomeInformado + "%");
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                while (resultSet.next()) {

                    vendedorModel.setCodigoVendedor(resultSet.getInt("cod_vendedor"));
                    vendedorModel.setNomeVendedor(resultSet.getString("nome_vendedor"));
                    vendedorModel.setDataCadVendedor(resultSet.getDate("data_cad_vendedor"));
                    
                    listaVendedores.add(vendedorModel);
                }

            } else {
                listaVendedores = null;
                throw new ClienteExcption("Nenhum Vendedor encontrado");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaVendedores;
    }
}
