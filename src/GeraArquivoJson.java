import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GeraArquivoJson {

    public void GerarArquivo(Endereco endereco, Gson gson)
    {
        try
        {
            FileWriter escrita = new FileWriter("endereco.json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
