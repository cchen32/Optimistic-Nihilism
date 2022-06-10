public class Dragon extends Monster{
  protected int _scale;

  public Dragon() {
    super();
    _scale = 128;
  }

  public int getScale(){
    return _scale;
  }

  public void receiveAttack(int damage){
    _health = _health - (damage + _scale);
  }
}
