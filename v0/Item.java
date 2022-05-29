public class Item{
  private int _healthBoost;
  private int _attackBoost;

  public Item(){
    _healthBoost = 0;
    _attackBoost = 0;
  }

  public Item(int health, int attack){
    _healthBoost = health;
    _attackBoost = attack;
  }

  public int getHealthBoost(){
    return _healthBoost;
  }

  public int getAttackBoost(){
    return _attackBoost;
  }
}
