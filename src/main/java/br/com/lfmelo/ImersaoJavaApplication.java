package br.com.lfmelo;

import br.com.lfmelo.aula01.MovieAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImersaoJavaApplication {

	public static void main(String[] args) throws Exception {
		MovieAPI api = new MovieAPI();

		api.getMovies();

		SpringApplication.run(ImersaoJavaApplication.class, args);
	}

}
