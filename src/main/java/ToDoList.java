import java.util.ArrayList;
import java.util.List;

public class ToDoList extends Publisher {
    List<ToDoItem> items;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public void addItem(ToDoItem i) {
        items.add(i);
        notifySubscribers();
    }

    public void removeItem(ToDoItem i) {
        items.remove(i);
        notifySubscribers();
    }

    public void clear() {
        items.clear();
        notifySubscribers();
    }

    public List<ToDoItem> getItems() {
        return items;
    }
}
