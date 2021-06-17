package BusinessLayer.Interfaces.ObserverPattern;

import BusinessLayer.Interfaces.ObserverPattern.Observer;

public interface Observable {
    public void SignUp(Observer observer);
    public void NotifyObservers();
}
