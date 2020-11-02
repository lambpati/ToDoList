import org.junit.jupiter.api.Test;

class FileHandlerTest extends ActiveArchivedLists {
    FileHandler handler = new FileHandler();
    String description;
    int priority;
    ToDoItem item = new ToDoItem(description, priority);

    void createListValues() {
        for (int i = 0; i < 10; i++) {
            description = ("Active item: " + i);
            priority = i;
            active.addItem(item);
            active.notifySubscribers();

            description = ("Archived item: " + i);
            priority = i;
            archived.addItem(item);
            archived.notifySubscribers();

        }
    }

    @Test
    void writeToFile() {
        createListValues();
        handler.writeToFile(active);
        handler.writeToFile(archived);
        active.clear();
        archived.clear();
    }

    @Test
    void readFromFile() {
        writeToFile();
//        handler.readFromFile("active");
//        handler.readFromFile("archived");
        System.out.println(active);
        System.out.println(archived);
    }
}