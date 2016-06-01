package bo;

import Exception.PersistenciaException;
import Util.UtilTestes;
import model.VendaModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ítalo
 */
public class VendaBOTest {
    
    VendaBO vendaBO = new VendaBO();
    
    public VendaBOTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testInserirVenda() throws Exception {
        VendaModel vendaModel = VendaModel.CriaVenda();
        vendaModel.setCodigoVenda(UtilTestes.criaIdAleatorio());
        vendaModel.setCodigoVendedor(5);
        vendaModel.setCodigoCliente(2);
        vendaModel.setDataVenda(UtilTestes.criaDataCorrente());
        
        try {

            assertTrue(vendaBO.inserirVenda(vendaModel));

        } catch (Exception e) {
            System.err.println(e);
            throw new PersistenciaException(e.getMessage());
        }
    
    }

    
    @Test
    public void testRecuperarVendaPorId() throws Exception {
        try {
            assertNotNull(vendaBO.recuperarVendaPorId(897));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Ignore
    @Test
    public void testDeletarVenda() throws Exception {
        try {
            assertTrue(vendaBO.deletarVenda(582));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Ignore
    @Test
    public void testAlterarVenda() throws Exception {
        boolean alterouCorretamente;

        try {

            VendaModel vendaRecuperada = vendaBO.recuperarVendaPorId(626);
            vendaRecuperada.setCodigoCliente(3);

            assertTrue(vendaBO.alterarVenda(vendaRecuperada));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
}
