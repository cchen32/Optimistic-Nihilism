public class Item{
  // Instance variables
  private int _healthBoost;
  private int _attackBoost;

  // constructor
  public Item(){
    _healthBoost = 0;
    _attackBoost = 0;
  }

  // Overridden constructor with health and attack
  public Item(int health, int attack){
    _healthBoost = health;
    _attackBoost = attack;
  }

  // Getting health boost
  public int getHealthBoost(){
    return _healthBoost;
  }

  // Getting attack boosts
  public int getAttackBoost(){
    return _attackBoost;
  }

  // everything you need to know about the item
  public String itemInfo() {
    String str = "";
    str += "The health boost of this item is " + _healthBoost;
    str += "The attack boost of this item is " + _attackBoost;
    return str;
  }

}
