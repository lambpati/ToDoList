import org.junit.jupiter.api.Test;

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
    }

    @Test
    void removeItem() {
    }

    @Test
    void clear() {
    }

    @Test
    void getItem() {
    }
}