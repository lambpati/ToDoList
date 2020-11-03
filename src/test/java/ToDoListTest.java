import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ToDoListTest {
    ToDoList testList = new ToDoList();
    ToDoItem item = new ToDoItem();

    void setItem() {
        item.setPriority(0);
        item.setDescription("String at priority 0");
    }

    @Test
    void addItem() {
        setItem();
        testList.addItem(item);
        assertEquals(testList.getItems().get(0), item.getDescription());
    }

    @Test
    void removeItem() {
        addItem();
        testList.removeItem(item);
        assertTrue(testList.getItems().isEmpty());
    }

    @Test
    void clear() {
        addItem();
        testList.clear();
        assertTrue(testList.getItems().isEmpty());
    }
}