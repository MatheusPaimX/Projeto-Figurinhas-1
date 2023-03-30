public enum API {
    
    IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorConteudoIMDB()),
    IMDB_TV("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtratorConteudoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new ExtratorConteudoNasa()),
    LINGUAGEM("http://localhost:8080/linguagens", new ExtratorConteudoLinguagem()),
    FOTO("http://localhost:8080/fotos", new ExtratorConteudoLinguagem());

    private String url;
    private ExtratorDeConteudo extrator;


    API(String url, ExtratorDeConteudo extrator){
        this.url = url;
        this.extrator = extrator;

    }
    public String getUrl() {
        return url;
    }
    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
