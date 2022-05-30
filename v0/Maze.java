public class Maze{
  private char[][] _maze;
  private int h, w;

  final private char HERO = "";
  final private char PATH = "";
  final private char WALL = "";
  final private char EXIT = "";

  public String toString(){
    String retStr = "[0;0H";
    int i, j;
    for (int i = 0; i < h; i++){
      for(j = 0; j < w; j++){
        retstr = retStr + _maze[j][i];
      }
      retStr = retStr + "\n";
    }
    return retStr;
  }

  // Asks the player to go to which direction
  public String askDirection(){
    // to be filled out
  }

  // Encounters a monster
  public void monsterEncounter(/* probably takes in monster type*/){
    // to be filled out
  }

  // Encounters a mentor
  public void mentorEncounter(/* takes in mentor type*/) {
    // to be filled out 
  }
}
