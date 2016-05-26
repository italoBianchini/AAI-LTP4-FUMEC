package bo;

import Exception.BusinessException;
import Exception.PersistenciaException;
import dao.VendedorDAO;
import java.sql.Date;
import java.util.ArrayList;
import model.VendedorModel;

/**
 * Classe responsável pelas regras de negócio do objecto <b>VendedorModel</b>
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class VendedorBO {

    VendedorDAO vendedorDAO = new VendedorDAO();

    public boolean inserirCliente(VendedorModel vendedorModel) throws BusinessException, PersistenciaException {
        boolean inseriuCorretamente = false;

        try {
            if (vendedorValido(vendedorModel)) {
                inseriuCorretamente = vendedorDAO.inserir(vendedorModel);

            } else {
                throw new BusinessException("Cliente Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

       public VendedorModel recuperarVendedorPorId(int codigoVendedor) throws BusinessException, PersistenciaException {
        VendedorModel vendedorModel;

        try {
            if (codigoValido(codigoVendedor)) {
                vendedorModel = vendedorDAO.recuperarPorId(codigoVendedor);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendedorModel;
    }
    
       public boolean deletarCliente(int codigoVendedor) throws BusinessException, PersistenciaException {
        VendedorModel vendedorModel;
        Boolean deletouCorretamente = false;

        try {
            vendedorModel = vendedorDAO.recuperarPorId(codigoVendedor);

            if (vendedorModel != null) {
                deletouCorretamente = vendedorDAO.delete(codigoVendedor);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return deletouCorretamente;
    }
    
     public boolean alterarCliente(VendedorModel vendedorAlterado) throws BusinessException, PersistenciaException {
        VendedorModel vendedorOriginal;
        boolean alterouCorretamente = false;

        try {
            vendedorOriginal = vendedorDAO.recuperarPorId(vendedorAlterado.getCodigoVendedor());

           if (vendedorOriginal != vendedorAlterado) {
                alterouCorretamente = vendedorDAO.alterar(vendedorAlterado);

            } else {
                throw new BusinessException("Não existem alterações");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return alterouCorretamente;
    }
    
     
      public ArrayList recuperarVendedorPorNome(String nomeVendedor) throws BusinessException, PersistenciaException {
        ArrayList listaDeVendedores = new ArrayList<>();

        try {

            if (!nomeValido(nomeVendedor)) {
                throw new BusinessException("Nome Inválido");
            }

            listaDeVendedores = vendedorDAO.recuperarPorNome(nomeVendedor);

            if (listaDeVendedores.isEmpty()) {
                throw new BusinessException("Nenhum Vendedor Encontrado");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaDeVendedores;
    }
    
    public boolean vendedorValido(VendedorModel vendedorModel) throws PersistenciaException {
        boolean vendedorNaoCadastrado = false;

        try {
            vendedorNaoCadastrado = clienteAindaNaoCadastrado(vendedorModel.getCodigoVendedor());

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return atributosValidos(vendedorModel) && vendedorNaoCadastrado;
    }

    public boolean clienteAindaNaoCadastrado(int codigoVendedor) throws PersistenciaException {
        VendedorModel vendedorModel;

        try {
            vendedorModel = vendedorDAO.recuperarPorId(codigoVendedor);

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendedorModel == null;
    }

    public boolean atributosValidos(VendedorModel vendedorModel) {

        return codigoValido(vendedorModel.getCodigoVendedor())
                && nomeValido(vendedorModel.getNomeVendedor())
                && dataValido(vendedorModel.getDataCadVendedor());
    }

    public boolean codigoValido(int codigo) {
        return codigo > 0;
    }

    public boolean nomeValido(String nome) {
        return !nome.isEmpty();
    }

    //TODO: verificar na web maneira de se fazer isso 
    public boolean dataValido(Date data) {
        return true;
    }
}
