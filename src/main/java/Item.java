import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    List<Observer> subscribers;

    public Item() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Observer o) {
        if (o != null && !subscribers.contains(o)) {
            subscribers.add(o);
        }
    }

    public void unsubscribe(Observer o) {
        if (o != null) {
            subscribers.remove(o);
        }
    }

    public void notifySubscribers() {
        subscribers.forEach(Observer::notifyObservers);
    }
}
