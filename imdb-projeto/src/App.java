import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        API api = API.FOTO;
        String url = api.getUrl();

        ExtratorDeConteudo extrator = api.getExtrator();
        
        var http = new ClienteHtpp();
        String body = http.buscaDados(url);
        
        List<Conteudo> conteudos = extrator.extrairConteudos(body);

        var diretorio = new File("saida/");
        diretorio.mkdir();
        
        var geradora = new GeradoraDeFigurinhas();
        
        for (Conteudo conteudo : conteudos) {
            
            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = conteudo.titulo() + ".jpg";
            System.out.println(conteudo.titulo());
            String textoFigurinha = "maneirissimo";
            InputStream imagemMinha = new FileInputStream(new File("sobreposicao/bom demais.png"));
            geradora.criarFigurinha(inputStream, nomeArquivo, textoFigurinha, imagemMinha);
            System.out.println();
        }
    }
}
