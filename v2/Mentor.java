public class Mentor{
  private String _name;
  private String _message;

  public Mentor(String name, String message){
    _name = name;
    _message = message;
  }

  public String getName(){
    return _name;
  }

  public String getMessage(){
    return _message;
  }

  public String annoyingSpeech(){
    return "Greetings, oh traveller. You hath come across I, " + _name + "."
  }
}
