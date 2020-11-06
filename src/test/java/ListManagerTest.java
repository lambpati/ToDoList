import org.junit.jupiter.api.Test;

class ListManagerTest {
    ListManager listManager = new ListManager();
    FileHandler fileHandler = new FileHandler();
    ToDoList testList = new ToDoList();
    ToDoItem item = new ToDoItem();

    void populate() {
        for (int i = 0; i < 10; i++) {
            item.setPriority(i);
            item.setDescription("Managed List value:" + i);
            testList.addItem(item);
            testList.notifySubscribers();
        }
    }


    @Test
    void initialPopulate() {
        fileHandler.writeToFile(testList);
        System.out.println(fileHandler.getfOutput());
        listManager.initialPopulate();
//        assertTrue(testList.getItems().isEmpty());


    }

    @Test
    void addValue() {
        listManager.addValue("Added Value!");
//        assertEquals(listManager.getManagedList().getItems(), fileHandler.getList().getItems());
    }

    @Test
    void removeValue() {
        listManager.removeValue(0);
//        assertEquals(listManager.getManagedList().getItems(),fileHandler.getList().getItems());
    }
}