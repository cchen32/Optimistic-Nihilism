import java.util.Scanner;

public class Game{
  Hero player = new Hero();
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";

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
      statement = ANSI_GREEN + "I detect no name. I shall call you " + player.getName() + "." + ANSI_RESET;
    }
    else{
      player = new Hero(response);
      statement = ANSI_GREEN + "Greetings, " + player.getName() + "." + ANSI_RESET;
    }
    return statement;
  }

  // Do you want to start the game?
  public void starting(String response){
    // no response
    if (response.trim().length() == 0){
      System.out.println(ANSI_RED + "\nI need a response!\n" + ANSI_RESET);
      Scanner in = new Scanner(System.in);
      String re0 = in.nextLine();
      starting(re0);
    }
    // refuse the game
    else if (findKeyword(response, "no") >= 0){
      System.out.println(ANSI_RED + "\nEnjoy your inevitable death." + ANSI_RESET);
      System.out.println("================================================");
    }
    // agreed to game
    else if (findKeyword(response, "yes") >= 0){
      System.out.println(ANSI_GREEN + "\nI wish you luck.\n" + ANSI_RESET);
      System.out.println("================================================");
      System.out.println(ANSI_GREEN + "Which level mystery would you like to challenge?\n" + ANSI_RESET);
      String a = ANSI_BLUE + "\n1) Level 0: Trial" + ANSI_RESET;
      String b = ANSI_BLUE + "\n2) Level 0: Trial Maze with one monster" + ANSI_RESET;
      String c = ANSI_BLUE + "\n3) Level 0: Trial Maze with Mentor" + ANSI_RESET;
      String d = ANSI_BLUE + "\n4) Level 0: Trial Maze with Sword" + ANSI_RESET;
      String e = ANSI_BLUE + "\n5) Level 1: The Start" + ANSI_RESET;
      String dir = ANSI_GREEN + "\n\nPlease input numbers (ie 1 for option one) as a valid response. Thank you!\n" + ANSI_RED;
      System.out.println(a + b + c + d + e + dir);
      mazeDecision();
    }
    // responses are not "yes" or "no"
    else{
      System.out.println(ANSI_RED + "\nI need a valid response.\n" + ANSI_RESET);
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
      System.out.println(ANSI_RED + "I need a response, please!\n" + ANSI_RESET);
      Scanner on = new Scanner(System.in);
      String re = on.nextLine();
      mazeDecision();
    }
    else if (findKeyword(res, "1") >= 0){
      askInstructions();
      System.out.println(ANSI_YELLOW + "\nGearing up Trial Maze 00" + ANSI_RESET);
      startGame("00.maze");
    }
    else if (findKeyword(res, "2") >= 0){
      System.out.println("================================================");
      System.out.println(ANSI_YELLOW + "\nGearing up Trial Maze 01" + ANSI_RESET);
      startGame("01.maze");
    }
    else if (findKeyword(res, "3") >= 0){
      System.out.println("================================================");
      System.out.println(ANSI_YELLOW + "\nGearing up Trial Maze 02" + ANSI_RESET);
      startGame("02.maze");
    }
    else if (findKeyword(res, "4") >= 0){
      System.out.println("================================================");
      System.out.println(ANSI_YELLOW + "\nGearing up Trial Maze 03" + ANSI_RESET);
      startGame("03.maze");
    }
    else if (findKeyword(res, "5") >= 0){
      System.out.println("================================================");
      System.out.println(ANSI_YELLOW + "\nGearing up Level 1" + ANSI_RESET);
      startGame("04.maze");
    }
    else{
      System.out.println(ANSI_RED + "That is not a choice. Please reconsider." + ANSI_RESET);
      mazeDecision();
    }
  }

  // Asking for further instructions in regards to how to run the maze in the case they did not read the instructions.
  public void askInstructions(){
    System.out.println(ANSI_GREEN + "\nWould you like to learn how to navigate the maze? Enter yes if so.\n" + ANSI_RESET);
    Scanner in = new Scanner(System.in);
    String res = in.nextLine();
    if (findKeyword(res, "yes") >= 0){
      System.out.println(ANSI_BLUE + "\nA guide to using controls:\n" + ANSI_RESET);
      System.out.println(ANSI_BLUE + "Pressing 'w' will go up" + ANSI_RESET);
      System.out.println(ANSI_BLUE + "Pressing 's' will go down" + ANSI_RESET);
      System.out.println(ANSI_BLUE + "Pressing 'd' will go left" + ANSI_RESET);
      System.out.println(ANSI_BLUE + "Pressing 'a' will go right\n" + ANSI_RESET);
      System.out.println(ANSI_YELLOW + "Good luck and may the odds be ever in your favor" + ANSI_RESET);
    }
    else if (findKeyword(res, "no") >= 0) {
      System.out.println(ANSI_YELLOW + "\nAlright best of luck, my friend." + ANSI_RESET);
    }
    else {
      System.out.println(ANSI_RED + "\nNot a choice. Yes or no?" + ANSI_RESET);
      askInstructions();
    }
    // System.out.println(ANSI_YELLOW + "\nGood luck and may the odds be ever in your favor." + ANSI_RESET);
    System.out.println("================================================");
  }

  // Start the maze
  public void startGame(String mazeFile){
    Maze challenge = new Maze(mazeFile);
    System.out.println(challenge);
    challenge.cont();
  }
}
