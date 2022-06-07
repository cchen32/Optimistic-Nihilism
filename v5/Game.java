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
      System.out.println("Which level mystery would you like to challenge?\n");
      String a = "\n1) Level 0: Trial";
      String b = "\n2) Level 0: Trial Maze with one monster";
      String c = "\n3) Level 0: Trial Maze with Mentor";
      String d = "\n4) Level 0: Trial Maze with Sword";
      String dir = "\n\nPlease input numbers (ie 1 for option one) as a valid response. Thank you!\n";
      System.out.println(a + b + c + d + dir);
      mazeDecision();
    }
    // responses are not "yes" or "no"
    else{
      System.out.println("\nI need a valid response.\n");
      Scanner in1 = new Scanner(System.in);
      String re1 = in1.nextLine();
      starting(re1);
    }
  }
  // Choose maze level
  public void mazeDecision(){
    // System.out.println("Which level mystery would you like to challenge?\n");
    Scanner in = new Scanner(System.in);
    String res = in.nextLine();
    if (res.trim().length() == 0){
      System.out.println("I need a response, please!\n");
      Scanner on = new Scanner(System.in);
      String re = on.nextLine();
      mazeDecision();
    }
    else if (findKeyword(res, "1") >= 0){
      System.out.println("Gearing up Trial Maze 00");
      startGame("00.maze");
    }
    else if (findKeyword(res, "2") >= 0){
      System.out.println("Gearing up Trial Maze 01");
      startGame("01.maze");
    }
    else if (findKeyword(res, "3") >= 0){
      System.out.println("Gearing up Trial Maze 02");
      startGame("02.maze");
    }
    else if (findKeyword(res, "4") >= 0){
      System.out.println("Gearing up Trial Maze 03");
      startGame("03.maze");
    }
  }

  // Start the maze
  public void startGame(String mazeFile){
    Maze challenge = new Maze(mazeFile);
    //challenge.continueMaze();
    System.out.println(challenge);
    challenge.cont();
  }
}
