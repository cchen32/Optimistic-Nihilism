import java.util.Scanner;

public class Game{
  Hero player = new Hero();

// -----------------------Helpers----------------------------| Start

  public int findKeyword(String statement, String goal, int startPos){
    String phrase = statement.trim().toLowerCase();
    goal = goal.toLowerCase();

    int psn = phrase.indexOf(goal, startPos);

    while (psn >= 0){
      String before = " ", after = " ";
      if (psn > 0){
        before = phrase.substring(psn - 1, psn);
      }
      if (psn + goal.length() < phrase.length()){
        after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
      }
      if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
      && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))){
        return psn;
      }
      psn = phrase.indexOf(goal, psn + 1);
    }
    return -1;
  }

  public int findKeyword(String statement, String goal){
    return findKeyword(statement, goal, 0);
  }
// -----------------------Helpers----------------------------| End



// -----------------------Methods----------------------------| Start

  // Asks for the player's name
  public String heroName(String response){
    String statement = "";
    if (response.trim().length() == 0){
      statement = "I detect no name. I shall call you " + player.getName() + ".";
    }
    else{
      player = new Hero(response);
      statement = "Greetings, " + player.getName() + ".";
    }
    return statement;
  }

  // Do you want to start the game?
  public void starting(String response){
    // no response
    if (response.trim().length() == 0){
      System.out.println("\nI need a response!\n");
      Scanner in = new Scanner(System.in);
      String re0 = in.nextLine();
      starting(re0);
    }
    // refuse the game
    else if (findKeyword(response, "no") >= 0){
      System.out.println("\nEnjoy your inevitable death.");
    }
    // agreed to game
    else if (findKeyword(response, "yes") >= 0){
      System.out.println("\nI wish you luck.\n");
      startGame();
    }
    // responses are not "yes" or "no"
    else{
      System.out.println("\nI need a valid response.\n");
      Scanner in1 = new Scanner(System.in);
      String re1 = in1.nextLine();
      starting(re1);
    }
  }

  // Start the maze
  public void startGame(){
    Maze challenge = new Maze();
    //challenge.continueMaze();
    System.out.println(challenge);
    while (!challenge.solved() && player.isAlive()){
      //System.out.println(challenge);
      if (player.isAlive()){
        challenge.askDirection();
      }
    }
  }
}
