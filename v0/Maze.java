import java.io.*;
import java.util.*;

public class Maze{
  private char[][] _maze;
  private int h, w;
  private boolean validPath = true;
  private boolean reachExit = false;

  final private char HERO = "@";
  final private char PATH = "#";
  final private char WALL = " ";
  final private char EXIT = "$";

  public Maze(String inputFile){
    _maze = new char[80][25];
    h = 0;
    w = 0;
    // transcribing maze from file
    try{
      Scanner sc = new Scanner(new File(inputFile));
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
    } catch(Exception e) { System.out.println("Maze is corrupted."); }
  }

  public String toString(){
    String retStr = "[0;0H";
    int i, j;
    for (int i = 0; i < h; i++){
      for(j = 0; j < w; j++){
        retstr = retStr + _maze[j][i];
      }
      retStr = retStr + "\n";
    }
    return retStr;
  }

  // Get which column the player is on
  public int column(char[][] maze){
    int x;
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
    int y;
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
    if (response.trim() = "w"){
      checkPath(_maze, row + 1, column);
    }
    // left
    else if (response.trim() = "a"){
      checkPath(_maze, row, column - 1);
    }
    // down
    else if (response.trim() = "s"){
      checkPath(_maze, row - 1, column);
    }
    // right
    else if (response.trim() = "d"){
      checkPath(_maze, row, column + 1);
    }
  }

  // Check what the chosen path is like (x and y are the coordinates the player want to move to)
  public void checkPath(char[][] maze, int x, int y){
    if (maze[x][y] = WALL){
      validPath = false;
    }
    else if (maze[x][y] = EXIT){
      reachExit = true;
    }
    // use "else if" for more cases of chosen path (e.g. monster encounter)

    // move the player
    if (validPath){
      maze[row, column] = PATH;
      if (reachExit){
        System.out.println("YOU HAVE WON THE CHALLENGE!");
      }
      else{
        maze[x, y] = HERO;
      }
    }
    else{
      System.out.println("You cannot move on further.");
    }
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
