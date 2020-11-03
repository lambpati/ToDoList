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
            test.addItem(item);
            test.notifySubscribers();
        }
    }

    @Test
    void writeToFile() {
        createListValues();
        handler.writeToFile(test);
//        System.out.println(handler.list.items.get(0));

    }
}