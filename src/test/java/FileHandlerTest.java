import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FileHandlerTest {
    FileHandler handler = new FileHandler();
    ToDoItem item = new ToDoItem();
    ToDoList test = new ToDoList();

    void createListValues() {
        for (int i = 0; i < 10; i++) {
            item.setDescription("Active item: " + i);
            item.setPriority(i);
//            System.out.println(item.getDescription());
//            System.out.println(item.getPriority());
            test.addItem(item);
            test.notifySubscribers();
        }
    }

    @Test
    void writeToFile() {
        createListValues();
        handler.writeToFile(test);
//        System.out.println(handler.getfOutput());
        assertTrue(handler.getfOutput().contains(item.getDescription()));
    }

    @Test
    void readFromFile() {
        handler.readFromFile();
        writeToFile();
        handler.readFromFile();
//        System.out.println(handler.getList().getItems());
        assertEquals(handler.getList().getItems(), test.getItems());
    }
}