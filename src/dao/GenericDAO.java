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

   
    boolean inserir(genericObject obj) throws PersistenciaException;
    
     Object recuperarPorId(int  id) throws PersistenciaException;
     
     boolean delete(genericObject obj)throws  PersistenciaException;
     
     boolean alterar(genericObject obj) throws  PersistenciaException;

}
