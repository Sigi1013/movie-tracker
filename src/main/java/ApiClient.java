import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
        private final String BASE_URL = "https://www.omdbapi.com/?apikey=7fb33ea1&type=movie&t=";
        Gson gson = new Gson();
        Movie movie = new Movie();

        public Movie fetchMovieDetails(String searchQuery){
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + searchQuery))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = null;

            try{
                response = HttpClient.newHttpClient()
                        .send(getRequest, HttpResponse.BodyHandlers.ofString());
            }catch (IOException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
//            System.out.println(response.body());
            movie = gson.fromJson(response.body(), Movie.class);

            if(movie.getResponse().equalsIgnoreCase("False")){
                System.out.println("\n" + movie.getError() + "\nTry again");
            }else{
                System.out.println("\nTitle: " + movie.getTitle() + " | "
                        + "Released: " + movie.getYear() + " | "
                        + "Runtime: " + movie.getRuntime() + " | "
                        + "Director: " + movie.getDirector() + " | "
                        + "Imdb rating: " + movie.getImdbRating() + " | "
                );
            }
            return movie;
        }
}

