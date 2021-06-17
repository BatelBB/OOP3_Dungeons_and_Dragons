package BusinessLayer.Interfaces;

public interface Observable {
    public void SignUp(Observer observer);
    public void NotifyObservers();
}
