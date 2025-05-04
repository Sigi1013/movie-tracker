import java.util.ArrayList;

public class MovieManager {
    static private final ArrayList<Movie> WatchList = new ArrayList<>();

    public static void addToWatchList(Movie movie){
        WatchList.add(movie);
    }

    public static void getWatchList(){
        System.out.println("-------------------------");
        System.out.println("Watched Movies List.");
        System.out.println("-------------------------");
        for(Movie movie : WatchList){
            System.out.println("\nTitle: " + movie.getTitle() + " | "
                    + "Released: " + movie.getYear() + " | "
                    + "Runtime: " + movie.getRuntime() + " | "
                    + "Director: " + movie.getDirector() + " | "
                    + "Imdb rating: " + movie.getImdbRating() + " | "
            );
        }
        System.out.println("-------------------------");
    }

    public static void addToWatchedMoviesList(Movie movie){
        WatchedMoviesList.add(movie);
    }

    
}
