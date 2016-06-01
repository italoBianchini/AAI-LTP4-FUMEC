package Exception;

/**
 * Classe responsável pelas Exceptions do objeto <b>VendaModel</b>
 * Pacote: Exception
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class VendaException extends PersistenciaException {
    public VendaException(String mensagem) {
        super(mensagem);
    }
}
