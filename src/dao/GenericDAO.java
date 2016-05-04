package dao;

import Exception.PersistenciaException;

/**
 * A classe <b>GenericDAO</b> implementa metodos genericos data access. Pacote
 * dao.
 *
 * @author Ítalo Bianchini
 * @param <genericObject>
 * @since Maio, 2016
 * @version 1.0
 */
public interface GenericDAO<genericObject> {

    /**
     * Método generico para inserir dados no banco
     *
     * @param obj
     * @return booleano
     * @throws PersistenciaException
     * @since Maio, 2016
     */
    boolean Inserir(genericObject obj) throws PersistenciaException;

}
