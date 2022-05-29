import java.util.Scanner;

public class Game{
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

  // Do you want to start the game?
  public String Starting(String response){
    String statement = "";
    // Scanner in = new Scanner(System.in);
    if (response.trim().length() == 0){
      statement = "\nI need a response!";
      // We need to recall the method so  that the conversation doesn't cut off after the empty response.
      Scanner in = new Scanner(System.in);
      String re0 = in.nextLine();
      Starting(re0);
    }
    else if (findKeyword(response, "no") >= 0){
      statement = "\nEnjoy your inevitable death.";
    }
    else if (findKeyword(response, "yes") >= 0){
      statement = "\nGreat! Let's get started!";
    }
    else{
      statement = "\nI need a valid response.";
    }
    return statement;
  }
}
