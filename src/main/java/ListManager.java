/**
 * Acts as an interface between
 * adding and subtracting values for the ToDoList
 * and sends the data to respective Observers.
 */
public class ListManager extends Publisher {
    private final FileHandler fileHandler = new FileHandler();
    private final ToDoItem item = new ToDoItem();
    protected ToDoList toDoList = new ToDoList();
    private int iterator = 0;

    public ListManager() {
        subscribers.add(fileHandler);
    }

    protected void initialPopulate() {
        fileHandler.readFromFile();
        try {
            for (String i : fileHandler.getList().getItems()) {
                item.setPriority(iterator);
                item.setDescription(i);
                toDoList.addItem(item);
                iterator++;
            }
        } catch (NullPointerException e) {
            System.out.println("Empty List!");
        }
    }

    protected void addValue(String description) {
        item.setDescription(description);
        item.setPriority(toDoList.getItems().size());
        toDoList.addItem(item);
        notifySubscribers();
    }

    protected void removeValue(int priority) {
        item.setPriority(priority);
        toDoList.removeItem(item);
        notifySubscribers();
    }

    protected ToDoList getManagedList() {
        return toDoList;
    }

    protected java.util.List<Observer> getPublisher() {
        return subscribers;
    }

}
