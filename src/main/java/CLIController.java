import java.util.Scanner;

public class CLIController {
    private boolean menuOpen = true;
    private final Scanner userInput = new Scanner(System.in);
    private final ApiClient apiClient = new ApiClient();

    public void startMenu() {
        while (menuOpen) {
            System.out.println("\n-------------------------");
            System.out.println("1. Search for movies");
            System.out.println("2. Watchlist");
            System.out.println("3. Watched movies");
            System.out.println("0. Exit.");
            System.out.println("-------------------------");

            System.out.print("Enter a number to choose an option: ");
            String menuOption = userInput.nextLine();

            switch (menuOption) {
                case "1" -> {
                    System.out.print("Enter the name of the film to search: ");
                    String searchInput = userInput.nextLine();
                    addMovieToListMenu(
                            apiClient.fetchMovieDetails(searchInput.replace(" ", "+"))
                    );
                }

                case "2" -> handleWatchListMovieRemoval(
                        MovieManager.getWatchList()
                );

                case "3" -> handleWatchedMovieRemoval(
                        MovieManager.getWatchedMoviesListHistory()
                );

                case "0" -> menuOpen = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }

        userInput.close();
        System.out.println("Exiting program...");
    }

    public void addMovieToListMenu(Movie movie) {
        boolean addMenuOpen = true;
        while (addMenuOpen) {
            System.out.println("\n-------------------------");
            System.out.println("1. Add movie to watchlist");
            System.out.println("2. Add movie to watched movie list");
            System.out.println("0. Go back");
            System.out.println("-------------------------");

            System.out.print("Enter a number to choose an option: ");
            String menuOption = userInput.nextLine();

            switch (menuOption) {
                case "1" -> {
                    System.out.println("Movie added to watchlist.");
                    MovieManager.addToWatchList(movie);
                    addMenuOpen = false;
                }
                case "2" -> {
                    System.out.println("Movie marked as watched.");
                    MovieManager.addToWatchedMovieListHistory(movie);
                    addMenuOpen = false;
                }
                case "0" -> addMenuOpen = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }
    public void handleWatchedMovieRemoval(boolean isListEmpty){
        if(isListEmpty){
            boolean addMenuOpen = true;

            while (addMenuOpen) {
                showRemoveMovieMenu();
                String menuOption = userInput.nextLine();

                switch (menuOption) {
                    case "1" -> {
                        System.out.print("Enter a number of the movie to remove it: ");
                        MovieManager.removeMovieWatchedListHistory(Integer.parseInt(userInput.nextLine()));

                        System.out.println("Movie has been removed from the list!");
                        addMenuOpen = false;
                    }

                    case "0" -> addMenuOpen = false;
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        }
    }

    public void handleWatchListMovieRemoval(boolean isListEmpty){
        if(isListEmpty){
            boolean addMenuOpen = true;

            while (addMenuOpen) {
                showRemoveMovieMenu();
                String menuOption = userInput.nextLine();

                switch (menuOption) {
                    case "1" -> {
                        System.out.print("Enter a number of the movie to remove it: ");
                        MovieManager.removeMovieWatchList(Integer.parseInt(userInput.nextLine()));

                        System.out.println("Movie has been removed from the list!");
                        addMenuOpen = false;
                    }

                    case "0" -> addMenuOpen = false;
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        }
    }

    public void showRemoveMovieMenu(){
        System.out.println(" \n-------------------------");
        System.out.println("1. Remove a movie from Watched list");
        System.out.println("0. Go back");
        System.out.println("-------------------------");
        System.out.print("Enter a number to choose an option: ");
    }
}
