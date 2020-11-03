/**
 * Gets and sets values for the description
 * of a ToDoListItem and its priority
 */
public class ToDoItem {
    private String description;
    private int priority;

    public ToDoItem() {

        //leave empty
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
