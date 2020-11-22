/**
 * Acts as an interface between
 * adding and subtracting values for the ToDoList
 * and sends the data to respective Observers.
 */
public class ListManager extends Publisher {
    private final GsonHandler gsonHandler = new GsonHandler();
    private final ToDoItem item = new ToDoItem();
    protected ToDoList toDoList = new ToDoList();
    private int iterator = 0;

    /**
     * Adds an instance of GsonHandler as a subscriber (observer)
     * to changes made in ListManager
     */
    public ListManager() {
        subscribers.add(gsonHandler);
    }

    /**
     * Populates the initial list of values from GsonHandler to be used in the GUI
     **/
    protected void initialPopulate(){
        gsonHandler.checkForFile();
        gsonHandler.readFromFile();
        for (String i:gsonHandler.getList().getItems()) {
            item.setDescription(i);
            item.setPriority(iterator);
            toDoList.addItem(item);
            iterator++;
        }
    }


    /**
     * Adds an Item of a set description at the last priority on the list,
     * notifying subscribers following the change.
     */
    protected void addValue(String description) {
        item.setDescription(description);
        item.setPriority(toDoList.getItems().size());
        toDoList.addItem(item);
        notifySubscribers();
        gsonHandler.list.addItem(item);
    }

    /**
     * Removes an Item at a certain priority,
     * notifying subscribers following the change.
     */
    protected void removeValue(int priority) {
        item.setPriority(priority);
        toDoList.removeItem(item);
        gsonHandler.list.removeItem(item);
        notifySubscribers();
    }

    protected ToDoList getManagedList() {
        return toDoList;
    }

    protected java.util.List<Observer> getPublisher() {
        return subscribers;
    }

}
