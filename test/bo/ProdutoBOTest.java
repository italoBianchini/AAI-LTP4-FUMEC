/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import Exception.PersistenciaException;
import Util.UtilTestes;
import java.sql.Date;
import model.ProdutoModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ítalo
 */
public class ProdutoBOTest {

    ProdutoBO produtoBO = new ProdutoBO();

    @Test
    public void testInserirProduto() throws Exception {

        //ProdutoModel produtoModel = UtilTestes.criaProdutoAleatorio();

        Date data = new Date(System.currentTimeMillis());
        ProdutoModel produtoModel = ProdutoModel.CriarProdutoVazio();

        produtoModel.setCodigoProduto(5);
        produtoModel.setNomeProduto("NomeProduto");
        produtoModel.setCodigoUnidade(5);
        produtoModel.setPrecoProduto(1000.00);
        produtoModel.setDataPreco(data);
        
        try {

            assertTrue(produtoBO.inserirProduto(produtoModel));

        } catch (Exception e) {
            System.err.println(e);
            throw new PersistenciaException(e.getMessage());
        }

    }

    @Test
    public void testRecuperarVendedorPorId() throws Exception {
    }

    @Test
    public void testDeletarVendedor() throws Exception {
    }

    @Test
    public void testAlterarCliente() throws Exception {
    }

    @Test
    public void testRecuperarProdutoPorNome() throws Exception {
    }
}
