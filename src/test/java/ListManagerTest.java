import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test by populating an initial list of values, then adding and subtracting
 * values to the list, asserting that the ToDoList and the test list match values.
 */
class ListManagerTest {
    ListManager listManager = new ListManager();
    GsonHandler gsonHandler = new GsonHandler();
    ToDoList testList = new ToDoList();
    ToDoItem item = new ToDoItem();
    File file = new File("save.txt");

    /**
     * Creates an initial population of "Managed List values" items and then
     * add them to a testList, notifying subscribers of changes.
     */
    void populate() {
        for (int i = 0; i < 10; i++) {
            item.setPriority(i);
            item.setDescription("Managed List value:" + i);
            testList.addItem(item);
            testList.notifySubscribers();
        }
    }

    /**
     * Creates an initial population of the list, writing the values to file and asserting
     * the initial values match the values written to file and pushed to the ListManager.
     */
    @Test
    void initialPopulate() {
        populate();
        gsonHandler.list = testList;
        gsonHandler.writeToFile();
//        System.out.println(gsonHandler.getfOutput());
//        System.out.println(gsonHandler.getfOutput());
        listManager.initialPopulate();
        listManager.notifySubscribers();
        System.out.println(gsonHandler.getList().getItems());
        System.out.println(listManager.toDoList.getItems());
        assertEquals(gsonHandler.getList().getItems(), listManager.toDoList.getItems());


    }

    /**
     * Adds a value of "Addded Value!" to the ListManager and checks that it also
     * published to the file in Gson form.
     */
    @Test
    void addValue() {
        initialPopulate();
        listManager.addValue("Added Value!");
        gsonHandler.list = listManager.toDoList;
//        item.setPriority(10);
//        item.setDescription("Added Value!");
//        gsonHandler.list.addItem(item);
        listManager.notifySubscribers();
        System.out.println(gsonHandler.list.getItems());
        System.out.println(listManager.toDoList.getItems());
        assertEquals(listManager.getManagedList().getItems(), gsonHandler.getList().getItems());
    }

    /**
     * Removes a value at index 0 and then checks that the list manager and
     * the Gson match up.
     */
    @Test
    void removeValue() {
        initialPopulate();
        listManager.removeValue(0);
        gsonHandler.list = listManager.toDoList;
        assertEquals(listManager.getManagedList().getItems(),gsonHandler.getList().getItems());
        file.delete();

    }
}