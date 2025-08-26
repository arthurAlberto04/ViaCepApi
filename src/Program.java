import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Scanner scan = new Scanner(System.in);

        System.out.printf("Digite um Cep: ");
        String cep = scan.nextLine();

        ConsultaCep consulta = new ConsultaCep();
        Endereco endereco = consulta.buscaEndereco(cep, gson);

        GeraArquivoJson json = new GeraArquivoJson();
        json.GerarArquivo(endereco, gson);
    }
}
