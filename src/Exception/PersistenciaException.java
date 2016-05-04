package Exception;

/**
 * A classe <b>PersistenciaException</b> é responsável pela persistencia dos dados relacioanados ao banco .<br>
 * Pacote Exception.
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class PersistenciaException extends Exception {

    public PersistenciaException(String mensagem, Exception exception) {
        super(mensagem, exception);

    }

    public PersistenciaException(String mensagem) {
        super(mensagem);

    }

}
