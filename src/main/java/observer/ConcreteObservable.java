package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete implementation of the Observable interface.
 * This class represents an observable object that can have observers and notify them of changes.
 */
public class ConcreteObservable implements Observable {
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Notifies all registered observers of a change in data.
     *
     * @param data the data to be sent to the observers
     */
    @Override
    public void notifyObservers(int data) {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer the observer to be added
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Deletes an observer from the list of observers.
     *
     * @param observer the observer to be removed
     */
    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }
}
