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
            
    private ClienteModel clienteModel;
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

        ClienteModel cliente = ClienteModel.CriarCliente();

        Date data = new Date(System.currentTimeMillis());

       this. clienteModel.setCodigoCliente(2);
       this. clienteModel.setNome("te");
       this. clienteModel.setEndereco("te");
        this.clienteModel.setBairro("te");
        this.clienteModel.setCidade("te");
        this.clienteModel.setUf("te");
        this.clienteModel.setCep("te");
        this.clienteModel.setTelefone("te");
        this.clienteModel.setEmail("te");
        this.clienteModel.setDataDeCadastro(data);

        try {

            ClienteDAO clienteDAO = new ClienteDAO();
            assertTrue(clienteDAO.Inserir(clienteModel));

        } catch (Exception exception) {
            throw new PersistenciaException(exception.getMessage());
        }

    }

}
