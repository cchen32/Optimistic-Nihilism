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
  public String Starting(String statement){
    String response = "";
    if (statement.trim().length() == 0){
      response = "I need a response!";
    }
    else if (findKeyword(statement, "no") >= 0){
      response = "Enjoy your inevitable death.";
    }
    else if (findKeyword(statement, "yes") >= 0){
      response = "Great! Let's get started!";
    }
    else{
      response = "I need a valid response.";
    }
    return response;
  }
}
