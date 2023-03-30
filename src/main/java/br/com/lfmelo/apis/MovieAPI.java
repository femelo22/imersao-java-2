package br.com.lfmelo.apis;

import br.com.lfmelo.services.HttpClientService;
import br.com.lfmelo.utils.JsonParser;

import java.util.List;
import java.util.Map;

public class MovieAPI {

    public void getMovies() throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        var http = new HttpClientService();
        String json = http.getData(url);

        // extract only the data of interest (title, poster, rating)
        var parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(json);

        // display and manipulate the data
        for (Map<String, String> movie : movieList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }
    }


}
