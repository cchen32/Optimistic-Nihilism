public class Item{
  // Instance variables
  protected int _healthBoost;
  protected int _attackBoost;
  protected String _name;

  // constructor
  public Item(){
    _healthBoost = 0;
    _attackBoost = 0;
    _name = "Special Item";
  }

  // Overridden constructor with health and attack
  public Item(int health, int attack, String name){
    _healthBoost = health;
    _attackBoost = attack;
    _name = name;
  }

  // Getting health boost
  public int getHealthBoost(){
    return _healthBoost;
  }

  // Getting attack boosts
  public int getAttackBoost(){
    return _attackBoost;
  }

  // Getting weapon name
  public String getName(){
    return _name;
  }

  // everything you need to know about the item
  public String itemInfo() {
    String str = "";
    str += "The health boost of this item is " + _healthBoost;
    str += "The attack boost of this item is " + _attackBoost;
    return str;
  }

  // @Override
  // public String toString(){
  //   return this.getName();
  // }

}
