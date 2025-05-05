import java.util.ArrayList;

public class MovieManager {
    static private final ArrayList<Movie> WatchMovieList = new ArrayList<>();
    static private final ArrayList<Movie> WatchedMoviesListHistory = new ArrayList<>();

    public static void addToWatchList(Movie movie){
        WatchMovieList.add(movie);
    }
    public static boolean getWatchList(){
        if(WatchMovieList.isEmpty()){

            System.out.println("This list is empty. \n" +
                    "To add a movie, search for it use the number 1. option in main menu.");

            return false;
        }else{
            int index = 0;

            System.out.println("\nWatch Movie List.");

            for(Movie movie : WatchMovieList){
                System.out.println("ID:" + index +" | Title: " + movie.getTitle() + " | "
                        + "Released: " + movie.getYear() + " | "
                        + "Runtime: " + movie.getRuntime() + " | "
                        + "Director: " + movie.getDirector() + " | "
                        + "Imdb rating: " + movie.getImdbRating() + " | "
                );
                index++;
            }

        }
        return true;
    }

    public static void removeMovieWatchList(int index){
        WatchMovieList.remove(index);
    }

    public static void addToWatchedMovieListHistory(Movie movie){
        WatchedMoviesListHistory.add(movie);
    }

    public static boolean getWatchedMoviesListHistory(){
        if(WatchedMoviesListHistory.isEmpty()){

            System.out.println("This list is empty. \n" +
                    "To add a movie, search for it use the number 1. option in main menu.");

            return false;
        }else{
            int index = 0;

            System.out.println("\nWatched Movie List.");

            for(Movie movie : WatchedMoviesListHistory){
                System.out.println("ID:" + index +" | Title: " + movie.getTitle() + " | "
                        + "Released: " + movie.getYear() + " | "
                        + "Runtime: " + movie.getRuntime() + " | "
                        + "Director: " + movie.getDirector() + " | "
                        + "Imdb rating: " + movie.getImdbRating() + " | "
                );
                index++;
            }

            }
        return true;
    }

    public static void removeMovieWatchedListHistory(int index){
        WatchedMoviesListHistory.remove(index);
    }
}
