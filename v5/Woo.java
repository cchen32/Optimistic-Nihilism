import java.util.Scanner;

public class Woo {
  // Launch pad

  public static void main(String[] args) {
    Game rpg = new Game();

    // Greet the travellers/explorers
    System.out.println("\nWelcome, Explorer, to the Mysterious Cave of the Unknown.\n");

    // Asks for the player's name
    System.out.println("What is your name, chosen hero?\n");
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();
    System.out.println("\n" + rpg.heroName(response) + "\n");

    // Asks if player wants to play. Valid responses are "yes" and "no"
    System.out.println("Do you wish to procede?\n");
    response = in.nextLine();
    rpg.starting(response);
  }
}
