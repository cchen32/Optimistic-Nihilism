import java.util.Scanner;

public class Game{
  Hero player = new Hero();

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

  // Asks for the player's name
  public String heroName(String response){
    String statement = "";
    if (response.trim().length() == 0){
      statement = "I detect no name. I shall call you " + player.getName() + ".";
    }
    else{
      player = new Hero(response);
      statement = "Greetings, " + player.getName();
    }
    return statement;
  }

  // Do you want to start the game?
  public String starting(String response){
    String statement = "";
    // no response
    if (response.trim().length() == 0){
      System.out.println("\nI need a response!");
      // We need to recall the method so  that the conversation doesn't cut off after the empty response.
      Scanner in = new Scanner(System.in);
      String re0 = in.nextLine();
      return starting(re0);
    }
    // refuse the game
    else if (findKeyword(response, "no") >= 0){
      statement = "\nEnjoy your inevitable death.";
    }
    // agreed to game
    else if (findKeyword(response, "yes") >= 0){
      statement = "\nI wish you luck.";
      startGame();
    }
    // responses are not "yes" or "no"
    else{
      statement = "\nI need a valid response.";
    }
    return statement;
  }

  // Start the maze
  public String startGame(){
    // to be filled out after Maze.java is done
  }

  // Fight between the player and the monster until one side has died
  public void fight(Hero player, Monster mob){
    while (player.isAlive() && mob.isAlive()){
      player.attack(mob);
      if (mob.isAlive()){
        mob.attack(player);
      }
    }
    if (player.isAlive() && !mob.isAlive()){
      System.out.println("You have slain the monster!");
    }
    else if (mob.isAlive() && !player.isAlive()){
      System.out.println("K.O. Your journey ends here. RIP.");
    }
    else{
      System.out.println("Both sides have died. GG.");
    }
  }
}
