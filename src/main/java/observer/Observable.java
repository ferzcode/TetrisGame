package observer;

/**
 * An interface representing an observable object.
 * Objects implementing this interface can be observed by other objects, called observers.
 */
public interface Observable {

    /**
     * Notifies all registered observers of a change in data.
     *
     * @param data the data to be sent to the observers
     */
    void notifyObservers(int data);

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer the observer to be added
     */
    void addObserver(Observer observer);

    /**
     * Deletes an observer from the list of observers.
     *
     * @param observer the observer to be removed
     */
    void deleteObserver(Observer observer);
}
