// Optimistic-Nihilism
// Corina Chen (Binktop) and Nicole Zhou (Duck)

import java.util.Scanner;
// import java.util.concurrent.TimeUnit;

public class Woo {
  // Launch pad
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public static void main(String[] args) {
    Game rpg = new Game();

    // Greet the travellers/explorers
    // System.out.println("\nWelcome, Explorer, to the Mysterious Cave of the Unknown.\n");
    System.out.println(ANSI_GREEN + "\nWelcome, Explorer, to the Mysterious Cave of the Unknown." + ANSI_RESET);


    // Asks for the player's name
    System.out.println(ANSI_GREEN + "What is your name, chosen hero?\n" + ANSI_RESET);
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();
    System.out.println("\n" + rpg.heroName(response));

    // Asks if player wants to play. Valid responses are "yes" and "no"
    System.out.println(ANSI_GREEN + "Do you wish to procede?\n" + ANSI_RESET);
    response = in.nextLine();
    // System.out.println("==========================================================");
    rpg.starting(response);
  }
}
