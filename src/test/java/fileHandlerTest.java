import com.google.gson.Gson;
import org.junit.jupiter.api.Test;


class fileHandlerTest {
    fileHandler handler = new fileHandler();
    ToDoItem item = new ToDoItem();
    ToDoList test = new ToDoList();
    Gson file = new Gson();
    ToDoList outputF = new ToDoList();

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
        handler.writeToFile(test);
        System.out.println(handler.getfOutput());
    }
}