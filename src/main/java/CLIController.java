import java.util.Scanner;

public class CLIController {
    private boolean menuOpen = true;
    private final Scanner userInput = new Scanner(System.in);
    private final ApiClient apiClient = new ApiClient();

    public void startMenu() {
        while (menuOpen) {
            System.out.println("-------------------------");
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
                    apiClient.fetchMovieDetails(searchInput.replace(" ", "+"));
                }
                case "0" -> menuOpen = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }

        userInput.close();
        System.out.println("Exiting program...");
    }
}