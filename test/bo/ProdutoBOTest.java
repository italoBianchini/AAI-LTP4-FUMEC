package bo;

import Exception.PersistenciaException;
import Util.UtilTestes;
import java.sql.Date;
import model.ProdutoModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ítalo
 */
public class ProdutoBOTest {

    ProdutoBO produtoBO = new ProdutoBO();

    public ProdutoBOTest(){
        
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testRecuperarProdutoPorId() throws Exception {
        try {
            assertNotNull(produtoBO.recuperarProdutoPorId(4));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Ignore
    @Test
    public void testDeletarProduto() throws Exception {
        try {
            assertTrue(produtoBO.deletarProduto(6));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testInserirProduto() throws Exception {
        ProdutoModel produtoModel = UtilTestes.criaProdutoAleatorio();
        produtoModel.setCodigoUnidade(2);

        try {

            assertTrue(produtoBO.inserirProduto(produtoModel));

        } catch (Exception e) {
            System.err.println(e);
            throw new PersistenciaException(e.getMessage());
        }

    }

    @Test
    public void testAlterarProduto() throws Exception {
        boolean alterouCorretamente;

        try {

            ProdutoModel produtoRecuperado = produtoBO.recuperarProdutoPorId(477);
            produtoRecuperado.setNomeProduto("italo");

            assertTrue(produtoBO.alterarProduto(produtoRecuperado));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testRecuperarProdutoPorNome() throws Exception {
        String nome = "italo";
        try {
            assertNotNull(produtoBO.recuperarProdutoPorNome(nome));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
