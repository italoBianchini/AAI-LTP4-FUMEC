package bo;

import Exception.PersistenciaException;
import Util.UtilTestes;
import model.VendedorModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ítalo
 */
public class VendedorBOTest {

    VendedorBO vendedorBO = new VendedorBO();

    public VendedorBOTest() {
    }

    @Before
    public void setUp() {
    }

    @Ignore
    @Test
    public void testInserirVendedor() throws Exception {
        VendedorModel vendedorModel = UtilTestes.criaVendedorAleatorio();

        try {
            assertTrue(vendedorBO.inserirVendedor(vendedorModel));

        } catch (Exception e) {
            System.err.println(e);
            throw new PersistenciaException(e.getMessage());
        }

    }

    @Test
    public void testRecuperarVendedorPorId() throws Exception {

        try {
            assertNotNull(vendedorBO.recuperarVendedorPorId(3));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testDeletarCliente() throws Exception {

        try {
            assertTrue(vendedorBO.deletarVendedor(1));
            
        } catch (Exception e) {
            System.out.println(e);
        
        }
    }

    @Test
    public void testAlterarCliente() throws Exception {
    }

    @Test
    public void testRecuperarVendedorPorNome() throws Exception {
    }

    @Test
    public void testVendedorValido() throws Exception {
    }

    @Test
    public void testClienteAindaNaoCadastrado() throws Exception {
    }

    @Test
    public void testAtributosValidos() {
    }

    @Test
    public void testCodigoValido() {
    }

    @Test
    public void testNomeValido() {
    }

    @Test
    public void testDataValido() {
    }

}
