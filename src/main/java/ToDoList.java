import java.util.ArrayList;
import java.util.List;

/**
 * Creates a ToDoList of Items and adds items or removes them
 * notifying subscribers of the changes each time.
 */
public class ToDoList extends Publisher {
    private final List<String> items;

    /** Constructs a new ArrayList of ToDoItems */
    public ToDoList() {
        items = new ArrayList<>();
    }

    /** Adds items to the ToDoList */
    public void addItem(ToDoItem i) {
        items.add(i.getPriority(), i.getDescription());
        notifySubscribers();
    }

    /** Removes items from the ToDoList */
    public void removeItem(ToDoItem i) {
        items.remove(i.getPriority());
        notifySubscribers();
    }

    /** Clears the ToDoList of items */
    public void clear() {
        items.clear();
        notifySubscribers();
    }

    public List<String> getItems() {
        return items;
    }
}
