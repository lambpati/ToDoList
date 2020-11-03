import java.util.ArrayList;
import java.util.List;

/**
 * Adds subscribers to observe ButtonHandler specifically
 */
public abstract class Publisher {
    List<Observer> subscribers;

    /**Constructs a new ArrayList of subscribers */
    public Publisher() {
        subscribers = new ArrayList<>();
    }

    /** Adds a new subscriber to the list of Observers */
    public void subscribe(Observer o) {
        if (o != null && !subscribers.contains(o)) {
            subscribers.add(o);
        }
    }

    /** Unsubscribes something from the list of Observers */
    public void unsubscribe(Observer o) {
        if (o != null) {
            subscribers.remove(o);
        }
    }

    /** Notifies the subscribers in a change of the Publisher */
    public void notifySubscribers() {
        subscribers.forEach(Observer::notifyObservers);
    }
}
