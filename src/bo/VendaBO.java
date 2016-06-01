package bo;

import Exception.BusinessException;
import Exception.PersistenciaException;
import dao.VendaDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClienteModel;
import model.VendaModel;
import model.VendedorModel;

/**
 * Classe responsável pelas regras de negócio do objecto <b>VendaModel</b>
 *Pacote BO
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class VendaBO {
    
    VendaDAO vendaDAO = new VendaDAO();
    
    public boolean inserirVenda(VendaModel vendaModel) throws BusinessException, PersistenciaException {
        boolean inseriuCorretamente = false;

        try {
            if (vendaValida(vendaModel)) {
                inseriuCorretamente = vendaDAO.inserir(vendaModel);

            } else {
                throw new BusinessException("Venda Inválida");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }
    
    
    
    public VendaModel recuperarVendaPorId(int codigoVenda) throws BusinessException, PersistenciaException {
        VendaModel vendaModel;

        try {
            if (codigoValido(codigoVenda)) {
                vendaModel = vendaDAO.recuperarPorId(codigoVenda);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendaModel;
    }
    
    
    public boolean deletarVenda(int codigoVenda) throws BusinessException, PersistenciaException {
        VendaModel vendaModel;
        Boolean deletouCorretamente = false;

        try {
            vendaModel = vendaDAO.recuperarPorId(codigoVenda);

            if (vendaModel != null) {
                deletouCorretamente = vendaDAO.delete(codigoVenda);

            } else {
                throw new BusinessException("Código Inválido");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return deletouCorretamente;
    }
    
    public boolean alterarVenda(VendaModel vendaAlterada) throws BusinessException, PersistenciaException {
        VendaModel vendaOriginal;
        boolean alterouCorretamente = false;

        try {
            vendaOriginal = vendaDAO.recuperarPorId(vendaAlterada.getCodigoVenda());

            if (vendaOriginal != vendaAlterada) {
                alterouCorretamente = vendaDAO.alterar(vendaAlterada);

            } else {
                throw new BusinessException("Não existem alterações");
            }

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return alterouCorretamente;
    }
    
    
//    public ArrayList recuperarVendaPorNome(String nomeVenda) throws BusinessException, PersistenciaException {
//        ArrayList listaDeVenda = new ArrayList<>();
//
//        try {
//
//            if (!nomeValido(nomeVendedor)) {
//                throw new BusinessException("Nome Inválido");
//            }
//
//            listaDeVendedores = vendedorDAO.recuperarPorNome(nomeVendedor);
//
//            if (listaDeVendedores.isEmpty()) {
//                throw new BusinessException("Nenhum Vendedor Encontrado");
//            }
//
//        } catch (Exception e) {
//            throw new PersistenciaException(e.getMessage(), e);
//        }
//        return listaDeVendedores;
//    }
    
    
    
    
    
    
    
    
    
    
    public boolean vendaValida(VendaModel vendaModel) throws PersistenciaException {
        boolean vendaNaoCadastrada = false;

        try {
            vendaNaoCadastrada = vendaAindaNaoCadastrada(vendaModel.getCodigoVenda());

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return atributosValidos(vendaModel) && vendaNaoCadastrada;
    }

    public boolean vendaAindaNaoCadastrada(int codigoVenda) throws PersistenciaException {
        VendaModel vendaModel;

        try {
            vendaModel = vendaDAO.recuperarPorId(codigoVenda);

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendaModel == null;
    }

    public boolean atributosValidos(VendaModel vendaModel) throws PersistenciaException {
        return codigoValido(vendaModel.getCodigoVenda())
                && codigoVendedorValido(vendaModel.getCodigoVendedor())
                && codigoClienteValido(vendaModel.getCodigoCliente());                                       
    }

    public boolean codigoValido(int codigo) {
        return codigo > 0;
    }

    public boolean codigoVendedorValido(int codigo) throws PersistenciaException{
        VendedorBO vendedor = new VendedorBO();
        VendedorModel vendedorModel = VendedorModel.CriaVendedorVazio();
        try {
            vendedorModel = vendedor.recuperarVendedorPorId(codigo);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return vendedorModel != null;
    }

    
    public boolean codigoClienteValido(int codigo)throws PersistenciaException{
        ClienteBO cliente = new ClienteBO();
        ClienteModel clienteModel = ClienteModel.CriarClienteVazio();
        try {
            clienteModel = cliente.recuperarClientePorId(codigo);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return clienteModel != null;
    
    }   
    
    
}
