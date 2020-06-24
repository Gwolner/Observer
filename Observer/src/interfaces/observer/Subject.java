package interfaces.observer;

import interfaces.observer.Observer;


public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
