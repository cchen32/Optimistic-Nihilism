import java.util.Stack;

public class Hero extends Character{
  private String _name;
  private Item[] _inventory;

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

  public void addItem(Item item){
    _inventory.push(item);
  }

  public Item useItem(){
    return _inventory.pop();
  }
}
