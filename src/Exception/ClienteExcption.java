package Exception;

/**
 * Classe responsável pelas Exceptions do objeto <b>ClienteModel</b>
 * Pacote: Exception
 *
 * @author Ítalo
 * @version 1.0
 * @since Maio, 2016
 */
public class ClienteExcption extends PersistenciaException{
    
    public ClienteExcption(String mensagem) {
        super(mensagem);
    }
      
}
