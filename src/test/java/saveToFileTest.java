import com.google.gson.Gson;
import org.junit.jupiter.api.Test;


class saveToFileTest {
    saveToFile handler = new saveToFile();
    ToDoItem item = new ToDoItem();
    ToDoList test = new ToDoList();
    Gson gson = new Gson();

    void createListValues() {
        for (int i = 0; i < 10; i++) {
            item.setDescription("Active item: " + i);
            item.setPriority(i);
            System.out.println(item.getDescription());
            System.out.println(item.getPriority());
            test.addItem(item);
            test.notifySubscribers();
        }
    }

    @Test
    void writeToFile() {
        createListValues();
    }
}