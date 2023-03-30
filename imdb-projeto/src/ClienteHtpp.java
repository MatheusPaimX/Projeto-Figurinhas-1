import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHtpp {
    
    public String buscaDados(String url){
    try {
        
            URI endereco = URI.create(url);
            HttpClient cliente = HttpClient.newHttpClient(); //neste HttpClient podemos usar var "var cliente = HttpClient.newHttpClient();"
            HttpRequest requisicao = HttpRequest.newBuilder(endereco).GET().build(); //aqui também "var requisicao = HttpRequest.newBuilder..."
            HttpResponse<String> response = cliente.send(requisicao, BodyHandlers.ofString());// aqui também "var<String> response = cliente.send..."
            return response.body();
            
    } catch (IOException | InterruptedException ex) {
        throw new ClienteHttpException("Url não encontrada");
    }
    
}
}
