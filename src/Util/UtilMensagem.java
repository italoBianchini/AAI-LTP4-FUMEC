package Util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Ítalo
 */
public class UtilMensagem {
    public static void addMsg (Component componente, String mensagem){
		JOptionPane.showMessageDialog(componente, mensagem);
	}
   
}
