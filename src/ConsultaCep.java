import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep, Gson gson) {


        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json"))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            EnderecoDto dto = gson.fromJson(json, EnderecoDto.class);
            Endereco endereco = new Endereco(dto);
            return endereco;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
