import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorDeConteudo{
    public List<Conteudo> extrairConteudos(String body){
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(body);


            return listaDeAtributos.stream()
            .map((atributos) -> new Conteudo(atributos.get("title"), atributos.get("url")))
            .toList();
        }
}
