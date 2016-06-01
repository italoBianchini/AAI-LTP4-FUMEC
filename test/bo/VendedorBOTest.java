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
            assertNotNull(vendedorBO.recuperarVendedorPorId(822));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Ignore
    @Test
    public void testDeletarVendedor() throws Exception {

        try {
            assertTrue(vendedorBO.deletarVendedor(1));

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void testAlterarVendedor() throws Exception {
        boolean alterouCorretamente;
        VendedorModel vendedorModel = UtilTestes.criaVendedorAleatorio();
        try {
            assertTrue(vendedorBO.alterarVendedor(vendedorModel));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testRecuperarVendedorPorNome() throws Exception {
        String nome = "italo";
        try {
            assertNotNull(vendedorBO.recuperarVendedorPorNome(nome));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
