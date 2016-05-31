
package Exception;

/**
 * Classe responsável pelas Exceptions do objeto <b>ProdutoModel</b>
 * Pacote: Exception
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class ProdutoException extends PersistenciaException {
    public ProdutoException(String mensagem) {
        super(mensagem);
    }
}
