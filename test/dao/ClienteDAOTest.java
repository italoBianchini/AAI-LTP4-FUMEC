package dao;

import Exception.PersistenciaException;
import Util.UtilTestes;
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
    private static ClienteDAO clienteDAO;

    @Before
    public void setUp() {
    }

    /**
     * Test of Inserir method, of class ClienteDAO.
     *
     * @throws Exception.PersistenciaException
     *
     */
    @Test
    public void testInserir() throws PersistenciaException {

        clienteModel = ClienteModel.CriarClienteVazio();
        clienteDAO = new ClienteDAO();

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

            assertTrue(clienteDAO.inserir(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    /**
     * Test of recuperarPorId method, of class ClienteDAO.
     *
     * @throws Exception.PersistenciaException
     */
    @Test
    public void testRecuperarPorId() throws PersistenciaException {

        int idCLiente = 2;
        clienteDAO = new ClienteDAO();

        clienteModel = clienteDAO.recuperarPorId(idCLiente);

        try {

            assertNotNull(clienteModel);

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    /**
     * Test of delete method, of class ClienteDAO.
     *
     * @throws Exception.PersistenciaException
     */
    @Ignore
    @Test
    public void testDelete() throws PersistenciaException {

        clienteModel = ClienteModel.CriarClienteVazio();
        clienteModel.setCodigoCliente(45);
        clienteDAO = new ClienteDAO();

        try {
            assertTrue(clienteDAO.delete(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

    /**
     * Test of alterar method, of class ClienteDAO.
     *
     * @throws Exception.PersistenciaException
     */
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
    
  

}
