/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Date;
import java.util.Random;

/**
 *
 * @author Ítalo
 */
public class UtilTestes {

    public static int  criaIdAleatorio() {
        
        Random gerador = new Random();
        int numeroGerado = gerador.nextInt(101);
        return numeroGerado;
    }

    public static Date criaDataCorrente(){
        
        Date data = new Date(System.currentTimeMillis());
        return data;
    }
    
    
    
}
