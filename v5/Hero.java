import java.util.Stack;
//import java.util.ArrayList;

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

  public String toString() {
    String retVal = "";
    retVal += "Inventory: ";
    retVal += "[";
    for (int i = 0; i < _inventory.size(); i++){
      Item hold = _inventory.popItem;
      retVal += hold.getName();
      retVal += " ";
    }
    retVal += "]"
  }

}
