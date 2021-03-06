import java.util.Stack;

public class Hero extends Character{
  private String _name;
  public Stack<Item> _inventory;

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

  // to add items to the inventory
  public void addItem(Item item){
    _inventory.push(item);
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

  // after using an item from the inventory, the effects wear off
  public void afterItemUse(Item currItem){
    _health -= currItem.getHealthBoost();
    _attack -= currItem.getAttackBoost();
  }
}
