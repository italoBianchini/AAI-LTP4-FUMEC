package bo;

import Exception.BusinessException;
import Exception.PersistenciaException;
import dao.ProdutoDAO;
import java.sql.Date;
import java.util.ArrayList;
import model.ProdutoModel;

/**
 * Classe responsável pelas regras de negócio do objecto <b>ProdutoModel</b>
 * Pacote BO
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class ProdutoBO {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public boolean inserirVendedor(ProdutoModel produtoModel) throws BusinessException, PersistenciaException {
        boolean inseriuCorretamente = false;

        try {
            if (produtoValido(produtoModel)) {
                inseriuCorretamente = produtoDAO.inserir(produtoModel);

            } else {
                throw new BusinessException("Produto Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

    public ProdutoModel recuperarVendedorPorId(int codigoProduto) throws BusinessException, PersistenciaException {
        ProdutoModel produtoModel;

        try {
            if (codigoValido(codigoProduto)) {
                produtoModel = produtoDAO.recuperarPorId(codigoProduto);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return produtoModel;
    }

    public boolean deletarVendedor(int codigoProduto) throws BusinessException, PersistenciaException {
        ProdutoModel produtoModel;
        Boolean deletouCorretamente = false;

        try {
            produtoModel = produtoDAO.recuperarPorId(codigoProduto);

            if (produtoModel != null) {
                deletouCorretamente = produtoDAO.delete(codigoProduto);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return deletouCorretamente;
    }

    public boolean alterarCliente(ProdutoModel produtoAlterado) throws BusinessException, PersistenciaException {
        ProdutoModel produtoOriginal;
        boolean alterouCorretamente = false;

        try {
            produtoOriginal = produtoDAO.recuperarPorId(produtoAlterado.getCodigoProduto());

            if (produtoOriginal != produtoAlterado) {
                alterouCorretamente = produtoDAO.alterar(produtoAlterado);

            } else {
                throw new BusinessException("Não existem alterações");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return alterouCorretamente;
    }

    public ArrayList recuperarProdutoPorNome(String nomeProduto) throws BusinessException, PersistenciaException {
        ArrayList listaDeProdutos = new ArrayList<>();

        try {

            if (!nomeValido(nomeProduto)) {
                throw new BusinessException("Nome Inválido");
            }

            listaDeProdutos = produtoDAO.recuperarPorNome(nomeProduto);

            if (listaDeProdutos.isEmpty()) {
                throw new BusinessException("Nenhum Produto Encontrado");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaDeProdutos;
    }
    
    public boolean produtoValido(ProdutoModel produtoModel) throws PersistenciaException {
        boolean produtoNaoCadastrado = false;

        try {
            produtoNaoCadastrado = vendedorAindaNaoCadastrado(produtoModel.getCodigoProduto());

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return atributosValidos(produtoModel) && produtoNaoCadastrado;
    }

    public boolean vendedorAindaNaoCadastrado(int codigoProduto) throws PersistenciaException {
        ProdutoModel produtoModel;

        try {
            produtoModel = produtoDAO.recuperarPorId(codigoProduto);

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return produtoModel == null;
    }

    public boolean atributosValidos(ProdutoModel produtoModel) {

        return codigoValido(produtoModel.getCodigoProduto())
                && codigoValido(produtoModel.getCodigoUnidade())
                && nomeValido(produtoModel.getNomeProduto())
                && precoValido(produtoModel.getPrecoProduto())
                && dataValido(produtoModel.getDataPreco());
    }

    public boolean codigoValido(int codigo) {
        return codigo > 0;
    }

    public boolean nomeValido(String nome) {
        return !nome.isEmpty();
    }

    public boolean precoValido(Double preco) {
        return preco > 0;
    }

    public boolean dataValido(Date data) {
        return true;
    }

    public static void main(String[] args) {

        try {
            boolean teste = new VendedorBO().deletarVendedor(1);
            System.out.println(teste);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
