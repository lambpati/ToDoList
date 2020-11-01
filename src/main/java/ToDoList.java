import java.util.ArrayList;
import java.util.List;

public class ToDoList extends Item {
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
}
