public class Hero extends Character{
  private String _name;
  public Hero(){
    _health = 1000;
    _attack = 300;
  }

  public Hero(String name){
    this();
    _name = name;
  }

  public String getName(){
    return _name;
  }
}
