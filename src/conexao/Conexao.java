package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileReader;
import java.util.Properties;

/**
 * A classe <b>Conexão</b> realiza a conexão com o banco Fireboard.<br>
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class Conexao {

    private static Conexao conexao;

    private Conexao() {

    }

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }

        return conexao;
    }

    public Connection getConnection() throws Exception, SQLException {

        Properties setup = new Properties();
        FileReader reader = new FileReader("src//Properties//setup.properties");
        setup.load(reader);

        Class.forName(setup.getProperty("driverConexao"));
        return DriverManager.getConnection(setup.getProperty("urlConexao"), setup.getProperty("Login"), setup.getProperty("Senha"));

    }

//    @SuppressWarnings("CallToPrintStackTrace")
//    public static void main(String[] args) throws Exception {
//        try {
//            System.out.println(getInstance().getConnection());
//        } catch (Exception e) {    
//            e.printStackTrace();
//        }
//        
//            
//    }

}