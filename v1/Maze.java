import java.io.*;
import java.util.*;

public class Maze{
  public char[][] _maze;
  private int h, w;
  public boolean validPath = true;
  public boolean reachExit = false;

  final private char HERO = '@';
  final private char PATH = '#';
  final private char WALL = ' ';
  final private char EXIT = '$';

  public Maze(){//(String inputFile){
    _maze = new char[80][25];
    h = 0;
    w = 0;

    try{
      File myMaze = new File("00.maze");
      Scanner sc = new Scanner(myMaze);
      int row = 0;
       while (sc.hasNext()){
         String line = sc.nextLine();
         if (w < line.length()){
           w = line.length();
         }
         for (int i = 0; i < line.length(); i++){
           _maze[i][row] = line.charAt(i);
         }
         h++;
         row++;
       }
       for (int i = 0; i < w; i++){
         _maze[i][row] = WALL;
       }
       h++;
       row++;
    } catch(Exception e) { System.out.println("Thick fog surround the maze, you cannot go through."); }
  }

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

  public String toString(){
    String retStr = "";//"[0;0H";
    int i, j;
    for (i = 0; i < h; i++){
      for(j = 0; j < w; j++){
        retStr = retStr + _maze[j][i];
      }
      retStr = retStr + "\n";
    }
    return retStr;
  }

  // Get which column the player is on
  public int column(char[][] maze){
    int x = 6;
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        if (maze[i][j] == HERO){
          x = j;
        }
      }
    }
    return x;
  }

  // Get which row the player is on
  public int row(char[][] maze){
    int y = 4;
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        if (maze[i][j] == HERO){
          y = i;
        }
      }
    }
    return y;
  }

  // Asks the player to go to which direction
  public void askDirection(){
    System.out.println("Choose a path.");
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();
    // up
    if (findKeyword(response, "w") >= 0){
      checkPath(_maze, row(_maze), column(_maze) - 1);
    }
    // left
    else if (findKeyword(response, "a") >= 0){
      checkPath(_maze, row(_maze) - 1, column(_maze));
    }
    // down
    else if (findKeyword(response, "s") >= 0){
      checkPath(_maze, row(_maze), column(_maze) + 1);
    }
    // right
    else if (findKeyword(response, "d") >= 0){
      checkPath(_maze, row(_maze) + 1, column(_maze));
    }
    else {
      System.out.println("Not an available option.");
    }
  }

  // Check what the chosen path is like (x and y are the coordinates the player want to move to)
  public void checkPath(char[][] maze, int x, int y){
    if (maze[x][y] == WALL){
      validPath = false;
    }
    else if (maze[x][y] == EXIT){
      reachExit = true;
    }
    else if (maze[x][y] == PATH){
      validPath = true;
      reachExit = false;
    }
    // use "else if" for more cases of chosen path (e.g. monster encounter)

    // move the player
    if (validPath && reachExit){
      maze[row(maze)][column(maze)] = PATH;
      System.out.println(this);
      System.out.println("YOU HAVE WON THE CHALLENGE!");
    }
    else if (validPath && !reachExit){
      maze[row(maze)][column(maze)] = PATH;
      maze[x][y] = HERO;
      System.out.println(this);
    }
    else{
      System.out.println("You cannot move on further.");
    }
  }

  public boolean solved(){
    return reachExit;
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
