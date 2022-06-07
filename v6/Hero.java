import java.util.Stack;
import java.util.Scanner;

public class Hero extends Character{
  private String _name;
  Stack<Item> _inventory = new Stack();

  public Hero(){
    _health = 1000;
    _attack = 300;
    _name = "The Chosen One";
  }

  public Hero(String name){
    _health = 1000;
    _attack = 300;
    _name = name;
  }

  public String getName(){
    return _name;
  }

  public boolean emptyInventory(){
    return _inventory.empty();
  }

  // to add items to the inventory
  public Item addItem(Item item){
    return _inventory.push(item);
  }

  // to peek at what you last add to the inventory
  public Item peekInventory() {
    return _inventory.peek();
  }

  // use an item from the inventory (which give certain boosts)
  public Item useItem(){
    Item currItem = _inventory.peek();
    _health += currItem.getHealthBoost();
    _attack += currItem.getAttackBoost();
    return _inventory.pop();
  }

  public Item popItem(){
    return _inventory.pop();
  }

  // after using an item from the inventory, the effects wear off
  public void afterItemUse(Item currItem){
    _health -= currItem.getHealthBoost();
    _attack -= currItem.getAttackBoost();
  }

  public void askAttack(){
    System.out.println("Your choices are: elbow, punch, kick, poke, pinch, tickle.");
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();
    if (findKeyword(response, "elbow") >= 0){

    }
    else if (findKeyword(response, "punch") >= 0){

    }
    else if (findKeyword(response, "kick") >= 0){

    }
    else if (findKeyword(response, "poke") >= 0){

    }
    else if (findKeyword(response, "pinch") >= 0){

    }
    else if (findKeyword(response, "tickle") >= 0){

    }
    else {
      System.out.println("We will resort to default attack.");
    }
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
}
