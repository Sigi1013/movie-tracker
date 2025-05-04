import java.util.ArrayList;

public class MovieManager {
    static private final ArrayList<Movie> WatchList = new ArrayList<>();
    static private final ArrayList<Movie> WatchedMoviesList = new ArrayList<>();

    public static void addToWatchList(Movie movie){
        WatchList.add(movie);
    }

    public static void getWatchList(){
        System.out.println("\nWatched Movies List.");
        for(Movie movie : WatchList){
            System.out.println("\nTitle: " + movie.getTitle() + " | "
                    + "Released: " + movie.getYear() + " | "
                    + "Runtime: " + movie.getRuntime() + " | "
                    + "Director: " + movie.getDirector() + " | "
                    + "Imdb rating: " + movie.getImdbRating() + " | "
            );
        }
    }

    public static void addToWatchedMoviesList(Movie movie){
        WatchedMoviesList.add(movie);
    }

    public static boolean getWatchedMoviesList(){
        if(WatchedMoviesList.isEmpty()){

            System.out.println("This list is empty. \n" +
                    "To add a movie, search for it use the number 1. option in main menu.");

            return false;
        }else{
            int index = 0;

            System.out.println("\nWatched Movies List.");

            for(Movie movie : WatchedMoviesList){
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

    public static void removeMovieWatchedList(int index){
        WatchedMoviesList.remove(index);
    }
}
