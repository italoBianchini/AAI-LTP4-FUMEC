package Util;

import java.sql.Date;
import java.util.Random;
import model.ClienteModel;
import model.VendedorModel;

public class UtilTestes {

    public static ClienteModel criaClienteAleatorio() {

        ClienteModel cliente = ClienteModel.CriarClienteVazio();

        cliente.setCodigoCliente(criaIdAleatorio());
        cliente.setNome(criaPalavraAleatoria());
        cliente.setEndereco("te");
        cliente.setBairro("te");
        cliente.setCidade("cidadeTeste");
        cliente.setUf("UfTeste");
        cliente.setCep("cepTeste");
        cliente.setTelefone("telefoneTeste");
        cliente.setEmail("emailTeste");
        cliente.setDataDeCadastro(UtilTestes.criaDataCorrente());

        return cliente;
    }

    public static VendedorModel criaVendedorAleatorio(){
        
        VendedorModel vendedorModel = VendedorModel.CriaVendedorVazio();
        
        vendedorModel.setCodigoVendedor(criaIdAleatorio());
        vendedorModel.setNomeVendedor(criaPalavraAleatoria());
        vendedorModel.setDataCadVendedor(criaDataCorrente());
        
        return vendedorModel;
    }
    
    
    public static int criaIdAleatorio() {

        Random gerador = new Random();
        int numeroGerado = gerador.nextInt(1001);
        return numeroGerado;
    }

    public static Date criaDataCorrente() {

        Date data = new Date(System.currentTimeMillis());
        return data;
    }

    public static String criaPalavraAleatoria() {

        @SuppressWarnings("UnusedAssignment")
        int index = -1;
        String letras = "ABC";
        String aleatoria = new String();
        Random gerador = new Random();
        for (int i = 0; i < 3; i++) {
            index = gerador.nextInt(letras.length());
            aleatoria += letras.substring(index, index + 1);
        }

        return aleatoria;
    }

}
