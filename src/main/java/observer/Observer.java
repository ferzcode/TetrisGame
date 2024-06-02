package observer;

/**
 * An interface representing an observer object.
 * Objects implementing this interface can observe changes in observable objects.
 */
public interface Observer {

    /**
     * This method is called by the observable object whenever it has changed state.
     *
     * @param data the data associated with the update
     */
    void update(int data);
}
