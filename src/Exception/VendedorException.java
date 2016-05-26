package Exception;

/**
 * Classe responsável pelas Exceptions do objeto <b>VendedorModel</b>
 * Pacote: Exception
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class VendedorException  extends PersistenciaException{
    
    public VendedorException(String mensagem) {
        super(mensagem);
    }
    
}
