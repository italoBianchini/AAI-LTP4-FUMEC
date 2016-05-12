package dao;

import Exception.PersistenciaException;
import Util.UtilTestes;
import model.ClienteModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A Classe <b>ClienteDAOTest</b> é responsável pelos testes do
 * <b>ClienteModel</b>
 * PacoteTest: dao
 *
 * @author Ítalo
 */
public class ClienteDAOTest {

    private ClienteModel clienteModel;
    private ClienteDAO clienteDAO;

    @Before
    public void setUp() {
    }

    /**
     * Test of Inserir method, of class ClienteDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testInserir() throws Exception {

        clienteModel = ClienteModel.CriarCliente();
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

}
