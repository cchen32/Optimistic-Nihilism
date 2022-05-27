public class Character{
  protected int _health;
  protected int _attack;

  public boolean isAlive(){
    return _health >= 0;
  }

  public void receiveAttack(int damage){
    _health = _health - damage;
  }

  public int attack(Character opponent){
    int damage = _attack;
    opponent.receiveAttack(damage);
    return damage;
  }
}
