package dao;

import Exception.PersistenciaException;
import java.sql.Date;
import model.ClienteModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ítalo
 */
public class ClienteDAOTest {

    public ClienteDAOTest() {
    }

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

        ClienteModel clienteModel = new ClienteModel();

        Date data = new Date(System.currentTimeMillis());

        clienteModel.setCodigoCliente(2);
        clienteModel.setNome("te");
        clienteModel.setEndereco("te");
        clienteModel.setBairro("te");
        clienteModel.setCidade("te");
        clienteModel.setUf("te");
        clienteModel.setCep("te");
        clienteModel.setTelefone("te");
        clienteModel.setEmail("te");
        clienteModel.setDataDeCadastro(data);

        try {

            ClienteDAO clienteDAO = new ClienteDAO();
            assertTrue(clienteDAO.Inserir(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

}
