package dao;

import Exception.PersistenciaException;
import Util.UtilTestes;
import bo.ClienteBO;
import model.ClienteModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * A Classe <b>ClienteDAOTest</b> é responsável pelos testes do
 * <b>ClienteModel</b>
 * PacoteTest: dao
 *
 * @author Ítalo
 */
public class ClienteDAOTest {

    private static ClienteModel clienteModel;
    private static ClienteBO clienteBO;

    private static ClienteDAO clienteDAO;

    @Before
    public void setUp() {
    }

    @Test
    public void testInserir() throws PersistenciaException {

        clienteModel = ClienteModel.CriarClienteVazio();
        clienteBO = new ClienteBO();

        clienteModel.setCodigoCliente(UtilTestes.criaIdAleatorio());
        clienteModel.setNome("te");
        clienteModel.setEndereco("te");
        clienteModel.setBairro("te");
        clienteModel.setCidade("te");
        clienteModel.setUf("te");
        clienteModel.setCep("te");
        clienteModel.setTelefone("te");
        clienteModel.setEmail("te");
        clienteModel.setDataDeCadastro(UtilTestes.criaDataCorrente());

        try {

            assertTrue(clienteBO.inserirCliente(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    @Ignore
    @Test
    public void testInserirClienteJaCadastrado() throws PersistenciaException {

        clienteModel = ClienteModel.CriarClienteVazio();
        clienteBO = new ClienteBO();

        clienteModel.setCodigoCliente(2);
        clienteModel.setNome("te");
        clienteModel.setEndereco("te");
        clienteModel.setBairro("te");
        clienteModel.setCidade("te");
        clienteModel.setUf("te");
        clienteModel.setCep("te");
        clienteModel.setTelefone("te");
        clienteModel.setEmail("te");
        clienteModel.setDataDeCadastro(UtilTestes.criaDataCorrente());

        try {
            assertFalse(clienteBO.inserirCliente(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    @Ignore
    @Test
    public void testInserirSemAtributosValidos() throws PersistenciaException {

        clienteModel = ClienteModel.CriarClienteVazio();
        clienteBO = new ClienteBO();

        clienteModel.setCodigoCliente(UtilTestes.criaIdAleatorio());
        clienteModel.setNome("");
        clienteModel.setEndereco("te");
        clienteModel.setBairro("te");
        clienteModel.setCidade("");
        clienteModel.setUf("te");
        clienteModel.setCep("te");
        clienteModel.setTelefone("te");
        clienteModel.setEmail("te");
        clienteModel.setDataDeCadastro(UtilTestes.criaDataCorrente());

        try {
            assertFalse(clienteBO.inserirCliente(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    @Test
    public void testRecuperarPorId() throws PersistenciaException {

        int idCLiente = 2;
        clienteBO = new ClienteBO();

        try {

            clienteModel = clienteBO.recuperarClientePorId(idCLiente);
            
        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }
        
        assertNotNull(clienteModel);
    }

    @Test
    public void testRecuperarPorIdInvalido() throws PersistenciaException {

        int idCLiente = 0;
        clienteBO = new ClienteBO();

        try {
            clienteModel = clienteBO.recuperarClientePorId(idCLiente);
        
        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

         assertNull(clienteModel);
    }

    
    @Test
    public void testDelete() throws PersistenciaException {
        boolean resultado;
        clienteBO = new ClienteBO();

        try {
            resultado = clienteBO.deletarCliente(23);
            
        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }
        assertTrue(resultado);

    }

    @Test
    public void testAlterar() throws PersistenciaException {

        clienteModel = ClienteModel.CriarClienteVazio();
        clienteDAO = new ClienteDAO();

        try {
            clienteModel = clienteDAO.recuperarPorId(2);
            clienteModel.setNome(UtilTestes.criaPalavraAleatoria());

            assertTrue(clienteDAO.alterar(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    @Test
    public void testRecuperarPorNome() throws PersistenciaException {

        String nome = "te";
        clienteDAO = new ClienteDAO();

        try {
            assertNotNull(clienteDAO.recuperarPorNome(nome));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

}
