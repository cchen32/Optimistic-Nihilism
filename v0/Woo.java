import java.util.Scanner;

public class Woo {
  // Launch pad

  public static void main(String[] args) {
    Game rpg = new Game();

    // Greet the travellers/explorers
    System.out.println("\nWelcome, Explorers, to the Mysterious Cave of the Unknown.\n");

    // Asks if player wants to play. Valid responses are "yes" and "no"
    System.out.println("Do you wish to procede?\n");
    Scanner in = new Scanner(System.in);
    String statement = in.nextLine();
    System.out.println(rpg.Starting(statement));
  }
}
