package Util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Ítalo
 */
public class UtilMensagem {
    public static void addMsg (Component componente, String mensagem){
                JOptionPane.showMessageDialog(componente, mensagem, "Alerta", JOptionPane.ERROR_MESSAGE);
    }
   
     public static int addMsgComResposta (Component componente, String mensagem){
		 return JOptionPane.showConfirmDialog(componente, mensagem, "", JOptionPane.YES_NO_OPTION);
	}
     
      public static void addMsgInformacao (Component componente, String mensagem){
		JOptionPane.showMessageDialog(componente, mensagem);
    }
     
}
