package Exception;

/**
 *Classe responsável pelas excessões relacionadas a regras de objecto
 * Pacote: Exception 
 * 
 * @author Ítalo
 * @version 1.0
 * @since  Maio, 2016
 */
public class BusinessException extends  PersistenciaException{
      public BusinessException(String mensagem) {
        super(mensagem);
    }
}
